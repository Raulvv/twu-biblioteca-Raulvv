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

    public Book getBookById(int id) {
        Boolean found = false;
        int index = 0;

        while (!found) {
            if (this.books.get(index).getId() == id) {
                found = true;
            } else {
                index++;
            }
        }
        return this.books.get(index);
    }
}
