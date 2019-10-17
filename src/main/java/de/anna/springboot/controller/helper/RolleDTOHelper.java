package de.anna.springboot.controller.helper;

import de.anna.springboot.model.entity.Rolle;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class RolleDTOHelper {

    private static final String ROLLEN_SEPARATOR = ", ";
    private static final int ROLLEN_SEPARATOR_LENGTH = ROLLEN_SEPARATOR.length();


    public static List<de.anna.springboot.model.dto.RolleDTO> convertStringArrayVonRollenToRolleDTOList(String[] arrayVonString){

        List<de.anna.springboot.model.dto.RolleDTO> rolleDTOList = new ArrayList<>();

        for(String rolleAsString : arrayVonString){

            de.anna.springboot.model.dto.RolleDTO rolleDTO = new de.anna.springboot.model.dto.RolleDTO();
            rolleDTO.setName(rolleAsString);
            rolleDTOList.add(rolleDTO);
        }

        return rolleDTOList;
    }

    public static String convertRolleDTOListToString(List<de.anna.springboot.model.dto.RolleDTO> rolleDTOList) {

        StringBuilder stringBuilder = new StringBuilder();

        for(de.anna.springboot.model.dto.RolleDTO rolleDTO : rolleDTOList){
            stringBuilder.append(rolleDTO.getName()).append(ROLLEN_SEPARATOR);
        }
        String stringOhneKommaAmEnde = stringBuilder.substring(0, stringBuilder.length() - ROLLEN_SEPARATOR_LENGTH);

        return stringOhneKommaAmEnde;
    }


    public static String convertRolleListToString(List<Rolle> rolleList) {

        StringBuilder stringBuilder = new StringBuilder();

        for (Rolle rolle : rolleList) {
            stringBuilder.append(rolle.getName()).append(ROLLEN_SEPARATOR);
        }
        String stringOhneKommaAmEnde = stringBuilder.substring(0, stringBuilder.length() - ROLLEN_SEPARATOR_LENGTH);

        return stringOhneKommaAmEnde;
    }
}
