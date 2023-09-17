import java.util.ArrayList;

public class CurrentRead {

    private int currentCount;
    private final ArrayList<Book> currentRead = new ArrayList<>();

    public void addCurrentRead(Book book) {
        currentRead.add(book);
        currentCount++;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void printCurrentRead() {
        for (Book one : currentRead) {
            System.out.println(one);
        }
    }
}
