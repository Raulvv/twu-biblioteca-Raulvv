package com.twu.biblioteca;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Navigator {
    String log = "On";
    private ArrayList<Item> books;
    private ArrayList<Item> movies;
    private List<String> options;

    Navigator(ArrayList<Item> books, ArrayList<Item> movies) {
        this.books = books;
        this.movies = movies;
        this.options = Arrays.asList(
                "1 - Show all books",
                "2 - Checkout a book",
                "3 - Return a book",
                "4 - Show all movies",
                "5 - Checkout a movie",
                "6 - Return a movie"
        );
    }

    public void start() {
        String option = "";

        System.out.println(welcome());
        while (option.toLowerCase() != "quit") {
            Printer.printList("What would you like to do?", showMenu());
            System.out.print("Enter an option: ");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextLine();

            System.out.println(executeUserOption(option));
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
        } catch(NumberFormatException e) {
            return "Select a valid option!";
        }
        int bookId;

        switch (optionNumber) {
            case 1:
                List<String> booksList = getAvailableBooks();
                Printer.printList("ID  |  Title  |  Author  | Publication Year", booksList);
                return " ";
            case 2:
                bookId = getItemId();
                return checkoutAvailableBook(bookId);
            case 3:
                bookId = getItemId();
                return returnBook(bookId);
            case 4:
                List<String> moviesList = getAvailableMovies();
                Printer.printList("ID  |  Title  |  Director  | Publication Year  |  Rating", moviesList);
                return " ";
            case 5:
                bookId = getItemId();
                return checkoutAvailableMovie(bookId);
            case 6:
                bookId = getItemId();
                return returnMovie(bookId);
            default:
                return "Select a valid option!";
        }
    }

    public String checkoutAvailableBook(int bookId) {
        return CollectionManager.checkoutAvailableItem(bookId, books, "Thank you! Enjoy the book", "That book is not available.");
    }

    public String checkoutAvailableMovie(int movieId) {
        return CollectionManager.checkoutAvailableItem(movieId, movies, "Thank you! Enjoy the movie", "That movie is not available.");
    }

    public String returnBook(int bookId) {
        return CollectionManager.returnItem(bookId, books, "Thank you for returning the book.", "That is not a valid book to return.");
    }

    public String returnMovie(int movieId) {
        return CollectionManager.returnItem(movieId, movies, "Thank you for returning the movie.", "That is not a valid movie to return.");
    }

    public int getItemId() {
        System.out.print("Enter the book id: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        return parseInt(id);
    }
}
