package de.anna.springboot.controller.helper;

import de.anna.springboot.model.dto.ProduktDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ButtonNachLinksHelper {

    public List<ProduktDTO> loescheAusgewaehlteProdukteFromFormularAusProduktList(List<ProduktDTO> produktListFromSession, List<String> produktAusgewaehlteListFromFormular) {

        List<ProduktDTO> newProduktList = new ArrayList<>();

        for (ProduktDTO produktDTOFromSession : produktListFromSession) {
            if (!produktAusgewaehlteListFromFormular.contains(produktDTOFromSession.getSymbol())) {
                newProduktList.add(produktDTOFromSession);
            }
        }

        return newProduktList;
    }


    public List<ProduktDTO> fuegeAusgewaehlteProduktListFromFormularToProduktStammdatenListHinzu(List<ProduktDTO> produktListFromSession, List<String> produktAusgewaehlteListFromFormular) {

        List<ProduktDTO> newProduktStammdatenList = new ArrayList<>();

        for (ProduktDTO produktDTOFromSession : produktListFromSession) {
            if (produktAusgewaehlteListFromFormular.contains(produktDTOFromSession.getSymbol())) {
                newProduktStammdatenList.add(produktDTOFromSession);
            }
        }

        return newProduktStammdatenList;
    }

}
