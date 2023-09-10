import java.util.Scanner;

public class UserInterface {
    private Scanner reader;

    public UserInterface(Scanner reader) {
        this.reader = reader;
    }

    public void start(Read read, ToBeRead TBR, CurrentRead current) {
        if (read.getReadCount() == 1) {
            System.out.println("Books read: 1 book");
            read.printRead();
        } else if (read.getReadCount() == 0) {
            System.out.println("Haven't read any books yet :)");
        } else {
            System.out.println("Books read: " + read.getReadCount() + " books");
            read.printRead();
        }
        System.out.println();

        if (current.getCurrentCount() == 1) {
            System.out.println("Current read: 1 book");
            current.printCurrentRead();
        } else if (current.getCurrentCount() == 0) {
            System.out.println("No books being read :(");
        } else {
            System.out.println("Current reads: " + current.getCurrentCount() + " books");
            current.printCurrentRead();
        }
        System.out.println();

        if (TBR.getTBRCount() == 1) {
            System.out.println("Books to read: 1 book");
            TBR.printTBR();
        } else if (TBR.getTBRCount() == 0) {
            System.out.println("No books on your TBR :0");
        } else {
            System.out.println("Books to read: " + TBR.getTBRCount() + " books");
            TBR.printTBR();
        }
        System.out.println();

    }
}
