import java.sql.*;

public class ContinentDAO {
    public void create(String name, int id) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement("insert into continents (id,name) values (?,?)")) {
            pstmt.setInt(1, id);
            pstmt.setString(2,name);
            pstmt.executeUpdate();
            connection.commit();
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from continents where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(
                     "select name from continents where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}