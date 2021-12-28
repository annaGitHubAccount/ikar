package de.anna.springboot.util;

public final class MathUtils {

    private static final int POSTRGESQL_INT_MAX_RANGE = 2147483647;

    public static long generateRandomKundeNummer(){

        long random = (long) (Math.random() * POSTRGESQL_INT_MAX_RANGE);
        return random;

    }

    private MathUtils() {
    }
}
