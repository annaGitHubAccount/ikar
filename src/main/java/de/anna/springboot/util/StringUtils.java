package de.anna.springboot.util;

import java.util.HashMap;
import java.util.Map;

public final class StringUtils {

    private StringUtils() {
    }


    public static boolean isEmpty(String string) {

        return string == null || string.trim().equals("");
    }


    public static String[] convertStringToStringArray(String string) {

        if(string == null) {
            return null;
        }

        String[] stringGesplitted = string.split(",");

        int i = 0;
        String[] arrayTrimmed = new String[stringGesplitted.length];
        for (String str : stringGesplitted) {
            String trimmedString = str.trim();
            arrayTrimmed[i] = trimmedString;
            i++;
        }

        return arrayTrimmed;
    }

    public static Map<String, String> setzenAktivMapWerten() {

        Map<String, String> aktivMap = new HashMap<>();
        aktivMap.put("", "wähle eine Option aus");
        aktivMap.put("true", "ja");
        aktivMap.put("false", "nein");

        return aktivMap;
    }
}
