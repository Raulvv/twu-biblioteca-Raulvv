package com.twu.biblioteca;

public class Book {

    private String title;
    private String author;
    private String publicationYear;

    Book(String title, String author, String publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String toString() {
        return this.title + "  |  " + this.author + "  |  " + this.publicationYear;
    }
}
