// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Books bookshelf = new Books();
        bookshelf.setBooks("C:\\Users\\sharm\\Downloads\\goodreads.csv");
        System.out.println("To be read: " + bookshelf.getBooksToRead() + " books");
        bookshelf.getTBR();
        System.out.println("Read: " + bookshelf.getBooksRead() + " books");
        bookshelf.getRead();
        System.out.println("Currently reading: " + bookshelf.getCurrentlyReading() + " books");
        bookshelf.getCurrentRead();
    }
}