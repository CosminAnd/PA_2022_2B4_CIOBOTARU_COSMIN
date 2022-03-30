import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemListener;

public class ControlPanel extends JPanel {

    private JButton loadButton;
    private JButton saveButton;
    private JButton exitButton;


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
