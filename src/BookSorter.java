import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class BookSorter {
    private final ArrayList<Book> list;

    public BookSorter(ArrayList<Book> list) {
        this.list = list;
    }

    public void sortByDateRead() {
        for (int i = 0; i < list.size(); ++i) {
            earliestFromIndex(i);
            swap(i, earliestFromIndex(i));
        }
    }
    private int earliestFromIndex(int index) {
        LocalDate earliest = LocalDate.now().plusDays(1);
        int i = 0;
        int earliestIndex = 0;
        try {

            for (i = index; i < list.size(); ++i) {
                if (list.get(i).getDateRead() == null) {
                    Book nullDate = list.get(i);
                    list.remove(list.get(i));
                    list.add(0, nullDate);
                    continue;
                }
                if (list.get(i).getDateRead().isBefore(earliest)) {
                    earliest = list.get(i).getDateRead();
                    earliestIndex = i;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return earliestIndex;
    }

    private void swap(int first, int second) {
        Collections.swap(list, first, second);
    }
}
