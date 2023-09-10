import java.sql.*;

public class DatabaseReader {

    public ResultSet readFromDB() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shelflife", "root", "Subspider2000_");
            Statement stmt = con.createStatement();
            return stmt.executeQuery("SELECT * FROM goodreads");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
