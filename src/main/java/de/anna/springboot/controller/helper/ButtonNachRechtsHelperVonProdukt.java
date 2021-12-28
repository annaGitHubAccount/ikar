package de.anna.springboot.controller.helper;

import de.anna.springboot.model.dto.ProduktDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ButtonNachRechtsHelperVonProdukt {

    public List<ProduktDTO> loescheAusgewaehlteProduktStammdatenVonProduktStammdatenList(List<ProduktDTO> produktStammdatenListFromSession,
                                                                                         List<String> produktStammdatenGewaehlteListFromFormular) {

        return produktStammdatenListFromSession.stream()
                .filter(produktDTO -> !produktStammdatenGewaehlteListFromFormular.contains(produktDTO.getSymbol()))
                .collect(Collectors.toList());
    }


    public List<ProduktDTO> fuegeAusgewaehlteProduktStammdatenToProduktListHinzu(List<ProduktDTO> produktStammdatenListFromSession,
                                                                                 List<String> produktStammdatenGewaehlteListFromFormular) {

        return produktStammdatenListFromSession.stream()
                .filter(produktDTO -> produktStammdatenGewaehlteListFromFormular.contains(produktDTO.getSymbol()))
                .collect(Collectors.toList());
    }
}
