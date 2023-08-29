import java.time.LocalDate;

public class Book {
    private int ISBN;
    private String title;
    private String author;
    private int rating;
    private double avgRating;
    private int initPublished;
    private LocalDate dateRead;
    private String review;
    private int pages;

    public void setBook(String title, String author, int rating, double avgRating, int initPublished, int pages) {
        this.title = title;
        this.author = author;
        this.rating = rating;
        this.avgRating = avgRating;
        this.initPublished = initPublished;
        this.pages = pages;
    }

    public void setDateRead(String dateRead) {
        String[] pieces = dateRead.split("/");
        String day = pieces[0];
        String month = pieces[1];
        String year = pieces[2];

        dateRead = year + "-" + month + "-" + day;
        this.dateRead = LocalDate.parse(dateRead);
        //System.out.println(this.dateRead);
    }

    public LocalDate getDateRead() {
        return dateRead;
    }
    public void setReview(String review) {
        this.review = review;
    }
    public String getReview() {
        return review;
    }
    public String toString() {
        return this.title + " - by " + this.author + ". Published in " + this.initPublished;
    }
}