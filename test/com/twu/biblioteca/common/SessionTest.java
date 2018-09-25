package com.twu.biblioteca.common;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class SessionTest {

    private static Session session;

    @Before
    public void setUp() {
        session = new Session();
    }

    @Test
    public void testLogin() {
        assertFalse(session.isUserLoggedIn());
        assertNull(session.getCurrentUser());

        assertFalse(session.login("invalid username", "some password"));
        assertFalse(session.isUserLoggedIn());
        assertNull(session.getCurrentUser());

        assertFalse(session.login("valid username", "invalid password"));
        assertFalse(session.isUserLoggedIn());
        assertNull(session.getCurrentUser());

        assertTrue(session.login("valid username", "valid password"));
        assertTrue(session.isUserLoggedIn());
        User user = session.getCurrentUser();
        assertNotNull(user);
        assertEquals("valid username", user.getUsername());
    }

    @Test
    public void testLogout() {
        assertFalse(session.logout());

        session.login("valid username", "valid password");
        assertTrue(session.logout());
        assertFalse(session.isUserLoggedIn());
        assertNull(session.getCurrentUser());
    }

    @Test
    public void testIsAdminLoggedIn() {
        assertFalse(session.isAdminLoggedIn());

        session.login("librarian", "librarian password");
        assertTrue(session.isAdminLoggedIn());

        session.logout();
        assertFalse(session.isAdminLoggedIn());

        assertTrue(session.login("valid username", "valid password"));
        assertFalse(session.isAdminLoggedIn());
    }
}
