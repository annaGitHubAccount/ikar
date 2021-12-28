package de.anna.springboot.webantwort;

import de.anna.springboot.model.dto.KundeDTO;

import java.util.ArrayList;
import java.util.List;

public class KundeListServiceAntwort extends KundeServiceAntwort {

    private List<KundeDTO> kundeDTOList = new ArrayList<>();


    public KundeListServiceAntwort(List<KundeDTO> kundeDTOList, boolean isOk, String error) {

        super(isOk, error);
        this.kundeDTOList = kundeDTOList;
    }


    public List<KundeDTO> getKundeDTOList() {
        return kundeDTOList;
    }

    public void setKundeDTOList(List<KundeDTO> kundeDTOList) {
        this.kundeDTOList = kundeDTOList;
    }
}


