package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Navigator nav = new Navigator();
        Printer printer = new Printer();

        printer.println(nav.welcome());
    }
}
