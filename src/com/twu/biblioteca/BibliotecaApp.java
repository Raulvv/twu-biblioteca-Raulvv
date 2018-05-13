package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {

    public static void main(String[] args) {
        ArrayList books = new ArrayList(Arrays.asList(
                new Book("Elon Musk", "Ashlee Vance", "2015"),
                new Book("Interview with the Vampire", "Anne Rice", "1976"),
                new Book("Homo Deus: A Brief History of Tomorrow", "Yuval Noah Harari", "2015")
        ));
        Library library = new Library(books);
        Navigator nav = new Navigator(library);
        String option = "";

        System.out.println(nav.welcome());
        while (option.toLowerCase() != "quit") {
            Printer.printList("What would you like to do?", nav.showMenu());
            System.out.println("Enter an option: ");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextLine();

            System.out.println(nav.executeUserOption(option));
        }
    }
}
