package com.twu.biblioteca;

public class Book {
    private int id;
    private String title;
    private String author;
    private String publicationYear;
    private Boolean checkoutStatus;

    Book(int id, String title, String author, String publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.checkoutStatus = false;
    }

    public String toString() {
        return this.id + "  |  " + this.title + "  |  " + this.author + "  |  " + this.publicationYear;
    }

    public Boolean isCheckout() {
        return this.checkoutStatus;
    }

    public void checkout() {
        this.checkoutStatus = !this.checkoutStatus;
    }

    public int getId() {
        return id;
    }
}
