import java.util.ArrayList;

public class ToBeRead {
    private int TBRCount;
    private final ArrayList<Book> toBeRead = new ArrayList<>();

    public void addTBR(Book book) {
        toBeRead.add(book);
        TBRCount++;
    }

    public int getTBRCount() {
        return TBRCount;
    }

    public void printTBR() {
        for (Book one : toBeRead) {
            System.out.println(one);
        }
    }
}
