package de.anna.springboot.controller.helper;

import de.anna.springboot.model.dto.RolleDTO;
import de.anna.springboot.model.entity.Rolle;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RolleDTOHelperTest {

    @Test
    public void shouldConvertStringArrayVonRollenToRolleDTOList() {

        String[] arrayVonString = new String[]{"PO", "Scrum Master", "Product Owner"};

        RolleDTO rolleDTO1 = new RolleDTO();
        rolleDTO1.setName("PO");
        RolleDTO rolleDTO2 = new RolleDTO();
        rolleDTO2.setName("Scrum Master");
        RolleDTO rolleDTO3 = new RolleDTO();
        rolleDTO3.setName("Product Owner");

        List<RolleDTO> rolleDTOListExpected = new ArrayList<>();
        rolleDTOListExpected.add(rolleDTO1);
        rolleDTOListExpected.add(rolleDTO2);
        rolleDTOListExpected.add(rolleDTO3);

        List<RolleDTO> rolleDTOList = RolleDTOHelper.convertStringArrayVonRollenToRolleDTOList(arrayVonString);

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
