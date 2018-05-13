package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTests {

    @Test
    public void itCreatesAStringVersionOfABook() {
        Book book =  new Book("Elon Musk", "Ashlee Vance", "2015");
        assertEquals("Elon Musk  |  Ashlee Vance  |  2015", book.toString());
    }
}
