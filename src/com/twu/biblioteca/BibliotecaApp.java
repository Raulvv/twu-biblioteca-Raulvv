package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApp {

    public static void main(String[] args) {
        ArrayList books = new ArrayList(Arrays.asList(
                new Book("Elon Musk", "Ashlee Vance", "2015"),
                new Book("Interview with the Vampire", "Anne Rice", "1976"),
                new Book("Homo Deus: A Brief History of Tomorrow", "Yuval Noah Harari", "2015")
        ));
        Library library = new Library(books);
        Navigator nav = new Navigator(library);

        Printer.println(nav.welcome());
        Printer.printList("Title  |  Author  |  Publication Year", nav.getBooksOnTheLibrary());
    }
}
