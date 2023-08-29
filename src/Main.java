// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Books bookshelf = new Books();
        bookshelf.setBooks("C:\\Users\\sharm\\Downloads\\goodreads.csv");
        System.out.println("To be read: " + bookshelf.getTBRCount() + " books");
        for (Book book : bookshelf.getToRead()) {
            System.out.println(book);
        }
        System.out.println();

        System.out.println("Read: " + bookshelf.getReadCount() + " books");
        for (Book book : bookshelf.getRead()) {
            System.out.println(book);
        }
        System.out.println();

        System.out.println("Currently reading: " + bookshelf.getCurrentReadCount() + " books");

        for (Book book : bookshelf.getCurrentRead()) {
            System.out.println(book);
        }
        System.out.println();
    }
}