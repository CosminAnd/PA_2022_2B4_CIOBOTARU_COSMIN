import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {

    JLabel label;
    JSpinner spRows;
    JSpinner spCols;
    JButton newGameButton;

    public ConfigPanel() {
        init();
    }

    private void init() {
        setLayout(new FlowLayout()); //layout cu aliniere centrala
        label = new JLabel("Grid size:");
        spRows = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spCols = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        newGameButton = new JButton("Create");
        add(label);
        add(spRows);
        add(spCols);
        add(newGameButton);
    }

    public int getRows() {
        return (int) spRows.getValue();
    }

    public int getCols() {
        return (int) spCols.getValue();
    }
}
