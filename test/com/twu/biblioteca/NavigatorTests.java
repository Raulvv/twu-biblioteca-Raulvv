package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class NavigatorTests {
    private Navigator nav;

    @Before
    public void initialize() {
        ArrayList books = new ArrayList(Arrays.asList(
                new Book("Elon Musk", "Ashlee Vance", "2015"),
                new Book("Interview with the Vampire", "Anne Rice", "1976"),
                new Book("Homo Deus: A Brief History of Tomorrow", "Yuval Noah Harari", "2015")
        ));
        Library library = new Library(books);
        nav = new Navigator(library);
    }

    @Test
    public void itStartAppSuccesfully() {
        assertEquals("On", nav.log);
    }

    @Test
    public void itReturnsWelcomeMessage() {
        assertEquals("Welcome to Biblioteca App", nav.welcome());
    }

    @Test
    public void itReturnsAListOfBooksInfo() {
        List<String> books = nav.getBooksOnTheLibrary();
        assertEquals(3, books.size());
        assertEquals("Elon Musk  |  Ashlee Vance  |  2015", books.get(0).toString());
    }
}
