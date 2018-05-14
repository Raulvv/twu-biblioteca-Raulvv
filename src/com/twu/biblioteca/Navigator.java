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
        return getAvailableItems(books);
    }

    List<String> getAvailableMovies() {
        return getAvailableItems(movies);
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
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            return "Select a valid option!";
        }
        return "Select a valid option!";
    }

    public String checkoutAvailableBook(int bookId) {
        return checkoutAvailableItem(bookId, books, "Thank you! Enjoy the book", "That book is not available.");
    }

    public String checkoutAvailableMovie(int movieId) {
        return checkoutAvailableItem(movieId, movies, "Thank you! Enjoy the movie", "That movie is not available.");
    }

    public String returnBook(int bookId) {
        return returnItem(bookId, books, "Thank you for returning the book.", "That is not a valid book to return.");
    }

    public String returnMovie(int movieId) {
        return returnItem(movieId, movies, "Thank you for returning the movie.", "That is not a valid movie to return.");
    }

    private List<String> getAvailableItems(ArrayList<Item> collection) {
        List<String> availableItems = new ArrayList<>();
        for (Item item: collection) {
            if (!item.isCheckout()) {
                availableItems.add(item.toString());
            }
        }
        return availableItems;
    }

    private String checkoutAvailableItem(int id, ArrayList<Item> collection, String successMessage, String errorMessage) {
        try {
            Item selectedItem = CollectionManager.getItemById(collection, id);
            if (selectedItem.isCheckout()) {
                return errorMessage;
            } else {
                selectedItem.checkout();
                return successMessage;
            }
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            return errorMessage;
        }
    }

    private String returnItem(int id, ArrayList<Item> collection, String successMessage, String errorMessage) {
        try {
            Item selectedItem = CollectionManager.getItemById(collection, id);
            if (selectedItem.isCheckout()) {
                selectedItem.checkout();
                return successMessage;
            } else {
                return errorMessage;
            }
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            return errorMessage;
        }
    }

    public int getItemId() {
        System.out.print("Enter the book id: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        return parseInt(id);
    }
}
