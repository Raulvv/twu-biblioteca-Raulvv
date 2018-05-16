package com.twu.biblioteca;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.Arrays;

public class AuthManager {

    public static User authenticateUser(ArrayList<User> users, String code, String password) {
        int i = 0;
        Boolean found = false;

        while (i < users.size() && !found) {
            if (isGoodCredentials(code, password, users.get(i))) {
                found = true;
            } else {
                i++;
            }
        }

        if (found) return users.get(i);
        else return null;
    }

    public static Boolean isGoodCredentials(String code, String password, User user) {
        return user.getCode().equals(code) && user.getPassword().equals(password);
    }

    public static Boolean checkLibrarianPermissions(User user) {
        return user.isLibrarian();
    }
}
