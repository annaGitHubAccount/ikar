package de.anna.springboot.webservice;

import de.anna.springboot.model.dto.ProduktStammdatenDTO;

import java.util.List;

public class ProduktStammdatenListResponse {

    public ProduktStammdatenListResponse() {
    }

    private List<ProduktStammdatenDTO> produktStammdatenDTOList;

    public ProduktStammdatenListResponse(List<ProduktStammdatenDTO> produktStammdatenDTOList) {
        this.produktStammdatenDTOList = produktStammdatenDTOList;
    }

    public List<ProduktStammdatenDTO> getProduktStammdatenDTOList() {
        return produktStammdatenDTOList;
    }

    public void setProduktStammdatenDTOList(List<ProduktStammdatenDTO> produktStammdatenDTOList) {
        this.produktStammdatenDTOList = produktStammdatenDTOList;
    }
}
