package com.twu.biblioteca;

public class User {
    private String username;
    private String password;
    private Boolean librarian;
    private String code;

    User(String code, String username, String password, Boolean librarian) {
        this.code = code;
        this.username = username;
        this.password = password;
        this.librarian = librarian;
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
}
