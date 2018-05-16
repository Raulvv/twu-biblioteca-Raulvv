package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTests {
    private User user;
    @Before
    public void initialize() {
        user =  new User("AA-101","Elon Musk", "111", "a@a.com", "California","612345678", false);
    }

    @Test
    public void itCreatesAStringVersionOfABook() {
        assertEquals("AA-101  |  Elon Musk  |  a@a.com  |  California  |  612345678", user.toString());
    }
}
