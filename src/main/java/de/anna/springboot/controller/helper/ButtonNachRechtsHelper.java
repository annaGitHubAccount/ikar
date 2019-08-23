package de.anna.springboot.controller.helper;

import de.anna.springboot.model.dto.ProduktDTO;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ButtonNachRechtsHelper {

    public List<ProduktDTO> loescheAusgewaehlteProduktStammdatenAusProduktStammdatenList(List<ProduktDTO> produktStammdatenListFromSession, List<String> produktStammdatenGewaehlteListFromFormular) {

        List<ProduktDTO> newProduktStammdatenList = new ArrayList<>();

        for (ProduktDTO produktDTO : produktStammdatenListFromSession) {
            if (!produktStammdatenGewaehlteListFromFormular.contains(produktDTO.getSymbol())) {
                newProduktStammdatenList.add(produktDTO);
            }
        }
        return newProduktStammdatenList;
    }


    public List<ProduktDTO> fuegeAusgewaehlteProduktStammdatenToProduktListHinzu(List<ProduktDTO> produktStammdatenListFromSession, List<String> produktStammdatenGewaehlteListFromFormular) {

        List<ProduktDTO> newProduktList = new ArrayList<>();

        for (ProduktDTO produktDTO : produktStammdatenListFromSession) {
            if (produktStammdatenGewaehlteListFromFormular.contains(produktDTO.getSymbol())) {
                newProduktList.add(produktDTO);
            }
        }
        return newProduktList;
    }
}
