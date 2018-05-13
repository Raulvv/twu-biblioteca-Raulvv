package com.twu.biblioteca;

import java.util.*;

public class Library {
    private ArrayList<Book> books;

    Library(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
