package de.anna.springboot.model.assembler;

import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.ProduktDTO;
import de.anna.springboot.model.entity.Kunde;
import de.anna.springboot.model.entity.Produkt;

public final class ProduktProduktDTOAssembler {

    private ProduktProduktDTOAssembler() {
    }


    public static ProduktDTO mapProduktToProduktDTO(Produkt produkt, KundeDTO kundeDTO) {

        ProduktDTO produktDTO = new ProduktDTO();

        produktDTO.setId(produkt.getId());
        produktDTO.setAktiv(produkt.isAktiv());
        produktDTO.setKundeDTO(kundeDTO);
        produktDTO.setName(produkt.getName());
        produktDTO.setPreis(produkt.getPreis());
        produktDTO.setProduktArt(produkt.getProduktArt());
        produktDTO.setSymbol(produkt.getSymbol());

        return produktDTO;
    }



    public static Produkt mapProduktDTOToProdukt(ProduktDTO produktDTO, Kunde kunde) {

        Produkt produkt = new Produkt();

        produkt.setId(produktDTO.getId());
        produkt.setAktiv(produktDTO.isAktiv());
        produkt.setKunde(kunde);
        produkt.setName(produktDTO.getName());
        produkt.setPreis(produktDTO.getPreis());
        produkt.setProduktArt(produktDTO.getProduktArt());
        produkt.setSymbol(produktDTO.getSymbol());

        return produkt;
    }
}
