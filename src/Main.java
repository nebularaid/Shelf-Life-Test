import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseReader dc = new DatabaseReader();
        ResultSet rs = dc.readFromDB();
        Shelves shelve = new Shelves();
        shelve.bookAndShelve(rs);

        Scanner reader = new Scanner(System.in);
        UserInterface ui = new UserInterface(reader);

        ui.start(shelve.getRead(), shelve.getTBR(), shelve.getCurrent());
    }
}