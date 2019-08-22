package de.anna.springboot.model.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ProduktArtConverter  implements AttributeConverter<ProduktArt, String> {

    @Override
    public String convertToDatabaseColumn(ProduktArt produktArt) {

        if(produktArt == null){
            return null;
        }

        return produktArt.getKode();
    }

    @Override
    public ProduktArt convertToEntityAttribute(String produktArtByKode) {

        if(produktArtByKode == null){
            return null;
        }

        return ProduktArt.convertStringToProduktArt(produktArtByKode);
    }
}
