import java.sql.*;

public class DatabaseReader {
    private Connection con;
    private Statement stmt;
    public DatabaseReader() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shelflife", "root", "Subspider2000_");
            stmt = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet readFromDB() {
        try {
            Statement stmt = con.createStatement();
            return stmt.executeQuery("SELECT * FROM goodreads");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void performQuery(String query) {
        try {
            stmt.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
