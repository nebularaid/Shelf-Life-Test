
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Books {
    private final ArrayList<Book> toRead = new ArrayList<>();
    private final ArrayList<Book> currentRead = new ArrayList<>();
    private final ArrayList<Book> read = new ArrayList<>();
    private int booksRead;
    private int booksToRead;

    public Books() {
    }

    public void setBooks(String file) {
        try (Scanner reader = new Scanner(Paths.get(file))) {

            reader.nextLine();
            Pattern titleOrReview = Pattern.compile("\"([^\"]*)\"");
            Pattern dateReadPat = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$");

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                Matcher matcherToR = titleOrReview.matcher(line);
                Matcher matcherDR = dateReadPat.matcher(line);
                String title = null;
                String review = null;
                String dateRead = null;
                if (matcherToR.find()) {
                    title = matcherToR.group();
                }

                if (matcherToR.find()) {
                    review = matcherToR.group();
                    line.replaceAll("\"([^\"]*)\"", "NULL");
                }

                if (matcherDR.find()) dateRead = matcherDR.group();

                String[] columns = line.split(",");
                if (columns[0].equals("NULL")) columns[0] = title;

                int last = columns.length - 1;
                if (!columns[last].equals("to-read|read|currently-reading") && review != null) {
                    columns[last] = review;
                } else if (!columns[last].equals("to-read|read|currently-reading")) {
                    review = columns[last];
                }

                // refactor tip: maybe replace empty rows with
                // a space so columns.length is always the same

                int rating = Integer.parseInt(columns[2]);
                double avgRating = Double.parseDouble(columns[3]);
                int pages = Integer.parseInt(columns[4]);
                int published = Integer.parseInt(columns[5]);
                Book book = new Book();
                book.setBook(columns[0], columns[1], rating, avgRating, published, pages);
                if (dateRead != null) book.setDateRead(dateRead);

                if (line.contains("to-read")) {
                    this.addToTBR(book);
                    ++this.booksToRead;
                } else if (line.contains("read")) {
                    this.addRead(book);
                    ++this.booksRead;
                } else if (line.contains("currently-reading")) {
                    this.addCurrentRead(book);
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR");
            e.printStackTrace();
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
        for (Book book : this.currentRead) {
            System.out.println(book);
        }
        System.out.println();
    }

    public void getRead() {
        for (Book book : this.read) {
            System.out.println(book);
        }
        System.out.println();
    }

    public void getTBR() {
        for (Book book : toRead) {
            System.out.println(book);
        }
        System.out.println();
    }
}

