
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAO implements DAO {

    private Integer id;
    private String name;
    private String country;
    private Integer capital;
    private Double latitude;
    private Double longitude;

    public String getName() {

        return name;
    }

    public Double getLatitude() {

        return latitude;
    }

    public Double getLongitude() {

        return longitude;
    }


    @Override
    public void create(String name, int id) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement("insert into cities (id,name) values (?,?)")) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
            connection.commit();
        }
    }

    public void add(String name, String country, int capital, String latitude, String longitude, int countryId) throws SQLException {
        int id;
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select count(*) from cities")) {
            id = rs.next() ? rs.getInt(1) : null;
        }

        try (PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO cities (id, name, country, capital, latitude, longitude,country_id) VALUES (?, ?, ?, ?, ?, ?,?)")) {
            System.out.println(id);
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, country);
            stmt.setInt(4, capital);
            stmt.setDouble(5, Double.parseDouble(latitude));
            stmt.setDouble(6, Double.parseDouble(longitude));
            stmt.setInt(7, countryId);
            stmt.executeUpdate();
            con.commit();
        }
    }

    public void importCities() throws SQLException, FileNotFoundException, IOException {
        Connection con = Database.getConnection();
        String sql = "INSERT INTO cities (id, name, country, capital, latitude, longitude) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(sql);

        String filePath = "C:\\Users\\ciobo\\Desktop\\facultate\\an_2\\sem_2\\PA\\Laboratoare\\PA_2022_2B4_CIOBOTARU_COSMIN\\Lab8\\concap.csv";
        BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
        String lineText = null;

        int count = 0;

        lineReader.readLine();

        while ((lineText = lineReader.readLine()) != null) {
            String[] data = lineText.split(",");
            String country = data[0];
            String name = data[1];
            String latitude = data[2];
            String longitude = data[3];
            String continent = data[5];

            statement.setInt(1, count);
            statement.setString(2, name);
            statement.setString(3, country);
            statement.setInt(4, 1);

            Double dLatitude = Double.parseDouble(latitude);
            statement.setDouble(5, dLatitude);

            Double dLongitude = Double.parseDouble(longitude);
            statement.setDouble(6, dLongitude);

            count++;
            statement.executeUpdate();
        }
        con.commit();
    }

    @Override
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from cities where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    @Override
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select name from cities where name='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    @Override
    public void findAll() throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from CITIES");
        ResultSet res = pstmt.executeQuery();
        while (res.next()) {
            System.out.println(res.getString(1));
        }

    }

    public CityDAO findCity(String name) throws SQLException {
        CityDAO cityDAO = new CityDAO();
        Connection con = Database.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select * from CITIES where name='" + name + "'");
        ResultSet res = pstmt.executeQuery();
        while (res.next()) {
            cityDAO.id = res.getInt(1);
            cityDAO.name = res.getString(2);
            cityDAO.country = res.getString(3);
            cityDAO.capital = res.getInt(4);
            cityDAO.latitude = res.getDouble(5);
            cityDAO.longitude = res.getDouble(6);
        }
        return cityDAO;
    }

    public void distanceToCities(String firstCity, String secondCity) throws SQLException {
        Double firstLatitude = 0.0, firstLongitude = 0.0;
        Double secondLatitude = 0.0, secondLongitude = 0.0;

        Connection con = Database.getConnection();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select latitude, longitude from cities where name='" + firstCity + "'")) {
            if (rs.next()) {
                firstLatitude = rs.getDouble(1);
                firstLongitude = rs.getDouble(2);
            }
        }

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select latitude, longitude from cities where name='" + secondCity + "'")) {
            if (rs.next()) {
                secondLatitude = rs.getDouble(1);
                secondLongitude = rs.getDouble(2);
            }
        }
        firstLatitude = Math.toRadians(firstLatitude);
        secondLatitude = Math.toRadians(secondLatitude);
        firstLongitude = Math.toRadians(firstLongitude);
        secondLongitude = Math.toRadians(secondLongitude);

        double difflat = secondLatitude - firstLatitude;
        double difflon = secondLongitude - firstLongitude;
        double a = Math.pow(Math.sin(difflat / 2), 2) + Math.cos(firstLatitude) * Math.cos(secondLatitude) * Math.pow(Math.sin(difflon / 2), 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double r = 6378.8;
        System.out.println(c * r);
    }

}
