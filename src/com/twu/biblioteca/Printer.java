package com.twu.biblioteca;

import java.util.List;

public class Printer {

    public static void printList(String head, List<String> elements) {
        System.out.println(head);
        System.out.println(" ");
        for (String s: elements) {
            System.out.println(s);
        }
    }
}
