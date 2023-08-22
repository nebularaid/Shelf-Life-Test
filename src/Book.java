public class Book {
    private int ISBN;
    private String title;
    private String author;
    private int rating;
    private double avgRating;
    private int initPublished;
    private String dateRead;
    private String review;
    private int pages;

    public Book() {
    }

    public void setBook(String title, String author, int rating, double avgRating, int initPublished, int pages) {
        this.title = title;
        this.author = author;
        this.rating = rating;
        this.avgRating = avgRating;
        this.initPublished = initPublished;
        this.pages = pages;
    }

    public void setDateRead(String dateRead) {
        this.dateRead = dateRead;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String toString() {
        return this.title + " - by " + this.author + ". Published in " + this.initPublished;
    }
}