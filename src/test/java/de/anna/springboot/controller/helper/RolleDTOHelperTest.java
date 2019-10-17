package de.anna.springboot.controller.helper;

import de.anna.springboot.model.entity.Rolle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RolleDTOHelperTest {

    @Test
    public void shouldConvertStringArrayVonRollenToRolleDTOList() {

        String[] arrayVonString = new String[]{"PO", "Scrum Master", "Product Owner"};

        de.anna.springboot.model.dto.RolleDTO rolleDTO1 = new de.anna.springboot.model.dto.RolleDTO();
        rolleDTO1.setName("PO");
        de.anna.springboot.model.dto.RolleDTO rolleDTO2 = new de.anna.springboot.model.dto.RolleDTO();
        rolleDTO2.setName("Scrum Master");
        de.anna.springboot.model.dto.RolleDTO rolleDTO3 = new de.anna.springboot.model.dto.RolleDTO();
        rolleDTO3.setName("Product Owner");

        List<de.anna.springboot.model.dto.RolleDTO> rolleDTOListExpected = new ArrayList<>();
        rolleDTOListExpected.add(rolleDTO1);
        rolleDTOListExpected.add(rolleDTO2);
        rolleDTOListExpected.add(rolleDTO3);

        List<de.anna.springboot.model.dto.RolleDTO> rolleDTOList = RolleDTOHelper.convertStringArrayVonRollenToRolleDTOList(arrayVonString);

        assertEquals(rolleDTOListExpected.size(), rolleDTOList.size());
        assertEquals(rolleDTOListExpected, rolleDTOList);
    }

    @Test
    public void shouldConvertRolleListToStringTest(){

        String stringVonRollenExpected = "PO, Scrum Master, Product Owner";

        Rolle rolle1= new Rolle();
        rolle1.setName("PO");
        Rolle rolle2 = new Rolle();
        rolle2.setName("Scrum Master");
        Rolle rolle3 = new Rolle();
        rolle3.setName("Product Owner");

        List<Rolle> rolleList = new ArrayList<>();
        rolleList.add(rolle1);
        rolleList.add(rolle2);
        rolleList.add(rolle3);

        String stringVonRollen = RolleDTOHelper.convertRolleListToString(rolleList);

        assertEquals(stringVonRollenExpected, stringVonRollen);
    }

    @Test
    public void shouldConvertLeerenRolleListToLeerenStringTest(){

        String stringVonRollenExpected = "";

        Rolle rolle1= new Rolle();
        rolle1.setName("");

        List<Rolle> rolleList = new ArrayList<>();
        rolleList.add(rolle1);

        String stringVonRollen = RolleDTOHelper.convertRolleListToString(rolleList);

        assertEquals(stringVonRollenExpected, stringVonRollen);
    }
}
