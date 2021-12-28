package de.anna.springboot.util;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class KundeNummerUtils {

    private static String generateDateAlsString(){

        LocalDate localDateNow = LocalDate.now();
        String formattedDate = localDateNow.format(DateTimeFormatter.ofPattern("yyMM"));

        return formattedDate;
    }



    public static String generateKundeNummerAlsString(Long kundeNummerSequence){

        StringBuilder stringBuilder = new StringBuilder();

        String dateAlsString = generateDateAlsString();
        String kundeNUmmerSequenceAlsString = String.valueOf(kundeNummerSequence);
        String kundeNummer = StringUtils.leftPad(kundeNUmmerSequenceAlsString, 4, "0");
        stringBuilder.append(dateAlsString).append("K").append(kundeNummer);

        return stringBuilder.toString();
    }
}
