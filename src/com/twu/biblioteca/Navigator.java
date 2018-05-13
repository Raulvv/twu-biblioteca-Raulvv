package com.twu.biblioteca;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Navigator {
    String log = "On";
    private Library library;
    private List<String> options;

    Navigator(Library library) {
        this.library = library;
        this.options = Arrays.asList("1 - Show all books");
    }

    String welcome() {
        return "Welcome to Biblioteca App";
    }

    List<String> showMenu() {
        return this.options;
    }

    List<String> getBooksOnTheLibrary() {
        return library.getBooks().stream().map(book -> {
            return book.toString();
        }).collect(Collectors.toList());
    }

    List<String> executeUserOption(String option) {
        try {
            int optionNumber = parseInt(option);
            if (optionNumber <= this.options.size() && optionNumber > 0) {
                switch (optionNumber) {
                    case 1:
                        return getBooksOnTheLibrary();
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
            return Collections.singletonList("Select a valid option!");

        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            return Collections.singletonList("Select a valid option!");
        }
    }
}
