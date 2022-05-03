import java.sql.*;

public class ContinentDAO implements DAO {
    @Override
    public void create(String name, int id) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement("insert into continents (id,name) values (?,?)")) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
            connection.commit();
        }
    }

    @Override
    public void findAll() throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from CONTINENTS ");
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
                     "select id from continents where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    @Override
    public String findById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(
                     "select name from continents where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }


}