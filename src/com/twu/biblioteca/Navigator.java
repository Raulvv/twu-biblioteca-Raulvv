package com.twu.biblioteca;

import javax.naming.AuthenticationException;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Navigator {
    private ArrayList<Item> books;
    private ArrayList<Item> movies;
    private List<String> options;
    private User currentUser;
    private ArrayList<User> users = new ArrayList(Arrays.asList(
            new User("AA-101","admin", "123", "a@a.com", "example", "123456789",true),
            new User("AA-102","user1", "qwerty", "b@b.com", "whatever", "987654321",false),
            new User("AA-103","guess", "12345", "c@c.com", "mandatory", "873874223",false)
    ));

    Navigator(List<String> options, ArrayList<Item> books, ArrayList<Item> movies) {
        this.books = books;
        this.movies = movies;
        this.options = options;
        this.currentUser = null;
    }

    public void start() {
        User loggedUser = null;
        System.out.println(welcome());
        while (loggedUser == null) {
            loggedUser = askToLogin();
            if (loggedUser == null) {
                System.out.println("Wrong username or password!");
            }
        }
        setCurrentUser(loggedUser);
        buildMenu();
        startMenu();
    }

    void setCurrentUser(User user) {
        this.currentUser = user;
    }

    private void startMenu() {
        String option = "";

        while (option.toLowerCase() != "quit") {
            showMenu();
            System.out.print("Enter an option: ");
            option = InputReader.getInputString();

            if (option.toLowerCase() != "quit") {
                System.out.println(executeUserOption(option));
            }
        }
    }

    private User askToLogin() {
        System.out.println("Enter a username: ");
        String username = InputReader.getInputString();
        System.out.println("Enter a password: ");
        String password = InputReader.getInputString();
        return AuthManager.authenticateUser(users, username, password);
    }

    String welcome() {
        return "Welcome to Biblioteca App";
    }

    List<String> buildMenu() {
        if (this.currentUser.isLibrarian()) {
            this.options.add("7 - Check unavailable books");
            this.options.add("8 - Check unavailable movies");
        }
        return this.options;
    }

    private void showMenu() {
        Printer.printList("What would you like to do?", this.options);
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
            if (option.toLowerCase().equals("profile")) {
                return this.currentUser.toString();
            }
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
                case 7:
                    if (AuthManager.checkLibrarianPermissions(this.currentUser)) {
                        List<String> unavailableBooks = getUnavailableBooks();
                        Printer.printList("ID  |  Title  |  User Code", unavailableBooks);
                        return " ";
                    } else {
                        throw new AuthenticationException();
                    }
                case 8:
                    if (AuthManager.checkLibrarianPermissions(this.currentUser)) {
                        List<String> unavailableMovies = getUnavailableMovies();
                        Printer.printList("ID  |  Title  |  User Code", unavailableMovies);
                        return " ";
                    } else {
                        throw new AuthenticationException();
                    }
                default:
                    return "Select a valid option!";
            }
        } catch(Exception e) {
            return "Select a valid option!";
        }
    }

    private List<String> getUnavailableBooks() {
        return CollectionManager.getUnavailableItems(books);
    }

    private List<String> getUnavailableMovies() {
        return CollectionManager.getUnavailableItems(movies);
    }

    public String checkoutAvailableBook() {
        System.out.print("Enter a book id: ");
        int bookId = InputReader.getInputInteger();
        return CollectionManager.checkoutAvailableItem(bookId, books, "AA-101","Thank you! Enjoy the book", "That book is not available.");
    }

    public String checkoutAvailableMovie() {
        System.out.print("Enter a movie id: ");
        int movieId = InputReader.getInputInteger();
        return CollectionManager.checkoutAvailableItem(movieId, movies, "AA-101","Thank you! Enjoy the movie", "That movie is not available.");
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
