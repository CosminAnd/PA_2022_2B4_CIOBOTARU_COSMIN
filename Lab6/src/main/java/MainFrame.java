import java.awt.BorderLayout;
import javax.swing.*;

public class MainFrame extends JFrame {

    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {

        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        configPanel = new ConfigPanel();
        controlPanel = new ControlPanel();
        canvas = new DrawingPanel(this);
        setLayout(new BorderLayout());
        setSize(420, 500);


        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        add(canvas, BorderLayout.CENTER);

        setVisible(true);
    }
} 