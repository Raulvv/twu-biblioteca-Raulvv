package com.twu.biblioteca;

import java.util.Scanner;

public class InputReader {
    private static Scanner reader;

    public static String getInputString() {
        reader = new Scanner(System.in);
        return reader.nextLine();
    }

    public static int getInputInteger() {
        try {
            reader = new Scanner(System.in);
            return reader.nextInt();
        } catch (Exception e) {
            return 0;
        }
    }
}
