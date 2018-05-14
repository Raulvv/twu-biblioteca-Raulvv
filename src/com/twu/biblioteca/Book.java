package com.twu.biblioteca;

public class Book extends Item {
    private String title;
    private String author;
    private String publicationYear;

    private Boolean checkoutStatus;

    Book(int id, String title, String author, String publicationYear) {
        super(id);
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String toString() {
        return this.id + "  |  " + this.title + "  |  " + this.author + "  |  " + this.publicationYear;
    }
}
