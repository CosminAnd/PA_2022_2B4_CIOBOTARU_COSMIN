
import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner rows;
    JSpinner cols;
    JButton newGame;
    JButton startGame;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner
        label = new JLabel("Grid size:");
        rows = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        cols = new JSpinner((new SpinnerNumberModel(10, 2, 100, 1)));

        startGame = new JButton("Start");
        startGame.addActionListener(this::startGame);

        newGame = new JButton(("New Game"));
        newGame.addActionListener(this::newGame);


        add(label); //JPanel uses FlowLayout by default
        add(rows);
        add(cols);
        add(startGame);
        add(newGame);

    }

    private void startGame(ActionEvent actionEvent) {
        DrawingPanel newDrawing = new DrawingPanel(frame);
        frame.drawCanvas(newDrawing);
        startGame.setEnabled(false);
    }

    private void newGame(ActionEvent actionEvent) {
        DrawingPanel newDrawing = new DrawingPanel(frame);
        frame.drawCanvas(newDrawing);
        startGame.setEnabled(true);
    }

    public int getRows() {
        return (int) rows.getValue();
    }

    public int getCols() {
        return (int) cols.getValue();
    }
}

