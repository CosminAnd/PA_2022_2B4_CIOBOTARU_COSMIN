import java.sql.SQLException;

public interface DAO {
    public void create(String name, int id) throws SQLException;

    public void findAll() throws SQLException;

    public Integer findByName(String name) throws SQLException;

    public String findById(int id) throws SQLException;


}
