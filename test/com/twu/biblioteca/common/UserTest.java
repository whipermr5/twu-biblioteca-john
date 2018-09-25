package com.twu.biblioteca.common;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void testConstructor() {
        User user = new User("username", "password", "name", "email", 0);
        assertEquals("username", user.getUsername());
        assertTrue(user.isPassword("password"));
        assertFalse(user.isPassword(""));
        assertEquals("name", user.getName());
        assertEquals("email", user.getEmail());
        assertEquals(0, user.getNumber());
    }
}
