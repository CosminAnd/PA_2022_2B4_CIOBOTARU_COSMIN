import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryDAO {
    public void create(String name, int id) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement pstmt = connection.prepareStatement("insert into countries (id, name) values (?,?)")) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
            connection.commit();
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
}
