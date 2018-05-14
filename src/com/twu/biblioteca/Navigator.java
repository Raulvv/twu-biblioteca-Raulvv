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
        this.options = Arrays.asList("1 - Show all books", "2 - Checkout a book", "3 - Return a book", "4 - Show all movies", "5 - Checkout a movie", "6 - Return a movie");
    }

    String welcome() {
        return "Welcome to Biblioteca App";
    }

    List<String> showMenu() {
        return this.options;
    }

    List<String> getAvailableBooks() {
        List<String> availableBooks = new ArrayList<>();
        for (Item book: books) {
            if (!book.isCheckout()) {
                availableBooks.add(book.toString());
            }
        }
        return availableBooks;
    }

    List<String> getAvailableMovies() {
        List<String> availableMovies = new ArrayList<>();
        for (Item movie: movies) {
            if (!movie.isCheckout()) {
                availableMovies.add(movie.toString());
            }
        }
        return availableMovies;
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
        Item selectedBook = CollectionManager.getItemById(books, bookId);
        if (selectedBook.isCheckout()) {
            return "That book is not available.";
        } else {
            selectedBook.checkout();
            return "Thank you! Enjoy the book";
        }
    }

    public String checkoutAvailableMovie(int movieId) {
        Item selectedMovie = CollectionManager.getItemById(movies, movieId);
        if (selectedMovie.isCheckout()) {
            return "That movie is not available.";
        } else {
            selectedMovie.checkout();
            return "Thank you! Enjoy the movie";
        }
    }

    public String returnBook(int bookId) {
        Item selectedBook = CollectionManager.getItemById(books, bookId);
        if (selectedBook.isCheckout()) {
            selectedBook.checkout();
            return "Thank you for returning the book.";
        } else {
            return "That is not a valid book to return.";
        }
    }

    public String returnMovie(int movieId) {
        Item selectedMovie = CollectionManager.getItemById(movies, movieId);
        if (selectedMovie.isCheckout()) {
            selectedMovie.checkout();
            return "Thank you for returning the movie.";
        } else {
            return "That is not a valid movie to return.";
        }
    }

    public int getItemId() {
        System.out.print("Enter the book id: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        return parseInt(id);
    }

    public ArrayList<Item> getBooks() {
        return books;
    }

    public ArrayList<Item> getMovies() {
        return movies;
    }
}
