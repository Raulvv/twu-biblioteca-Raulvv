package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class LibraryTests {
    private Library library;
    private ArrayList<Book> books;

    @Before
    public void initialize() {
        books = new ArrayList(Arrays.asList(
           new Book("Elon Musk", "Ashlee Vance", "2015"),
           new Book("Interview with the Vampire", "Anne Rice", "1976"),
           new Book("Homo Deus: A Brief History of Tomorrow", "Yuval Noah Harari", "2015")
        ));
        library = new Library(books);
    }

    @Test
    public void itReturnsTheFullListOfBooks() {
        assertEquals(books.size(), library.getBooks().size());
    }
}