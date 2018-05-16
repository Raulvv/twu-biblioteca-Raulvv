package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookTests {
    private Book book;

    @Before
    public void initialize() {
        book =  new Book(1,"Elon Musk", "Ashlee Vance", "2015");
    }

    @Test
    public void itCreatesAStringVersionOfABook() {
        assertEquals("1  |  Elon Musk  |  Ashlee Vance  |  2015", book.toString());
    }

    @Test
    public void itCheckoutsABook() {
        assertFalse(book.isCheckout());
        book.checkout("AA-101");
        assertTrue(book.isCheckout());
        assertEquals("AA-101", book.getTemporalOwner());
    }

    @Test
    public void itReturnsABook() {
        assertFalse(book.isCheckout());
        book.checkout("AA-101");
        assertTrue(book.isCheckout());
        book.checkin();
        assertFalse(book.isCheckout());
    }


}
