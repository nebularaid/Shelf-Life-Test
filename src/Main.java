import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Main pro = new Main();
        Books books = pro.createBooks();
        for (Book book : books.getRead()) {
            System.out.println(book);
        }
        System.out.println();

        for (Book book : books.getCurrentRead()) {
            System.out.println(book);
        }
        System.out.println();

        for (Book book : books.getToRead()) {
            System.out.println(book);
        }
        System.out.println();

    }

     Books createBooks() {
        Books books = new Books();

        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shelflife", "root", "Subspider2000_");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM goodreads");
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

                    if (rs.getString(10)!= null) {
                        book.setReview(rs.getString(10));
                    }
                    String shelf = rs.getString(9);
                switch (shelf) {
                    case "to-read":
                        books.addToTBR(book);
                        break;
                    case "read":
                        books.addRead(book);
                        break;
                    case "currently-reading":
                        books.addCurrentRead(book);
                        break;
                }
            }
        }  catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return books;
    }
}