
import java.awt.BorderLayout;
import java.io.FileWriter;
import java.io.Writer;
import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    Game game;


    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    public void drawCanvas(DrawingPanel newDrawing) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        canvas = newDrawing;
        add(canvas, CENTER);
        game= new Game(this);
        game.play();
        pack();
    }

    private void init() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);
        setLayout(new BorderLayout());
        setSize(420, 500);


        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        add(canvas, BorderLayout.CENTER);

        //invoke the layout manager
        pack();
        setVisible(true);
    }

    public void save(){
        try{
            Writer writer = new FileWriter("save.txt");
            writer.write(configPanel.getCols());

            writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
