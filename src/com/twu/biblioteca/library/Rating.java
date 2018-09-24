package com.twu.biblioteca.library;

public enum Rating {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), UNRATED(null);

    private Integer value;

    Rating(Integer value) {
        this.value = value;
    }

    public static Rating of(Integer value) {
        if (value == null || value < 1 || value > 10) {
            return UNRATED;
        }
        return Rating.values()[value - 1];
    }

    public Integer getValue() {
        return value;
    }
}
