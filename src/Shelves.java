import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Shelves {
    private final Read read;
    private final ToBeRead TBR;
    private final CurrentRead current;

    public Shelves() {
        read = new Read();
        TBR = new ToBeRead();
        current = new CurrentRead();
    }

    public void bookAndShelve(ResultSet rs) {
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

    public Read getRead() {
        return read;
    }

    public ToBeRead getTBR() {
        return TBR;
    }

    public CurrentRead getCurrent() {
        return current;
    }
}
