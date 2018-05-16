package com.twu.biblioteca;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class NavigatorTests {
    private Navigator nav;
    private ArrayList<Item> books;
    private ArrayList<Item> movies;

    @Before
    public void initialize() {
        List<String> options = Arrays.asList(
                "1 - Show all books",
                "2 - Checkout a book",
                "3 - Return a book",
                "4 - Show all movies",
                "5 - Checkout a movie",
                "6 - Return a movie"
        );

        books = new ArrayList(Arrays.asList(
                new Book(1,"Elon Musk", "Ashlee Vance", "2015"),
                new Book(2,"Interview with the Vampire", "Anne Rice", "1976"),
                new Book(3,"Homo Deus: A Brief History of Tomorrow", "Yuval Noah Harari", "2015")
        ));

        movies = new ArrayList(Arrays.asList(
                new Movie(1,"Avengers", "Joss Whedon", "2012", 8.1),
                new Movie(2,"About Time", "Richard Curtis", "2013", 7.3),
                new Movie(3,"The Secret Life of Walter Mitty", "Ben Stiller", "2013", 7.8)
        ));

        nav = new Navigator(options, books, movies);
    }

    @Test
    public void itReturnsWelcomeMessage() {
        assertEquals("Welcome to Biblioteca App", nav.welcome());
    }

    @Test
    public void itReturnsAWarningWhenUserOptionIsNotAValidOption() {
        assertEquals("Select a valid option!", nav.executeUserOption("aa"));
    }

    @Test
    public void itReturnsAWarningWhenUserOptionIsOutOfRange() {
        assertEquals("Select a valid option!", nav.executeUserOption("500"));
        assertEquals("Select a valid option!", nav.executeUserOption("0"));
    }

    @Test
    public void itReturnsAUserInformationWhenInputIsProfile() {
        nav.setCurrentUser(new User("AA-101","admin", "123", "a@a.com", "example", "123456789",false));
        assertEquals("AA-101  |  admin  |  a@a.com  |  example  |  123456789", nav.executeUserOption("profile"));
    }

    @Test
    public void itReturnsAWarningWhenUserIsNotLibrarianAndTriesToAccessUnavailableBooks() {
        nav.setCurrentUser(new User("AA-101","admin", "123", "a@a.com", "example", "123456789",false));
        assertEquals("Select a valid option!", nav.executeUserOption("7"));
    }

    @Test
    public void itReturnsAWarningWhenUserIsNotLibrarianAndTriesToAccessUnavailableMovies() {
        nav.setCurrentUser(new User("AA-101","admin", "123", "a@a.com", "example", "123456789",false));
        assertEquals("Select a valid option!", nav.executeUserOption("8"));
    }

    @Test
    public void itReturnsAListOfBooksAvailable() {
        List<String> books = nav.getAvailableBooks();
        assertEquals(3, books.size());
        assertEquals("1  |  Elon Musk  |  Ashlee Vance  |  2015", books.get(0));
    }

    @Test
    public void itReturnsAListOfMoviesAvailable() {
        List<String> movies = nav.getAvailableMovies();
        assertEquals(3, movies.size());
        assertEquals("1  |  Avengers  |  Joss Whedon  |  2012  |  8.1", movies.get(0));
    }

    @Test
    public void itCheckoutABookSuccessfully() {
        testInputString("1");
        assertEquals("Thank you! Enjoy the book", nav.checkoutAvailableBook());
        Item book = books.get(0);
        assertEquals(1, book.getId());
        assertTrue(book.isCheckout());
    }

    @Test
    public void itCheckoutAMovieSuccessfully() {
        testInputString("1");
        assertEquals("Thank you! Enjoy the movie", nav.checkoutAvailableMovie());
        Item movie = movies.get(0);
        assertEquals(1, movie.getId());
        assertTrue(movie.isCheckout());
    }

    @Test
    public void itWarnsThatABookIsNotAvailable() {
        Item book = books.get(0);
        assertEquals(1, book.getId());
        book.checkout("AA-101");
        testInputString("1323");
        assertEquals("That book is not available.", nav.checkoutAvailableBook());
    }

    @Test
    public void itWarnsThatAMovieIsNotAvailable() {
        Item movie = movies.get(0);
        assertEquals(1, movie.getId());
        movie.checkout("AA-101");
        testInputString("123123");
        assertEquals("That movie is not available.", nav.checkoutAvailableMovie());
    }

    @Test
    public void itReturnsABookSuccessfully() {
        Item book = books.get(0);
        assertEquals(1, book.getId());
        book.checkout("AA-101");
        testInputString("1");
        assertEquals("Thank you for returning the book.", nav.returnBook());
    }

    @Test
    public void itWarnsThatABookIsNotAvailableForReturningWhenValidId() {
        testInputString("1545");
        assertEquals("That is not a valid book to return.", nav.returnBook());
    }

    @Test
    public void itWarnsThatABookIsNotAvailableForReturningWhenInvalidId() {
        testInputString("NotValid");
        assertEquals("That is not a valid book to return.", nav.returnBook());
    }

    @Test
    public void itReturnsAMovieSuccessfully() {
        Item movie = movies.get(0);
        assertEquals(1, movie.getId());
        movie.checkout("AA-101");
        testInputString("1");
        assertEquals("Thank you for returning the movie.", nav.returnMovie());
    }

    @Test
    public void itWarnsThatAMovieIsNotAvailableForReturningWhenValidId() {
        testInputString("500");
        assertEquals("That is not a valid movie to return.", nav.returnMovie());
    }

    @Test
    public void itWarnsThatAMovieIsNotAvailableForReturningWhenInvalidId() {
        testInputString("NotValid");
        assertEquals("That is not a valid movie to return.", nav.returnMovie());
    }

    private void testInputString(String s) {
        String input = s;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
