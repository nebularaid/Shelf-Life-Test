import java.time.LocalDate;

public class Book {
    private final String title;
    private final String author;
    private String additionalAuthors;
    private int rating;
    private Double avgRating;
    private final int initPublished;
    private LocalDate dateRead;
    private String review;
    private final int pages;

    public Book(String title, String author, int initPub, int pages) {
        this.title = title;
        this.author = author;
        this.initPublished = initPub;
        this.pages = pages;
    }

    public void setAdditionalAuthors(String additionalAuthors) {
        this.additionalAuthors = additionalAuthors;
    }

    public String getAdditionalAuthors() {
        return additionalAuthors;
    }

    public int getRating() {
        return rating;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public int getPages() {
        return pages;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setDateRead(LocalDate dateRead) {
        this.dateRead = dateRead;
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