import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.security.PublicKey;
import java.util.List;

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
        rows=this.mainFrame.configPanel.getRows();
        cols= this.mainFrame.configPanel.getCols();
    }

    public int getTurn() {
        return turn;
    }

    public List<Node> getStones(){
        return stones;
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
            writer.write(rows);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
