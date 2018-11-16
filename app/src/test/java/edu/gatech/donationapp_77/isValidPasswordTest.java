package edu.gatech.donationapp_77;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for valid passwords
 */
public class isValidPasswordTest {
    private User goodUser1;
    private User goodUser2;
    private User badUser;
    private User badPassword;
    private User badEmail;
    private User nullUser;
    private User nullEmail;
    private User nullPassword;

    /**
     * Sets up POJOs, etc
     */
    @Before
    public void setup() {
        goodUser1 = new User("goodUser@example.com", "passTest");
        goodUser2 = new User("goodUser2@example.com", "passTest2");
        badUser = new User("badUser@example.com", "failTest");
        badPassword = new User("goodUser@example.com", "failTest");
        badEmail = new User("badEmail@example.com", "passTest");
        nullUser = new User(null, null);
        nullEmail = new User(null, "notNull");
        nullPassword = new User("notNull@example.com", null);
        User.addUser(goodUser1);
        User.addUser(goodUser2);
    }

    /**
     * Tests for null exception
     */
    @Test(expected = NullPointerException.class)
    public void checkNull() {
        assertFalse(LoginActivity2.isValidPassword(nullUser));
        assertFalse(LoginActivity2.isValidPassword(nullEmail));
        assertFalse(LoginActivity2.isValidPassword(nullPassword));
        assertFalse(LoginActivity2.isValidPassword(null));

    }

    /**
     * Tests if a bad email fails
     */
    @Test
    public void checkBadEmail() {
        assertFalse(LoginActivity2.isValidPassword(badEmail));
    }

    /**
     * Tests if a bad password fails
     */
    @Test
    public void checkBadPassword() {
        assertFalse(LoginActivity2.isValidPassword(badPassword));
    }

    /**
     * Tests that the user list is properly updated
     */
    @Test
    public void checkUserList() {
        assertFalse(LoginActivity2.isValidPassword(badUser));
        assertTrue(LoginActivity2.isValidPassword(goodUser1));
        assertTrue(LoginActivity2.isValidPassword(goodUser2));
    }
}
