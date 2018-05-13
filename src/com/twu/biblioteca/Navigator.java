package com.twu.biblioteca;

import java.util.*;
import java.util.stream.Collectors;

public class Navigator {
    String log = "On";
    private Library library;

    Navigator(Library library) {
        this.library = library;
    }

    String welcome() {
        return "Welcome to Biblioteca App";
    }

    List<String> getBooksOnTheLibrary() {
        return library.getBooks().stream().map(book -> {
            return book.toString();
        }).collect(Collectors.toList());
    }
}
