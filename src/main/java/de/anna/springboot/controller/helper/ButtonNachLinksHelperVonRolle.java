package de.anna.springboot.controller.helper;

import de.anna.springboot.model.dto.RolleDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ButtonNachLinksHelperVonRolle {

    public List<RolleDTO> loescheAusgewaehlteRollenFromFormularAusRolleList(List<RolleDTO> rolleListFromSession,
                                                                                List<String> rolleAusgewaehlteListFromFormular) {

        return rolleListFromSession.stream()
                .filter(rolleDTO -> !rolleAusgewaehlteListFromFormular.contains(rolleDTO.getName()))
                .collect(Collectors.toList());
    }


    public List<RolleDTO> fuegeAusgewaehlteRolleListFromFormularToRolleStammdatenListHinzu(List<RolleDTO> rolleListFromSession,
                                                                                                 List<String> rolleAusgewaehlteListFromFormular) {

        return rolleListFromSession.stream()
                .filter(rolleDTO -> rolleAusgewaehlteListFromFormular.contains(rolleDTO.getName()))
                .collect(Collectors.toList());
    }
}
