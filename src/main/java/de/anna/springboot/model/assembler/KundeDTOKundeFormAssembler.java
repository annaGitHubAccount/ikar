package de.anna.springboot.model.assembler;

import de.anna.springboot.controller.helper.RolleDTOHelper;
import de.anna.springboot.model.dto.AdresseDTO;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.ProduktDTO;
import de.anna.springboot.model.dto.RolleDTO;
import de.anna.springboot.model.enums.AdresseArt;
import de.anna.springboot.model.enums.KundeArt;
import de.anna.springboot.model.form.KundeForm;
import de.anna.springboot.util.DateUtils;
import de.anna.springboot.util.StringUtils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class KundeDTOKundeFormAssembler {

    private KundeDTOKundeFormAssembler() {
    }


    public static KundeDTO mapKundeFormToKundeDTO(KundeForm kundeForm, List<ProduktDTO> produktListDTOFromKundeForm) {

        KundeDTO kundeDTO = new KundeDTO();

        kundeDTO.setId(kundeForm.getId());
        kundeDTO.setSteuerId(kundeForm.getSteuerId());
        kundeDTO.setName(kundeForm.getName());
        kundeDTO.setNachname(kundeForm.getNachname());
        kundeDTO.setKundeNummer(kundeForm.getKundeNummer());

        LocalDate localDate = DateUtils.stringToLocalDate(kundeForm.getBirthDate());
        kundeDTO.setBirthDate(localDate);

        String kundeArtByText = kundeForm.getKundeArt();

        KundeArt kundeArt = KundeArt.convertToKundeArtByText(kundeArtByText);
        kundeDTO.setKundeArt(kundeArt);

        List<AdresseDTO> adresseDTOList = convertKundeFormAdresseToKundeDTOAdresse(kundeForm);
        kundeDTO.setAdresseList(adresseDTOList);

        kundeDTO.setProduktDTOList(produktListDTOFromKundeForm);

        produktListDTOFromKundeForm.forEach(produktDTO -> produktDTO.setKundeDTO(kundeDTO));

        String rolle = kundeForm.getRolle();
        List<RolleDTO> rolleDTOList = convertStringVonRollenToRolleDTOList(rolle);
        kundeDTO.setRolleDTOList(rolleDTOList);

        return kundeDTO;
    }

    private static List<AdresseDTO> convertKundeFormAdresseToKundeDTOAdresse(KundeForm kundeForm) {

        List<AdresseDTO> adresseDTOList = new ArrayList<>();

        AdresseDTO adresseVonMeldeanschrift = new AdresseDTO();
        adresseVonMeldeanschrift.setLand(kundeForm.getLandVonMeldeanschrift());
        adresseVonMeldeanschrift.setBundesland(kundeForm.getBundeslandVonMeldeanschrift());
        adresseVonMeldeanschrift.setOrt(kundeForm.getOrtVonMeldeanschrift());
        adresseVonMeldeanschrift.setPostleitzahl(kundeForm.getPostleitzahlVonMeldeanschrift());
        adresseVonMeldeanschrift.setStrasse(kundeForm.getStrasseVonMeldeanschrift());
        adresseVonMeldeanschrift.setHausNr(kundeForm.getHausNrVonMeldeanschrift());
        adresseVonMeldeanschrift.setAdresseArt(AdresseArt.MELDEANSCHRIFT);
        adresseDTOList.add(adresseVonMeldeanschrift);

        if(kundeForm.getLandVonPostanschrift() != null && !kundeForm.getLandVonPostanschrift().equals("")) {
            AdresseDTO adresseVonPostanschrift = new AdresseDTO();
            adresseVonPostanschrift.setLand(kundeForm.getLandVonPostanschrift());
            adresseVonPostanschrift.setBundesland(kundeForm.getBundeslandVonPostanschrift());
            adresseVonPostanschrift.setOrt(kundeForm.getOrtVonPostanschrift());
            adresseVonPostanschrift.setPostleitzahl(kundeForm.getPostleitzahlVonPostanschrift());
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
        kundeForm.setKundeNummer(kundeDTO.getKundeNummer());

        String dateToString = DateUtils.localDateToString(kundeDTO.getBirthDate());
        kundeForm.setBirthDate(dateToString);

        kundeForm.setKundeArt(kundeDTO.getKundeArt().getText());

        convertKundeDTOAdresseToKundeFormAdresse(kundeDTO, kundeForm);

        List<ProduktDTO> produktDTOList = kundeDTO.getProduktDTOList();
        List<String> produktListAlsName = produktDTOList.stream().map(ProduktDTO::getName).toList();
        kundeForm.setProduktList(produktListAlsName);

        List<RolleDTO> rolleDTOList = kundeDTO.getRolleDTOList();
        String rolle = RolleDTOHelper.convertRolleDTOListToString(rolleDTOList);
        kundeForm.setRolle(rolle);

        return kundeForm;
    }

    private static void convertKundeDTOAdresseToKundeFormAdresse(KundeDTO kundeDTO, KundeForm kundeForm) {

        List<AdresseDTO> adresseListDTO = kundeDTO.getAdresseList();

        for (AdresseDTO adresseDTO : adresseListDTO) {

            if (adresseDTO.getAdresseArt().getKode().equals("MA")) {
                kundeForm.setLandVonMeldeanschrift(adresseDTO.getLand());
                kundeForm.setBundeslandVonMeldeanschrift(adresseDTO.getBundesland());
                kundeForm.setOrtVonMeldeanschrift(adresseDTO.getOrt());
                kundeForm.setPostleitzahlVonMeldeanschrift(adresseDTO.getPostleitzahl());
                kundeForm.setStrasseVonMeldeanschrift(adresseDTO.getStrasse());
                kundeForm.setHausNrVonMeldeanschrift(adresseDTO.getHausNr());
            }

            if (adresseDTO.getAdresseArt().getKode().equals("PA")) {
                kundeForm.setLandVonPostanschrift(adresseDTO.getLand());
                kundeForm.setBundeslandVonPostanschrift(adresseDTO.getBundesland());
                kundeForm.setOrtVonPostanschrift(adresseDTO.getOrt());
                kundeForm.setPostleitzahlVonPostanschrift(adresseDTO.getPostleitzahl());
                kundeForm.setStrasseVonPostanschrift(adresseDTO.getStrasse());
                kundeForm.setHausNrVonPostanschrift(adresseDTO.getHausNr());
            }
        }
    }

    private static List<RolleDTO> convertStringVonRollenToRolleDTOList(String string){

        String[] arrayVonRollen = StringUtils.convertStringToStringArray(string);

        List<RolleDTO> rolleDTOList = RolleDTOHelper.convertStringArrayVonRollenToRolleDTOList(arrayVonRollen);

        return rolleDTOList;
    }

}
