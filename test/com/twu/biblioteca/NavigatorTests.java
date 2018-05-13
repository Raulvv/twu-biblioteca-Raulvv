package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NavigatorTests {
    private Navigator nav;

    @Before
    public void initialize() {
        nav = new Navigator();
    }

    @Test
    public void itStartAppSuccesfully() {
        assertEquals(nav.log, "On");
    }

    @Test
    public void itReturnsWelcomeMessage() {
        Navigator nav = new Navigator();
        assertEquals(nav.welcome(), "Welcome to Biblioteca App");
    }
}
