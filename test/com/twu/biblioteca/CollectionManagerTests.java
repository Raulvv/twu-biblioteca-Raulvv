package com.twu.biblioteca;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CollectionManagerTests {
    private static ArrayList<Item> movies;

    @BeforeClass
    public static void onlyOnce() {
        movies = new ArrayList(Arrays.asList(
                new Movie(1,"Avengers", "Joss Whedon", "2012", 8.1),
                new Movie(2,"About Time", "Richard Curtis", "2013", 7.3),
                new Movie(3,"The Secret Life of Walter Mitty", "Ben Stiller", "2013", 7.8)
        ));
    }

    @Test
    public void itReturnsAMovieByItId() {
        Item movie = CollectionManager.getItemById(movies, 1);
        assertEquals(1, movie.getId());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void itReturnsIndexOutOfBoundsExceptionWhenAskingForNonExistingMovies() {
        CollectionManager.getItemById(movies, 5000);
    }
}
