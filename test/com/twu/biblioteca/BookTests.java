package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookTests {

    @Test
    public void itCreatesAStringVersionOfABook() {
        Book book =  new Book(1,"Elon Musk", "Ashlee Vance", "2015");
        assertEquals("1  |  Elon Musk  |  Ashlee Vance  |  2015", book.toString());
    }

    @Test
    public void itCheckoutsABook() {
        Book book =  new Book(1,"Elon Musk", "Ashlee Vance", "2015");
        assertFalse(book.isCheckout());
        book.checkout();
        assertTrue(book.isCheckout());
    }


}
