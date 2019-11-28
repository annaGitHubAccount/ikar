package de.anna.springboot.controller.helper;

import de.anna.springboot.model.dto.ProduktDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ButtonNachLinksHelperVonProdukt {

    public List<ProduktDTO> loescheAusgewaehlteProdukteFromFormularAusProduktList(List<ProduktDTO> produktListFromSession,
                                                                                  List<String> produktAusgewaehlteListFromFormular) {

        return produktListFromSession.stream()
                .filter(produktDTO -> !produktAusgewaehlteListFromFormular.contains(produktDTO.getSymbol()))
                .collect(Collectors.toList());
    }


    public List<ProduktDTO> fuegeAusgewaehlteProduktListFromFormularToProduktStammdatenListHinzu(List<ProduktDTO> produktListFromSession,
                                                                                                 List<String> produktAusgewaehlteListFromFormular) {

        return produktListFromSession.stream()
                .filter(produktDTO -> produktAusgewaehlteListFromFormular.contains(produktDTO.getSymbol()))
                .collect(Collectors.toList());
    }
}
