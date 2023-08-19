
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Books {
    private ArrayList<Book> toRead = new ArrayList();
    private ArrayList<Book> currentRead = new ArrayList();
    private ArrayList<Book> read = new ArrayList();
    private int booksRead;
    private int booksToRead;

    public Books() {
    }

    public void setBooks(String file) {
        try {
            Scanner reader = new Scanner(Paths.get(file));

            try {
                reader.nextLine();
                Pattern pattern = Pattern.compile("\"([^\"]*)\"");

                while(reader.hasNextLine()) {
                    String line = reader.nextLine();
                    Matcher matcher = pattern.matcher(line);
                    String title = null;
                    String review = null;
                    if (matcher.find()) {
                        title = matcher.group();
                    }

                    if (matcher.find()) {
                        review = matcher.group();
                        line.replaceAll("\"([^\"]*)\"", "NULL");
                    }

                    String[] columns = line.split(",");
                    if (columns[0].equals("NULL")) {
                        columns[0] = title;
                    }

                    if (columns.length > 6) {
                        columns[7] = review;
                    }

                    int rating = Integer.valueOf(columns[2]);
                    double avgRating = Double.valueOf(columns[3]);
                    int pages = Integer.valueOf(columns[4]);
                    int published = Integer.valueOf(columns[5]);
                    Book book = new Book();
                    book.setBook(columns[0], columns[1], rating, avgRating, pages, published);
                    if (!review.equals((Object)null)) {
                        book.setReview(review);
                    } else if (!columns[7].equals("")) {
                        book.setReview(columns[7]);
                    }

                    String shelf = columns[6];
                    if (shelf.equals("to-read")) {
                        this.addToTBR(book);
                        ++this.booksToRead;
                    } else if (shelf.equals("read")) {
                        this.addRead(book);
                        ++this.booksRead;
                    } else if (shelf.equals("currently-reading")) {
                        this.addCurrentRead(book);
                    }
                }
            } catch (Throwable var17) {
                try {
                    reader.close();
                } catch (Throwable var16) {
                    var17.addSuppressed(var16);
                }

                throw var17;
            }

            reader.close();
        } catch (Exception var18) {
            System.out.println("--ERROR--");
            var18.printStackTrace();
        }

    }

    public void addToTBR(Book book) {
        this.toRead.add(book);
    }

    public void addCurrentRead(Book book) {
        this.currentRead.add(book);
    }

    public void addRead(Book book) {
        this.read.add(book);
    }

    public void getCurrentRead() {
        Iterator var1 = this.currentRead.iterator();

        while(var1.hasNext()) {
            Book book = (Book)var1.next();
            System.out.println(book);
        }

        System.out.println();
    }

    public void getRead() {
        Iterator var1 = this.read.iterator();

        while(var1.hasNext()) {
            Book book = (Book)var1.next();
            System.out.println(book);
        }

        System.out.println();
    }

    public void getTBR() {
        Iterator var1 = this.toRead.iterator();

        while(var1.hasNext()) {
            Book book = (Book)var1.next();
            System.out.println(book);
        }

        System.out.println();
    }
}

