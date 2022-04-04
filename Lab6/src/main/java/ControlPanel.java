
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton captureBtn = new JButton("Capture");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        add(exitBtn);
        add(loadBtn);
        add(saveBtn);
        add(captureBtn);

        //configure listeners for all buttons
        exitBtn.addActionListener(this::exitGame);
        captureBtn.addActionListener(this::captureGame);
        loadBtn.addActionListener(this::load);
        saveBtn.addActionListener(this::save);
    }

    private void save(ActionEvent e){

    }

    private void load(ActionEvent e){
        
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void captureGame(ActionEvent event) {
        try {
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(frame.getLocationOnScreen().x, frame.getLocationOnScreen().y, frame.getWidth(), frame.getHeight()));
            File file = new File("Capture.png");
            ImageIO.write(image, "png", file);
        } catch (AWTException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}