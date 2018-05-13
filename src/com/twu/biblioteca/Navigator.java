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
        this.options = Arrays.asList("1 - Show all books", "2 - Checkout a book", "3 - Return a book");
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
            int bookId = 0;
            if (optionNumber <= this.options.size() && optionNumber > 0) switch (optionNumber) {
                case 1:
                    List<String> booksList = getAvailableBooks();
                    Printer.printList("ID  |  Title  |  Author  | Publication Year", booksList);
                    return " ";
                case 2:
                    bookId = getBookId();
                    return checkoutAvailableBook(bookId);
                case 3:
                    bookId = getBookId();
                    return returnBook(bookId);
            }
            else {
                throw new IndexOutOfBoundsException();
            }
            return "Select a valid option!";

        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            return "Select a valid option!";
        }
    }

    public String checkoutAvailableBook(int bookId) {
        Book selectedBook = library.getBookById(bookId);
        if (selectedBook.isCheckout()) {
            return "That book is not available.";
        } else {
            selectedBook.checkout();
            return "Thank you! Enjoy the book";
        }
    }

    public String returnBook(int bookId) {
        Book selectedBook = library.getBookById(bookId);
        if (selectedBook.isCheckout()) {
            selectedBook.checkout();
            return "Thank you for returning the book.";
        } else {
            return "That is not a valid book to return.";
        }
    }

    public int getBookId() {
        System.out.print("Enter the book id: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        return parseInt(id);
    }
}
