package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovieTests {
    private Movie movie;

    @Before
    public void initialize() {
        movie =  new Movie(1,"Avengers", "Joss Whedon", "2012", 8.1);
    }

    @Test
    public void itCreatesAStringVersionOfAMovie() {
        assertEquals("1  |  Avengers  |  Joss Whedon  |  2012  |  8.1", movie.toString());
    }

    @Test
    public void itCheckoutsAMovie() {
        assertFalse(movie.isCheckout());
        movie.checkout();
        assertTrue(movie.isCheckout());
    }

    @Test
    public void itReturnsAMovie() {
        assertFalse(movie.isCheckout());
        movie.checkout();
        assertTrue(movie.isCheckout());
        movie.checkout();
        assertFalse(movie.isCheckout());
    }
}
