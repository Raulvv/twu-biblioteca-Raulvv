package com.twu.biblioteca;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CollectionManagerTests {
    private static ArrayList<Item> itemsMock;

    @Before
    public void initialize() {
        itemsMock = new ArrayList(Arrays.asList(
                new Book(1,"Elon Musk", "Ashlee Vance", "2015"),
                new Book(2,"Interview with the Vampire", "Anne Rice", "1976"),
                new Book(3,"Homo Deus: A Brief History of Tomorrow", "Yuval Noah Harari", "2015"),
                new Movie(4,"Avengers", "Joss Whedon", "2012", 8.1),
                new Movie(5,"About Time", "Richard Curtis", "2013", 7.3),
                new Movie(6,"The Secret Life of Walter Mitty", "Ben Stiller", "2013", 7.8)
        ));
    }

    @Test
    public void itReturnsAnItemByItIdIfExists() {
        Item movie = CollectionManager.getItemById(itemsMock, 1);
        assertEquals(1, movie.getId());
    }

    @Test
    public void itReturnsNullIfItemDoesNotExist() {
        Item movie = CollectionManager.getItemById(itemsMock, 500);
        assertEquals(null, movie);
    }

    @Test
    public void itReturnsAListOfItemsAvailable() {
        List<String> items = CollectionManager.getAvailableItems(itemsMock);
        assertEquals(6, items.size());
        assertEquals("1  |  Elon Musk  |  Ashlee Vance  |  2015", items.get(0));
    }

    @Test
    public void itReturnsAListOfItemsUnavailable() {
        itemsMock.get(0).checkout("AA-101");
        itemsMock.get(1).checkout("AA-101");
        List<String> items = CollectionManager.getUnavailableItems(itemsMock);
        assertEquals(2, items.size());
        assertEquals("1  |  Elon Musk  |  AA-101", items.get(0));
    }

    @Test
    public void itCheckoutAnItemSuccessfully() {
        assertEquals("Success message", CollectionManager.checkoutAvailableItem(1, itemsMock, "AA-101","Success message", "Error message"));
    }

    @Test
    public void itWarnsThatAnItemIsNotAvailable() {
        Item item = itemsMock.get(0);
        assertEquals(1, item.getId());
        item.checkout("AA-101");
        assertEquals("Error message", CollectionManager.checkoutAvailableItem(1, itemsMock, "AA-101","Success message", "Error message"));
    }

    @Test
    public void itReturnsAnItemSuccessfully() {
        Item item = itemsMock.get(0);
        assertEquals(1, item.getId());
        item.checkout("AA-101");
        assertEquals("Success message", CollectionManager.returnItem(1, itemsMock, "Success message", "Error message"));
    }

    @Test
    public void itWarnsThatAnItemIsNotAvailableForReturningWhenValidId() {
        assertEquals("Error message", CollectionManager.returnItem(1, itemsMock, "Success message", "Error message"));
    }

    @Test
    public void itWarnsThatAnItemIsNotAvailableForReturningWhenInvalidId() {
        assertEquals("Error message", CollectionManager.returnItem(5000, itemsMock, "Success message", "Error message"));
    }
}
