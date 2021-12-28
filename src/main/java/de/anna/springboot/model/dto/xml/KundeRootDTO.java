package de.anna.springboot.model.dto.xml;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class KundeRootDTO {

    private List<KundeZeileDTO> kundeZeileDTOList;



    public List<KundeZeileDTO> getKundeZeileDTOList() {
        return kundeZeileDTOList;
    }

    public void setKundeZeileDTOList(List<KundeZeileDTO> kundeZeileDTOList) {
        this.kundeZeileDTOList = kundeZeileDTOList;
    }
}
