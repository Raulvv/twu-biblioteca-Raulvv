package com.twu.biblioteca;

public class User {
    private String username;
    private String password;
    private Boolean librarian;
    private String code;
    private String email;
    private String address;
    private String phoneNumber;


    User(String code, String username, String password, String email, String address, String phoneNumber, Boolean librarian) {
        this.code = code;
        this.username = username;
        this.password = password;
        this.librarian = librarian;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Boolean isLibrarian() {
        return librarian;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCode() {
        return code;
    }

    public String toString() {
        return this.code + "  |  " + this.username + "  |  " + this.email + "  |  " + this.address + "  |  " + this.phoneNumber;
    }
}
