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
        this.options = Arrays.asList("1 - Show all books", "2 - Checkout a book");
    }

    String welcome() {
        return "Welcome to Biblioteca App";
    }

    List<String> showMenu() {
        return this.options;
    }

    List<String> getAvailableBooks() {
        List<String> availableBooks = new ArrayList<>();
        for (Book book: library.getBooks()) {
            if (!book.isCheckout()) {
                availableBooks.add(book.toString());
            }
        }
        return availableBooks;
    }

    String executeUserOption(String option) {
        try {
            int optionNumber = parseInt(option);
            if (optionNumber <= this.options.size() && optionNumber > 0) switch (optionNumber) {
                case 1:
                    List<String> booksList = getAvailableBooks();
                    Printer.printList("Title  |  Author  | Publication Year", booksList);
                    return " ";
                case 2:
                    checkoutAvailableBook();
                    return "Successfully checked!";
            }
            else {
                throw new IndexOutOfBoundsException();
            }
            return "Select a valid option!";

        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            return "Select a valid option!";
        }
    }

    public void checkoutAvailableBook() {
        int bookId = getBookId();
        Book selectedBook = library.getBookById(bookId);
        selectedBook.checkout();
    }

    public int getBookId() {
        System.out.print("Enter the book id: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        return parseInt(id);
    }
}
