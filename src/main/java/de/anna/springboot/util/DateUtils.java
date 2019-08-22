package de.anna.springboot.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateUtils {

    private static final String DATE_STRING_FORMAT = "dd.MM.yyyy";

    private DateUtils() {
    }

    public static LocalDate stringToLocalDate(String dateAusFormular) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_STRING_FORMAT);
        return LocalDate.parse(dateAusFormular, dateTimeFormatter);
    }


    public static String localDateToString(LocalDate localDate) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_STRING_FORMAT);
        return localDate.format(dateTimeFormatter);
    }
}
