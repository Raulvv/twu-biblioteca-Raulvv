package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AuthManagerTests {
    private ArrayList<User> users = new ArrayList(Arrays.asList(
            new User("AA-101","admin", "123", "a@a.com", "example", "123456789",true),
            new User("AA-102","user1", "qwerty", "b@b.com", "whatever", "987654321",false),
            new User("AA-103","guess", "12345", "c@c.com", "mandatory", "873874223",false)
    ));

    @Test
    public void itChecksIfUsernameAndPasswordMatch() {
        User newUser = new User("AA-101","admin", "123", "a@a.com", "example", "123456789",true);
        assertTrue(AuthManager.isGoodCredentials("AA-101", "123", newUser));
    }

    @Test
    public void itChecksIfUsernameAndPasswordDoesNotMatch() {
        User newUser = new User("AA-101","admin", "123", "a@a.com", "example", "123456789",true);
        assertFalse(AuthManager.isGoodCredentials("AA-101", "2222", newUser));
    }

    @Test
    public void itReturnsAUserIfAUserIsSignedUp() {
        User sampleUser = users.get(0);
        User authenticatedUser = AuthManager.authenticateUser(users, "AA-101", "123");
        assertEquals(sampleUser.getCode(), authenticatedUser.getCode());
    }

    @Test
    public void itReturnsNullIfAUserIsNotSignedUp() {
        assertEquals(null, AuthManager.authenticateUser(users, "AA-101", "22222"));
    }

    @Test
    public void itReturnsTrueIfUserIsLibrarian() {
        assertTrue(AuthManager.checkLibrarianPermissions(new User("AA-101","admin", "123", "a@a.com", "example", "123456789",true)));
    }

    @Test
    public void itReturnsFalseIfUserIsNotLibrarian() {
        assertFalse(AuthManager.checkLibrarianPermissions(new User("AA-101","admin", "123", "a@a.com", "example", "123456789",false)));
    }
}
