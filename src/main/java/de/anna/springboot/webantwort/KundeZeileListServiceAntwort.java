package de.anna.springboot.webantwort;

import de.anna.springboot.model.dto.xml.KundeZeileDTO;

import java.util.ArrayList;
import java.util.List;

public class KundeZeileListServiceAntwort extends KundeZeileServiceAntwort {


    private List<KundeZeileDTO> kundeZeileDTOList = new ArrayList<>();

    public KundeZeileListServiceAntwort(List<KundeZeileDTO> allKundeZeileDTO, boolean isOk, String error) {

        super(isOk, error);
        this.kundeZeileDTOList = allKundeZeileDTO;
    }



    public KundeZeileListServiceAntwort(boolean isOk, String error) {
        super(isOk, error);
    }

    public List<KundeZeileDTO> getKundeZeileDTOList() {
        return kundeZeileDTOList;
    }

    public void setKundeZeileDTOList(List<KundeZeileDTO> kundeZeileDTOList) {
        this.kundeZeileDTOList = kundeZeileDTOList;
    }
}
