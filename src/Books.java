import java.util.ArrayList;


public class Books {
    private final ArrayList<Book> toRead = new ArrayList<>();
    private final ArrayList<Book> currentRead = new ArrayList<>();
    private final ArrayList<Book> read = new ArrayList<>();
    private int readCount;
    private int TBRCount;
    private int currentReadCount;

    public void readTable(String user, String password, String server) {

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