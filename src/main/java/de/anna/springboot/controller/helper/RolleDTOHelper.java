package de.anna.springboot.controller.helper;

import de.anna.springboot.model.dto.RolleDTO;
import de.anna.springboot.model.entity.Rolle;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RolleDTOHelper {

    private static final String ROLLEN_SEPARATOR = ", ";


    public static List<RolleDTO> convertStringArrayVonRollenToRolleDTOList(String[] rolleArray) {


        List<String> rollenNameList = Arrays.asList(rolleArray);

        return rollenNameList.stream()
                .map(RolleDTOHelper::convertRolleNameToRolleDTO)
                .collect(Collectors.toList());
    }

    private static RolleDTO convertRolleNameToRolleDTO(String rolleName){

        RolleDTO rolleDTO = new RolleDTO();
        rolleDTO.setName(rolleName);
        return rolleDTO;
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
