

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");

    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        add(exitBtn);
        add(loadBtn);
        add(saveBtn);

        //configure listeners for all buttons
        exitBtn.addActionListener(this::exitGame);
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
    }

    private void saveGame(ActionEvent actionEvent) {

    }

    private void loadGame(ActionEvent actionEvent) {

    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
}