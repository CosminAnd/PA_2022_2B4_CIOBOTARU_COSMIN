import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Game {
    final MainFrame mainFrame;
    final DrawingPanel canvas;
    final List<Node> stones;
    int turn;
    int player1Stones = 0;
    int player2Stones = 0;
    int rows;
    int cols;


    Game(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.stones = mainFrame.canvas.getStones();
        this.canvas = mainFrame.canvas;
        rows = this.mainFrame.configPanel.getRows();
        cols = this.mainFrame.configPanel.getCols();
    }

    public void play() {
        turn = 0;
        final int[] currentStone = new int[1];
        final int[] mouseX = {0};
        final int[] mouseY = {0};
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX[0] = e.getX();
                mouseY[0] = e.getY();
                Graphics g = canvas.getGraphics();
                currentStone[0] = checkIsInStone(mouseX[0], mouseY[0]);
                if (currentStone[0] != -1) {
                    if (turn == 0) {
                        g.setColor(Color.blue);
                        turn = 1;

                        player1Stones++;
                        stones.get(currentStone[0]).setColor(0);
                    } else {
                        g.setColor(Color.red);
                        turn = 0;

                        player2Stones++;
                        stones.get(currentStone[0]).setColor(1);
                    }
                    int x, y, size;
                    x = stones.get(currentStone[0]).getX() - stones.get(currentStone[0]).getStoneSize() / 2;
                    y = stones.get(currentStone[0]).getY() - stones.get(currentStone[0]).getStoneSize() / 2;
                    size = stones.get(currentStone[0]).getStoneSize();
                    g.drawOval(x, y, size, size);
                    g.fillOval(x, y, size, size);

                    if (endOfGame(player1Stones, player2Stones)) {
                        JDialog dialog = new JDialog();
                        dialog.setLayout(new FlowLayout());
                        dialog.setBounds(25, 150, 350, 100);

                        JLabel winner = new JLabel();
                        if (turn == 0) {
                            winner.setText("Red wins!");
                        } else {
                            winner.setText("Blue wins!");
                        }
                        dialog.add(winner);
                        dialog.setVisible(true);
                    }
                }
            }
        });
    }

    private int checkIsInStone(int mouseX, int mouseY) {
        for (int i = 0; i < stones.size(); i++)
            if (stones.get(i).getX() + 10 > mouseX && stones.get(i).getX() - 10 < mouseX && stones.get(i).getY() + 10 > mouseY && stones.get(i).getY() - 10 < mouseY && stones.get(i).getColor() == -1) {
                return i;
            }
        return -1;
    }

    private boolean endOfGame(int player1StoneCount, int player2StoneCount) {
        return player1StoneCount + player2StoneCount == stones.size();
    }

    public void save() {
        try {
            Writer writer = new FileWriter("save.txt");
            writer.write(rows + " ");
            writer.write(cols + "\n");
            writer.write(turn + "\n");
            writer.write(player1Stones + " ");
            writer.write(player2Stones + "\n");
            writer.write(stones.size() + "\n");
            for (Node node : stones) {
                writer.write(node.getX() + " ");
                writer.write(node.getY() + " ");
                writer.write(node.getColor() + "\n");
            }
            for (Stick stick : this.canvas.getSticks()) {
                writer.write(stick.getFirst().getX() + " ");
                writer.write(stick.getFirst().getY() + " ");
                writer.write(stick.getSecond().getX() + " ");
                writer.write(stick.getSecond().getY() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            Scanner scanner = new Scanner(new File("save.txt"));
            String[] data;
            String line;
            line = scanner.nextLine();
            data = line.split(" ");
            this.canvas.setRows(Integer.parseInt(data[0]));
            this.canvas.setCols(Integer.parseInt(data[1]));
            line = scanner.nextLine();
            turn = Integer.parseInt(line);
            line = scanner.nextLine();
            data = line.split(" ");
            player1Stones = Integer.parseInt(data[0]);
            player2Stones = Integer.parseInt(data[1]);
            line = scanner.nextLine();
            int size = Integer.parseInt(line);

            //stones
            stones.clear();
            for (int i = 0; i < size; i++) {
                line = scanner.nextLine();
                data = line.split(" ");
                stones.add(new Node(Integer.parseInt(data[0]), Integer.parseInt(data[1])));
                stones.get(i).setColor(Integer.parseInt(data[2]));
            }

            //sticks
            canvas.getSticks().clear();
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                data = line.split(" ");
                canvas.getSticks().add(new Stick(new Node(Integer.parseInt(data[0]), Integer.parseInt(data[1])),
                        new Node(Integer.parseInt(data[2]), Integer.parseInt(data[3]))));
            }
            scanner.close();
            mainFrame.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
