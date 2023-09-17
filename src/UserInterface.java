import java.util.Scanner;

public class UserInterface {
    private Scanner reader;

    public UserInterface(Scanner reader) {
        this.reader = reader;
    }

    public void start(Read read, ToBeRead TBR, CurrentRead current) {

        System.out.println("Welcome to Shelflife! What are we doing today?\n");
        System.out.println("Commands:\n1. Show my TBR\n" +
                "2. Show my current read(s)\n" +
                "3. Show my completed books\n" +
                "4. Show all my books\n" +
                "5. quit");

        while (true) {
            String input = reader.nextLine();
            switch (input) {
                case "1":
                    getTBR(TBR);
                    break;
                case "2":
                    getCurrent(current);
                    break;
                case "3":
                    getRead(read);
                    break;
                case "4":
                    getTBR(TBR);
                    getRead(read);
                    getCurrent(current);
                    break;
                case "5":
                    System.out.println("Happy reading!");
                    return;
            }
        }

    }

    private void getTBR(ToBeRead TBR) {
        if (TBR.getTBRCount() == 1) {
            System.out.println("Books to read: 1 book\n");
            TBR.printTBR();
        } else if (TBR.getTBRCount() == 0) {
            System.out.println("No books on your TBR :0");
        } else {
            System.out.println("Books to read: " + TBR.getTBRCount() + " books\n");
            TBR.printTBR();
        }
        System.out.println();
    }

    private void getCurrent(CurrentRead current) {
        if (current.getCurrentCount() == 1) {
            System.out.println("Current read: 1 book\n");
            current.printCurrentRead();
        } else if (current.getCurrentCount() == 0) {
            System.out.println("No books being read :(");
        } else {
            System.out.println("Current reads: " + current.getCurrentCount() + " books\n");
            current.printCurrentRead();
        }
        System.out.println();
    }

    private void getRead(Read read) {
        if (read.getReadCount() == 1) {
            System.out.println("Books read: 1 book\n");
            read.printRead();
        } else if (read.getReadCount() == 0) {
            System.out.println("Haven't read any books yet :)");
        } else {
            System.out.println("Books read: " + read.getReadCount() + " books\n");
            read.printRead();
        }
        System.out.println();
    }
}
