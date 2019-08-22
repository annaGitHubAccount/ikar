package de.anna.springboot.model.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

// https://www.baeldung.com/jpa-persisting-enums-in-jpa
// dient zu Kommunikation für JPA zwischen Entity und Datenbank

@Converter(autoApply = true)
public class KundeArtConverter implements AttributeConverter<KundeArt, String> {

    @Override
    public String convertToDatabaseColumn(KundeArt kundeArt) {

        if(kundeArt == null) {
            return null;
        }

        return kundeArt.getKode();
    }

    @Override
    public KundeArt convertToEntityAttribute(String kundeArtByKode) {

        if (kundeArtByKode == null){
            return null;
        }

        return KundeArt.convertToKundeArtByCode(kundeArtByKode);
    }
}
