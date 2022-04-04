
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;


public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    int rows, cols;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;
    private final ArrayList<ArrayList<Node>> nodes = new ArrayList<>();
    private final List<Stick> sticks = new ArrayList<>();
    private final List<Node> stones = new ArrayList<>();
    private final List<Node> nodeList = new ArrayList<>();


    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        init(frame.configPanel.getRows(), frame.configPanel.getCols());

    }

    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
    }


    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        paintGrid(g);

        generateSticks();
        paintSticks(g);

        generateStones();
        paintStones(g);
    }

    private void paintGrid(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            g.drawLine(x1, y1, x2, y2);
        }
        //vertical lines
        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = padY + boardHeight;
            g.drawLine(x1, y1, x2, y2);
        }
        //intersections
        for (int row = 0; row < rows; row++) {
            ArrayList<Node> temp = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                g.setColor(Color.LIGHT_GRAY);
                g.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
                temp.add(new Node(x, y));
            }
            nodes.add(row, temp);
        }
    }

    public void generateSticks() {
        int maxim, temp = 0;
        Random random = new Random();
        //maxim number of intersection
        maxim = random.nextInt(rows * cols + 1) + 3;
        System.out.println("Maxim:" + maxim);

        //first node
        int iRandom = random.nextInt(rows);
        int jRandom = random.nextInt(cols);
        int direction = random.nextInt(4); //0=st, 1=sus, 2=dr, 3=jos
        nodeList.add(nodes.get(iRandom).get(jRandom));

        if (direction == 0) {
            if (jRandom > 0) {
                //Stick aux = new Stick(nodes.get(iRandom).get(jRandom), nodes.get(iRandom).get(jRandom - 1));
                sticks.add(new Stick(nodes.get(iRandom).get(jRandom), nodes.get(iRandom).get(jRandom - 1)));
                nodeList.add(nodes.get(iRandom).get(jRandom - 1));
                temp++;
            }
        }
        if (direction == 1) {
            if (iRandom > 0) {
                //Stick aux = new Stick(nodes.get(iRandom).get(jRandom), nodes.get(iRandom - 1).get(jRandom));
                sticks.add(new Stick(nodes.get(iRandom).get(jRandom), nodes.get(iRandom - 1).get(jRandom)));
                nodeList.add(nodes.get(iRandom - 1).get(jRandom));
                temp++;
            }
        }
        if (direction == 2) {
            if (jRandom < cols - 1) {
                //Stick aux = new Stick(nodes.get(iRandom).get(jRandom), nodes.get(iRandom).get(jRandom + 1));
                sticks.add(new Stick(nodes.get(iRandom).get(jRandom), nodes.get(iRandom).get(jRandom + 1)));
                nodeList.add(nodes.get(iRandom).get(jRandom + 1));
                temp++;
            }
        }
        if (direction == 3) {
            if (iRandom < rows - 1) {
                //Stick aux = new Stick(nodes.get(iRandom).get(jRandom), nodes.get(iRandom + 1).get(jRandom));
                sticks.add(new Stick(nodes.get(iRandom).get(jRandom), nodes.get(iRandom + 1).get(jRandom)));
                nodeList.add(nodes.get(iRandom + 1).get(jRandom));
                temp++;
            }
        }

        while (temp != maxim) {
            direction = random.nextInt(4); //0=st, 1=sus, 2=dr, 3=jos
            int randomIndexOfNode = random.nextInt(nodeList.size());
            int iOfCurrentNode = -1, jOfCurrentNode = -1;
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++) {
                    if (nodeList.get(randomIndexOfNode).compareNode(nodes.get(i).get(j))) {
                        iOfCurrentNode = i;
                        jOfCurrentNode = j;
                        break;
                    }
                }

            if (direction == 0) {
                if (jOfCurrentNode > 0) {
                    if (!(new Stick(nodes.get(iOfCurrentNode).get(jOfCurrentNode), nodes.get(iOfCurrentNode).get(jOfCurrentNode - 1)).compareStick(sticks))) {
                        sticks.add(new Stick(nodes.get(iOfCurrentNode).get(jOfCurrentNode), nodes.get(iOfCurrentNode).get(jOfCurrentNode - 1)));
                        nodeList.add(nodes.get(iOfCurrentNode).get(jOfCurrentNode - 1));
                        temp++;
                    }

                }
            }
            if (direction == 1) {
                if (iOfCurrentNode > 0) {
                    if (!(new Stick(nodes.get(iOfCurrentNode).get(jOfCurrentNode), nodes.get(iOfCurrentNode - 1).get(jOfCurrentNode)).compareStick(sticks))) {
                        sticks.add(new Stick(nodes.get(iOfCurrentNode).get(jOfCurrentNode), nodes.get(iOfCurrentNode - 1).get(jOfCurrentNode)));
                        nodeList.add(nodes.get(iOfCurrentNode - 1).get(jOfCurrentNode));
                        temp++;
                    }

                }
            }
            if (direction == 2) {
                if (jOfCurrentNode < cols - 1) {
                    if (!(new Stick(nodes.get(iOfCurrentNode).get(jOfCurrentNode), nodes.get(iOfCurrentNode).get(jOfCurrentNode + 1)).compareStick(sticks))) {
                        sticks.add(new Stick(nodes.get(iOfCurrentNode).get(jOfCurrentNode), nodes.get(iOfCurrentNode).get(jOfCurrentNode + 1)));
                        nodeList.add(nodes.get(iOfCurrentNode).get(jOfCurrentNode + 1));
                        temp++;
                    }

                }
            }
            if (direction == 3) {
                if (iOfCurrentNode < rows - 1) {
                    if (!(new Stick(nodes.get(iOfCurrentNode).get(jOfCurrentNode), nodes.get(iOfCurrentNode + 1).get(jOfCurrentNode)).compareStick(sticks))) {
                        sticks.add(new Stick(nodes.get(iOfCurrentNode).get(jOfCurrentNode), nodes.get(iOfCurrentNode + 1).get(jOfCurrentNode)));
                        nodeList.add(nodes.get(iOfCurrentNode+1).get(jOfCurrentNode));
                        temp++;
                    }

                }
            }
        }
        System.out.println("Numarul de bete:" + sticks.size());
        System.out.println(sticks);

    }

    public void paintSticks(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(4));
        for (Stick stick : sticks) {
            g.drawLine(stick.getFirst().getX(), stick.getFirst().getY(), stick.getSecond().getX(), stick.getSecond().getY());
        }
        //System.out.println(sticks);
    }

    public void generateStones() {
        //System.out.println(sticks);
        stones.add(sticks.get(0).getFirst());
        stones.add(sticks.get(0).getSecond());
        for (int i = 1; i < sticks.size(); i++) {
            if (stones.lastIndexOf(sticks.get(i).getFirst()) == -1) {
                stones.add(sticks.get(i).getFirst());
            }
            if (stones.lastIndexOf(sticks.get(i).getSecond()) == -1) {
                stones.add(sticks.get(i).getSecond());
            }
        }
        //System.out.println(stones);
    }

    public void paintStones(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        for (Node stone : stones) {
            g.drawOval(stone.getX() - stoneSize / 2, stone.getY() - stoneSize / 2, stoneSize, stoneSize);
        }
    }

    public List<Node> getStones() {
        return stones;
    }
}




