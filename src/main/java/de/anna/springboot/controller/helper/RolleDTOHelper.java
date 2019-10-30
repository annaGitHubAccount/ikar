package de.anna.springboot.controller.helper;

import de.anna.springboot.model.dto.RolleDTO;
import de.anna.springboot.model.entity.Rolle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RolleDTOHelper {

    private static final String ROLLEN_SEPARATOR = ", ";

    //TODO
    public static List<RolleDTO> convertStringArrayVonRollenToRolleDTOList(String[] rollenArrayAsString) {

        /*
         List<String> rollenListAsString = Arrays.asList(rollenArrayAsString);
        RolleDTO rolleDTO = new RolleDTO();

        return rollenListAsString.stream()
                .map(rolleAsString -> rolleDTO.setName(rolleAsString))
                .collect(Collectors.toList());
         */

        List<RolleDTO> rolleDTOList = new ArrayList<>();

        for (String rolleAsString : rollenArrayAsString) {

            RolleDTO rolleDTO = new RolleDTO();
            rolleDTO.setName(rolleAsString);
            rolleDTOList.add(rolleDTO);
        }

        return rolleDTOList;
    }

    public static String convertRolleDTOListToString(List<RolleDTO> rolleDTOList) {

        List<String> rollenDTOListNachName = rolleDTOList.stream()
                .map(rolleDTO -> rolleDTO.getName())
                .collect(Collectors.toList());

        String rollenStringNachName = String.join(ROLLEN_SEPARATOR, rollenDTOListNachName);

        return rollenStringNachName;
    }


    public static String convertRolleListToString(List<Rolle> rolleList) {

        List<String> rolleListNachName = rolleList.stream()
                .map(rolle -> rolle.getName())
                .collect(Collectors.toList());

        String rollenStringNachName = String.join(ROLLEN_SEPARATOR, rolleListNachName);

        return rollenStringNachName;
    }
}
