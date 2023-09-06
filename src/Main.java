import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ToBeRead TBR = new ToBeRead();
        CurrentRead current = new CurrentRead();
        Read read = new Read();

        ResultSet rs = createConnection();
        createBooks(TBR, current, read, rs);

        if (read.getReadCount() == 1) {
            System.out.println("Books read: 1 book");
            read.printRead();
        } else if (read.getReadCount() == 0) {
            System.out.println("Haven't read any books yet :)");
        } else {
            System.out.println("Books read: "+ read.getReadCount() + " books");
            read.printRead();
        }
        System.out.println();

        if (current.getCurrentCount() == 1) {
            System.out.println("Current read: 1 book");
            current.printCurrentRead();
        } else if (current.getCurrentCount() == 0) {
            System.out.println("No books being read :(");
        } else {
            System.out.println("Current reads: " + current.getCurrentCount() + " books");
            current.printCurrentRead();
        }
        System.out.println();

        if (TBR.getTBRCount() == 1) {
            System.out.println("Books to read: 1 book");
            TBR.printTBR();
        } else if (TBR.getTBRCount() == 0) {
            System.out.println("No books on your TBR :0");
        } else {
            System.out.println("Books to read " + TBR.getTBRCount() + " books");
            TBR.printTBR();
        }
        System.out.println();

    }

    //maybe use inheritance?
    //create class coupling diagram

    private static ResultSet createConnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shelflife", "root", "Subspider2000_");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM goodreads");
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createBooks(ToBeRead TBR, CurrentRead current, Read read, ResultSet rs) {
        try {

            while (rs.next()) {
                String title = rs.getString(1);
                String author = rs.getString(2);
                int pages = rs.getInt(6);
                int initPub = rs.getInt(7);
                Book book = new Book(title, author, initPub, pages);

                if (rs.getString(3) != null) {
                    book.setAdditionalAuthors(rs.getString(3));
                }
                rs.getInt(4);
                if (!rs.wasNull()) {
                    int myRating = rs.getInt(4);
                    book.setRating(myRating);
                }

                rs.getDate(8);
                if (!rs.wasNull()) {
                    Date sqlDate = Date.valueOf(rs.getDate(8).toLocalDate());
                    book.setDateRead(sqlDate.toLocalDate());
                }

                if (rs.getString(10) != null) {
                    book.setReview(rs.getString(10));
                }
                String shelf = rs.getString(9);
                switch (shelf) {
                    case "to-read":
                        TBR.addTBR(book);
                        break;
                    case "read":
                        read.addRead(book);
                        break;
                    case "currently-reading":
                        current.addCurrentRead(book);
                        break;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}