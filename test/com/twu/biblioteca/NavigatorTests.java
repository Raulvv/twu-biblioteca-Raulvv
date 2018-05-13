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
                new Book(1,"Elon Musk", "Ashlee Vance", "2015"),
                new Book(2,"Interview with the Vampire", "Anne Rice", "1976"),
                new Book(3,"Homo Deus: A Brief History of Tomorrow", "Yuval Noah Harari", "2015")
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
    public void itReturnsMenuOptions() {
        assertEquals("1 - Show all books", nav.showMenu().get(0));
    }

    @Test
    public void itReturnsAListOfBooksAvailable() {
        List<String> books = nav.getAvailableBooks();
        assertEquals(3, books.size());
        assertEquals("1  |  Elon Musk  |  Ashlee Vance  |  2015", books.get(0).toString());
    }

    @Test
    public void itReturnsAListOfBooksWhenUserInputOne() {
        assertEquals(" ", nav.executeUserOption("1"));
    }

    @Test
    public void itReturnsAStringWhenUserOptionIsNotANumber() {
        assertEquals("Select a valid option!", nav.executeUserOption("aa"));
        assertEquals("Select a valid option!", nav.executeUserOption("500"));
        assertEquals("Select a valid option!", nav.executeUserOption("0"));
    }
}
