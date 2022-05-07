import java.sql.*;

public class CountryDAO implements DAO {
    @Override
    public void create(String name, int id) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement("insert into countries (id, name) values (?,?)")) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
            connection.commit();
        }
    }

    @Override
    public void findAll() throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from countries ");
        ResultSet res = pstmt.executeQuery();
        while (res.next()) {
            System.out.println(res.getString(1));
        }

    }

    @Override
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from countries where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    @Override
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select name from countries where name='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    public void printCountries(int id) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement pstmt = connection.prepareStatement("select name from countries where id='" + id + "'");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }

    public void add(String name, int id, String code, String continent, int continentId) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement("insert into countries (id, name, code, continent, continent_id) values (?,?,?,?,?)")) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, code);
            pstmt.setString(4,continent);
            pstmt.setInt(5, continentId);
            pstmt.executeUpdate();
            connection.commit();
        }
    }


}
