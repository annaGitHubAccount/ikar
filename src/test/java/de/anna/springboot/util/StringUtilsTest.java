package de.anna.springboot.util;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StringUtilsTest {

    @Test
    public void shouldConvertRollenAlsStringToStringArrayTest(){

        String rollen = "PO, Scrum Master, Product Owner";

        String[] stringArray = StringUtils.convertStringToStringArray(rollen);

        assertEquals(3, stringArray.length);
        assertEquals("PO", stringArray[0]);
        assertEquals("Scrum Master", stringArray[1]);
        assertEquals("Product Owner", stringArray[2]);
    }

    @Test
    public void shouldConvertRollenAlsNullToStringArrayTest() {

        String rollen = null;

        String[] stringArray = StringUtils.convertStringToStringArray(rollen);

        assertNull(stringArray);
    }

    @Test
    public void shouldConvertRollenAlsLeereszeichenToStringArrayTest() {

        String rollen = "";

        String[] strings = StringUtils.convertStringToStringArray(rollen);

        assertEquals("", strings[0]);
    }

    @Test
    public void shouldConvertRollenMitKommasNacheinander(){

        String rollen = "PO,, ";

        String[] stringArray = StringUtils.convertStringToStringArray(rollen);

        assertEquals(3, stringArray.length);
        assertEquals("PO", stringArray[0]);
        assertEquals("", stringArray[1]);
        assertEquals("", stringArray[2]);
    }

}
