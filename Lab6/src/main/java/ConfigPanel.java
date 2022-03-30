

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner rows;
    JSpinner cols;
    JButton newGame;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        label = new JLabel("Grid size:");
        rows = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        cols = new JSpinner((new SpinnerNumberModel(10,2,100,1)));
        newGame = new JButton(("New Game"));

        add(label); //JPanel uses FlowLayout by default
        add(rows);
        add(cols);
        add(newGame);
    }
    public int getRows() {
        return (int) rows.getValue();
    }
    public int getCols() {
        return (int) cols.getValue();
    }
}

