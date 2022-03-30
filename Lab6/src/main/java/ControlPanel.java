

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton captureBtn= new JButton("Capture");

    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        add(exitBtn);
        add(loadBtn);
        add(saveBtn);
        add(captureBtn);

        //configure listeners for all buttons
        exitBtn.addActionListener(this::exitGame);
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        captureBtn.addActionListener(this::captureGame);
    }

    private void saveGame(ActionEvent actionEvent) {

    }

    private void loadGame(ActionEvent actionEvent) {

    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void captureGame(ActionEvent event){
        BufferedImage image = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        frame.printAll(g);
        g.dispose();
        try {
            ImageIO.write(image, "png", new File("Capture.png"));
        } catch (IOException exp) {
            exp.printStackTrace();
        }

    }
}