
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Books {
    private final ArrayList<Book> toRead = new ArrayList<>();
    private final ArrayList<Book> currentRead = new ArrayList<>();
    private final ArrayList<Book> read = new ArrayList<>();
    private int readCount;
    private int TBRCount;
    private int currentReadCount;

    public Books() {
    }

    public void setBooks(String file) {
        try (Scanner reader = new Scanner(Paths.get(file))) {

            reader.nextLine();
            Pattern titlePat = Pattern.compile("\"([^\"]*)\",");
            Pattern reviewPat = Pattern.compile("\"([^\"]*)\"");
            Pattern dateReadPat = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$");

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                Matcher matcherTitle = titlePat.matcher(line);
                Matcher matcherReview = reviewPat.matcher(line);
                Matcher matcherDateRead = dateReadPat.matcher(line);
                String title = null;
                String review = null;
                String dateRead = null;

                if (matcherTitle.find()) {
                    title = matcherTitle.group();
                    line = line.replace(title, "nullified,");
                    title = title.substring(0, title.length() - 1);
                    title = title.replaceAll("\"", "");
                }

                if (matcherReview.find()) {
                    review = matcherReview.group();
                    line = line.replace(review, "nullified");
                }
                if (matcherDateRead.find()) dateRead = matcherDateRead.group();

                String[] columns = line.split(",");
                int last = columns.length - 1;

                if (title == null) title = columns[0];

                Pattern shelf = Pattern.compile("read|to-read|currently-reading");
                Matcher shelfMatcher = shelf.matcher(columns[last]);
                if (!shelfMatcher.find() && review == null) {
                    review = columns[last];
                }

                int rating = Integer.parseInt(columns[2]);
                double avgRating = Double.parseDouble(columns[3]);
                int pages = Integer.parseInt(columns[4]);
                int published = Integer.parseInt(columns[5]);
                Book book = new Book();
                book.setBook(title, columns[1], rating, avgRating, published, pages);

                if (dateRead != null) book.setDateRead(dateRead);
                if (review != null) book.setReview(review);

                if (line.contains("currently-reading")) {
                    this.addCurrentRead(book);
                    this.currentReadCount++;
                } else if (line.contains("to-read")) {
                    this.addToTBR(book);
                    this.TBRCount++;
                } else if (line.contains("read")) {
                    this.addRead(book);
                    this.readCount++;
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

    public ArrayList<Book> getToRead() {
        return toRead;
    }

    public ArrayList<Book> getCurrentRead() {
        return currentRead;
    }

    public ArrayList<Book> getRead() {
        return read;
    }

    public int getReadCount() {
        return readCount;
    }

    public int getTBRCount() {
        return TBRCount;
    }

    public int getCurrentReadCount() {
        return currentReadCount;
    }

    private void sortTBR() {

    }
}