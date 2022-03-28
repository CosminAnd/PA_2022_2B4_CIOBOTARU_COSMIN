import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    private JButton loadButton;
    private JButton saveButton;
    private JButton exitButton;

    public ControlPanel() {
        init();
    }

    private void init() {
        setLayout(new FlowLayout());
        loadButton = new JButton("Load");
        saveButton = new JButton("Save");
        exitButton = new JButton("Exit");
        add(loadButton);
        add(saveButton);
        add(exitButton);
    }
}
