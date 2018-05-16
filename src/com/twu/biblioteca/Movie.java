package com.twu.biblioteca;

public class Movie extends Item {
    private String title;
    private String director;
    private String publicationYear;
    private double rating;

    Movie(int id, String title, String director, String publicationYear, double rating) {
        super(id);
        this.title = title;
        this.director = director;
        this.publicationYear = publicationYear;
        this.rating = rating;
    }

    public String toString() {
        return this.id + "  |  " + this.title + "  |  " + this.director + "  |  " + this.publicationYear + "  |  " + this.rating;
    }

    public String statusToString() {
        return this.id + "  |  " + this.title + "  |  " + this.temporalOwner;
    }
}
