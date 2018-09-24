package com.twu.biblioteca.library;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RatingTest {

    @Test
    public void testGetValue() {
        assertEquals(Integer.valueOf(1), Rating.ONE.getValue());
        assertEquals(Integer.valueOf(2), Rating.TWO.getValue());
        assertEquals(Integer.valueOf(3), Rating.THREE.getValue());
        assertEquals(Integer.valueOf(4), Rating.FOUR.getValue());
        assertEquals(Integer.valueOf(5), Rating.FIVE.getValue());
        assertEquals(Integer.valueOf(6), Rating.SIX.getValue());
        assertEquals(Integer.valueOf(7), Rating.SEVEN.getValue());
        assertEquals(Integer.valueOf(8), Rating.EIGHT.getValue());
        assertEquals(Integer.valueOf(9), Rating.NINE.getValue());
        assertEquals(Integer.valueOf(10), Rating.TEN.getValue());
        assertNull(Rating.UNRATED.getValue());
    }

    @Test
    public void testOf() {
        for (int i = 1; i <= 10; i++) {
            Rating rating = Rating.of(i);
            assertEquals(Integer.valueOf(i), rating.getValue());
        }
        assertEquals(Rating.UNRATED, Rating.of(null));
        assertEquals(Rating.UNRATED, Rating.of(0));
        assertEquals(Rating.UNRATED, Rating.of(11));
    }

    @Test
    public void testToString() {
        assertEquals("Unrated", Rating.UNRATED.toString());
        for (int i = 1; i <= 10; i++) {
            Rating rating = Rating.of(i);
            assertEquals(expectedFormat(rating), rating.toString());
        }
    }

    private static String expectedFormat(Rating rating) {
        if (rating == Rating.UNRATED) {
            return "Unrated";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rating.getValue(); i++) {
            sb.append("*");
        }
        return sb.toString();
    }
}
