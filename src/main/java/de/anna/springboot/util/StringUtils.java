package de.anna.springboot.util;

public final class StringUtils {

    private StringUtils() {
    }


    public static boolean isEmpty(String string) {

        return string == null || string.equals("");
    }
}
