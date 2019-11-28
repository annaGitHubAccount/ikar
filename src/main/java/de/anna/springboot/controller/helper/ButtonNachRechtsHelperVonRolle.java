package de.anna.springboot.controller.helper;


import de.anna.springboot.model.dto.RolleDTO;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ButtonNachRechtsHelperVonRolle {

    public List<RolleDTO> loescheAusgewaehlteRolleStammdatenVonRolleStammdatenList(List<RolleDTO> rolleStammdatenListFromSession,
                                                                                       List<String> rolleStammdatenGewaehlteListFromFormular) {

        return rolleStammdatenListFromSession.stream()
                .filter(rolleDTO -> !rolleStammdatenGewaehlteListFromFormular.contains(rolleDTO.getName()))
                .collect(Collectors.toList());
    }


    public List<RolleDTO> fuegeAusgewaehlteRolleStammdatenToRolleListHinzu(List<RolleDTO> rolleStammdatenListFromSession,
                                                                                 List<String> rolleStammdatenGewaehlteListFromFormular) {

        return rolleStammdatenListFromSession.stream()
                .filter(rolleDTO -> rolleStammdatenGewaehlteListFromFormular.contains(rolleDTO.getName()))
                .collect(Collectors.toList());
    }
}
