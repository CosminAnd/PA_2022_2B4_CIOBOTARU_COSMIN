import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    DrawingPanel canvas;
    String name;

    public void setName(String name){
        this.name= name;
    }
    public String getName(){
        return name;
    }

    public MainFrame(String name) throws SQLException {
        super("Map");
        this.name=name;
        init();
    }

    private void init() throws SQLException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        canvas = new DrawingPanel(this);
        setPreferredSize(new Dimension(700, 390));
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\ciobo\\Desktop\\facultate\\an_2\\sem_2\\PA\\Laboratoare\\PA_2022_2B4_CIOBOTARU_COSMIN\\Lab8\\map.jpg")));
        setLayout(new FlowLayout());
        setLayout(new BorderLayout());
        add(canvas, CENTER);
        pack();
        setVisible(true);
    }
}
