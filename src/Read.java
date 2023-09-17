import java.util.ArrayList;

public class Read {
    private int readCount;
    private final ArrayList<Book> read = new ArrayList<>();

    public void addRead(Book book) {
        read.add(book);
        readCount++;
    }

    public int getReadCount() {
        return readCount;
    }

    public void printRead() {
        for (Book one : read) {
            System.out.println(one);
        }
    }
}
