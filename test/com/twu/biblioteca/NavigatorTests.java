package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class NavigatorTests {
    private Navigator nav;
    private ArrayList<Item> books;
    private ArrayList<Item> movies;

    @Before
    public void initialize() {
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

        nav = new Navigator(books, movies);
    }

    @Test
    public void itStartAppSuccessfully() {
        assertEquals("On", nav.log);
    }

    @Test
    public void itReturnsWelcomeMessage() {
        assertEquals("Welcome to Biblioteca App", nav.welcome());
    }

    @Test
    public void itReturnsAListOfBooksAvailable() {
        List<String> books = nav.getAvailableBooks();
        assertEquals(3, books.size());
        assertEquals("1  |  Elon Musk  |  Ashlee Vance  |  2015", books.get(0));
    }

    @Test
    public void itReturnsAListOfMoviesAvailable() {
        List<String> books = nav.getAvailableMovies();
        assertEquals(3, movies.size());
        assertEquals("1  |  Avengers  |  Joss Whedon  |  2012  |  8.1", books.get(0));
    }

    @Test
    public void itCheckoutABookSuccessfully() {
        assertEquals("Thank you! Enjoy the book", nav.checkoutAvailableBook(1));
        assertTrue(CollectionManager.getItemById(books,1).isCheckout());
    }

    @Test
    public void itCheckoutAMovieSuccessfully() {
        assertEquals("Thank you! Enjoy the movie", nav.checkoutAvailableMovie(1));
        assertTrue(CollectionManager.getItemById(movies,1).isCheckout());
    }

    @Test
    public void itWarnsThatABookIsNotAvailable() {
        CollectionManager.getItemById(books,1).checkout();
        assertEquals("That book is not available.", nav.checkoutAvailableBook(1));
    }

    @Test
    public void itWarnsThatAMovieIsNotAvailable() {
        CollectionManager.getItemById(movies,1).checkout();
        assertEquals("That movie is not available.", nav.checkoutAvailableMovie(1));
    }

    @Test
    public void itReturnsABookSuccessfully() {
        CollectionManager.getItemById(books,1).checkout();
        assertEquals("Thank you for returning the book.", nav.returnBook(1));
    }

    @Test
    public void itWarnsThatABookIsNotAvailableForReturningWhenValidId() {
        assertEquals("That is not a valid book to return.", nav.returnBook(1));
    }

    @Test
    public void itWarnsThatABookIsNotAvailableForReturningWhenInvalidId() {
        assertEquals("That is not a valid book to return.", nav.returnBook(50000));
    }

    @Test
    public void itReturnsAMovieSuccessfully() {
        CollectionManager.getItemById(movies,1).checkout();
        assertEquals("Thank you for returning the movie.", nav.returnMovie(1));
    }

    @Test
    public void itWarnsThatAMovieIsNotAvailableForReturningWhenValidId() {
        assertEquals("That is not a valid movie to return.", nav.returnMovie(1));
    }

    @Test
    public void itWarnsThatAMovieIsNotAvailableForReturningWhenInvalidId() {
        assertEquals("That is not a valid movie to return.", nav.returnMovie(50000));
    }

    @Test
    public void itReturnsAStringWhenUserOptionIsNotANumber() {
        assertEquals("Select a valid option!", nav.executeUserOption("aa"));
        assertEquals("Select a valid option!", nav.executeUserOption("500"));
        assertEquals("Select a valid option!", nav.executeUserOption("0"));
    }
}
