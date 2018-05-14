package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {

    public static void main(String[] args) {
        ArrayList<Item> books = new ArrayList(Arrays.asList(
                new Book(1,"Elon Musk", "Ashlee Vance", "2015"),
                new Book(2,"Interview with the Vampire", "Anne Rice", "1976"),
                new Book(3,"Homo Deus: A Brief History of Tomorrow", "Yuval Noah Harari", "2015")
        ));

        ArrayList<Item> movies = new ArrayList(Arrays.asList(
                new Movie(1,"Avengers", "Joss Whedon", "2012", 8.1),
                new Movie(2,"About Time", "Richard Curtis", "2013", 7.3),
                new Movie(3,"The Secret Life of Walter Mitty", "Ben Stiller", "2013", 7.8)
        ));
        Navigator nav = new Navigator(books, movies);
        nav.start();
    }
}
