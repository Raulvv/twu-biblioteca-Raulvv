package com.twu.biblioteca;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Navigator {
    String log = "On";
    private ArrayList<Item> books;
    private ArrayList<Item> movies;
    private List<String> options;

    Navigator(List<String> options, ArrayList<Item> books, ArrayList<Item> movies) {
        this.books = books;
        this.movies = movies;
        this.options = options;
    }

    public void start() {
        String option = "";

        System.out.println(welcome());
        while (option.toLowerCase() != "quit") {
            Printer.printList("What would you like to do?", showMenu());
            System.out.print("Enter an option: ");
            option = InputReader.getInputString();

            if (option.toLowerCase() != "quit") {
                System.out.println(executeUserOption(option));
            }
        }
    }

    String welcome() {
        return "Welcome to Biblioteca App";
    }

    List<String> showMenu() {
        return this.options;
    }

    List<String> getAvailableBooks() {
        return CollectionManager.getAvailableItems(books);
    }

    List<String> getAvailableMovies() {
        return CollectionManager.getAvailableItems(movies);
    }

    String executeUserOption(String option) {
        int optionNumber;
        try {
            optionNumber = parseInt(option);
            int bookId;

            switch (optionNumber) {
                case 1:
                    List<String> booksList = getAvailableBooks();
                    Printer.printList("ID  |  Title  |  Author  | Publication Year", booksList);
                    return " ";
                case 2:
                    return checkoutAvailableBook();
                case 3:
                    return returnBook();
                case 4:
                    List<String> moviesList = getAvailableMovies();
                    Printer.printList("ID  |  Title  |  Director  | Publication Year  |  Rating", moviesList);
                    return " ";
                case 5:
                    return checkoutAvailableMovie();
                case 6:
                    return returnMovie();
                default:
                    return "Select a valid option!";
            }
        } catch(NumberFormatException e) {
            return "Select a valid option!";
        }
    }

    public String checkoutAvailableBook() {
        System.out.print("Enter a book id: ");
        int bookId = InputReader.getInputInteger();
        return CollectionManager.checkoutAvailableItem(bookId, books, "Thank you! Enjoy the book", "That book is not available.");
    }

    public String checkoutAvailableMovie() {
        System.out.print("Enter a movie id: ");
        int movieId = InputReader.getInputInteger();
        return CollectionManager.checkoutAvailableItem(movieId, movies, "Thank you! Enjoy the movie", "That movie is not available.");
    }

    public String returnBook() {
        System.out.print("Enter a book id: ");
        int bookId = InputReader.getInputInteger();
        return CollectionManager.returnItem(bookId, books, "Thank you for returning the book.", "That is not a valid book to return.");
    }

    public String returnMovie() {
        System.out.print("Enter a movie id: ");
        int movieId = InputReader.getInputInteger();
        return CollectionManager.returnItem(movieId, movies, "Thank you for returning the movie.", "That is not a valid movie to return.");
    }
}
