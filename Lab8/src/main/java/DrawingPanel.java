import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;


public class DrawingPanel extends JPanel {
    private final MainFrame frame;

    public DrawingPanel(MainFrame frame) throws SQLException {
        this.frame = frame;
        init();
    }

    final void init() throws SQLException {
        this.setOpaque(false);
        setPreferredSize(new Dimension(700, 410));
        this.setLayout(null);
        var cities = new CityDAO();
        CityDAO city = cities.findCity(frame.name);
        EllipticalMercator ellipticalMercator = new EllipticalMercator();
            JLabel label = new JLabel();
            label.setText(city.getName());
            label.setForeground(Color.white);
            if (city.getLatitude() > 0 && city.getLongitude() > 0)
                label.setBounds((int) ellipticalMercator.xAxisProjection(city.getLongitude()) / 100000 + 350, (int) ellipticalMercator.yAxisProjection(city.getLatitude()) / 100000 + 50, 40, 20);
            else if (city.getLongitude() < 0 && city.getLatitude() > 0)
                label.setBounds((int) ellipticalMercator.xAxisProjection(city.getLongitude()) / 100000 + 300, (int) ellipticalMercator.yAxisProjection(city.getLatitude()) / 100000 + 150, 40, 20);
            else if (city.getLatitude() < 0 && city.getLongitude() > 0)
                label.setBounds((int) ellipticalMercator.xAxisProjection(city.getLongitude()) / 100000 + 360, (int) ellipticalMercator.yAxisProjection(city.getLatitude()) / 100000 + 270, 40, 20);
            else
                label.setBounds((int) ellipticalMercator.xAxisProjection(city.getLongitude()) / 100000 + 300, (int) ellipticalMercator.yAxisProjection(city.getLatitude()) / 100000 + 270, 40, 20);
            add(label);

    }
}
