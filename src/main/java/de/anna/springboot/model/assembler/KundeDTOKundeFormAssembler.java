package de.anna.springboot.model.assembler;

import de.anna.springboot.model.dto.AdresseDTO;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.ProduktDTO;
import de.anna.springboot.model.enums.AdresseArt;
import de.anna.springboot.model.enums.KundeArt;
import de.anna.springboot.model.form.KundeForm;
import de.anna.springboot.util.DateUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class KundeDTOKundeFormAssembler {

    private KundeDTOKundeFormAssembler() {
    }


    public static KundeDTO mapKundeFormToKundeDTO(KundeForm kundeForm) {

        KundeDTO kundeDTO = new KundeDTO();

        kundeDTO.setId(kundeForm.getId());
        kundeDTO.setSteuerId(kundeForm.getSteuerId());
        kundeDTO.setName(kundeForm.getName());
        kundeDTO.setNachname(kundeForm.getNachname());

        LocalDate localDate = DateUtils.stringToLocalDate(kundeForm.getBirthDate());
        kundeDTO.setBirthDate(localDate);

        String kundeArtByText = kundeForm.getKundeArt();

        KundeArt kundeArt = KundeArt.convertToKundeArtByText(kundeArtByText);
        kundeDTO.setKundeArt(kundeArt);

        List<AdresseDTO> adresseDTOList = convertKundeFormAdresseToKundeDTOAdresse(kundeForm);
        kundeDTO.setAdresseList(adresseDTOList);

        kundeDTO.setProduktDTOList(kundeForm.getProduktList());

        List<ProduktDTO> produktListFromForm = kundeForm.getProduktList();
        for(ProduktDTO produktDTO : produktListFromForm){
            produktDTO.setKundeDTO(kundeDTO);
        }

        return kundeDTO;
    }

    private static List<AdresseDTO> convertKundeFormAdresseToKundeDTOAdresse(KundeForm kundeForm) {

        List<AdresseDTO> adresseDTOList = new ArrayList<>();

        AdresseDTO adresseVonMeldeanschrift = new AdresseDTO();
        adresseVonMeldeanschrift.setLand(kundeForm.getLandVonMeldeanschrift());
        adresseVonMeldeanschrift.setOrt(kundeForm.getOrtVonMeldeanschrift());
        adresseVonMeldeanschrift.setStrasse(kundeForm.getStrasseVonMeldeanschrift());
        adresseVonMeldeanschrift.setHausNr(kundeForm.getHausNrVonMeldeanschrift());
        adresseVonMeldeanschrift.setAdresseArt(AdresseArt.MELDEANSCHRIFT);
        adresseDTOList.add(adresseVonMeldeanschrift);

        if(kundeForm.getLandVonPostanschrift() != null && !kundeForm.getLandVonPostanschrift().equals("")) {
            AdresseDTO adresseVonPostanschrift = new AdresseDTO();
            adresseVonPostanschrift.setLand(kundeForm.getLandVonPostanschrift());
            adresseVonPostanschrift.setOrt(kundeForm.getOrtVonPostanschrift());
            adresseVonPostanschrift.setStrasse(kundeForm.getStrasseVonPostanschrift());
            adresseVonPostanschrift.setHausNr(kundeForm.getHausNrVonPostanschrift());
            adresseVonPostanschrift.setAdresseArt(AdresseArt.POSTANSCHRIFT);
            adresseDTOList.add(adresseVonPostanschrift);
        }

        return adresseDTOList;
    }

    public static KundeForm mapKundeDTOToKundeForm(KundeDTO kundeDTO) {

        KundeForm kundeForm = new KundeForm();

        kundeForm.setId(kundeDTO.getId());
        kundeForm.setSteuerId(kundeDTO.getSteuerId());
        kundeForm.setName(kundeDTO.getName());
        kundeForm.setNachname(kundeDTO.getNachname());

        String dateToString = DateUtils.localDateToString(kundeDTO.getBirthDate());
        kundeForm.setBirthDate(dateToString);

        kundeForm.setKundeArt(kundeDTO.getKundeArt().toString());

        kundeForm = convertKundeDTOAdresseToKundeFormAdresse(kundeDTO, kundeForm);

        kundeForm.setProduktList(kundeDTO.getProduktDTOList());

        return kundeForm;
    }

    private static KundeForm convertKundeDTOAdresseToKundeFormAdresse(KundeDTO kundeDTO, KundeForm kundeForm) {

        List<AdresseDTO> adresseListDTO = kundeDTO.getAdresseList();

        for (AdresseDTO adresseDTO : adresseListDTO) {

            if (adresseDTO.getAdresseArt().getKode().equals("MA")) {
                kundeForm.setLandVonMeldeanschrift(adresseDTO.getLand());
                kundeForm.setOrtVonMeldeanschrift(adresseDTO.getOrt());
                kundeForm.setStrasseVonMeldeanschrift(adresseDTO.getStrasse());
                kundeForm.setHausNrVonMeldeanschrift(adresseDTO.getHausNr());
            }

            if (adresseDTO.getAdresseArt().getKode().equals("PA")) {
                kundeForm.setLandVonPostanschrift(adresseDTO.getLand());
                kundeForm.setOrtVonPostanschrift(adresseDTO.getLand());
                kundeForm.setStrasseVonPostanschrift(adresseDTO.getStrasse());
                kundeForm.setHausNrVonPostanschrift(adresseDTO.getHausNr());
            }
        }

        return kundeForm;
    }


}
