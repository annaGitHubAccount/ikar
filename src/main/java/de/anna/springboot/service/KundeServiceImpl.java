package de.anna.springboot.service;

import de.anna.springboot.model.assembler.KundeKundeDTOAssembler;
import de.anna.springboot.model.assembler.KundeKundeZeileDTOAssembler;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.xml.KundeZeileDTO;
import de.anna.springboot.model.entity.Adresse;
import de.anna.springboot.model.entity.Kunde;
import de.anna.springboot.model.entity.Produkt;
import de.anna.springboot.model.entity.Rolle;
import de.anna.springboot.repository.AdresseRepository;
import de.anna.springboot.repository.KundeRepository;
import de.anna.springboot.repository.KundeSucheRepository;
import de.anna.springboot.repository.ProduktRepository;
import de.anna.springboot.repository.RolleRepository;
import de.anna.springboot.util.KundeNummerUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KundeServiceImpl implements KundeService {

    private final KundeRepository kundeRepository;

    private final ProduktRepository produktRepository;

    private final KundeSucheRepository kundeSucheRepository;

    private final RolleRepository rolleRepository;

    private final AdresseRepository adresseRepository;


    public KundeServiceImpl(KundeRepository kundeRepository, ProduktRepository produktRepository,
                            KundeSucheRepository kundeSucheRepository, RolleRepository rolleRepository, AdresseRepository adresseRepository) {
        this.kundeRepository = kundeRepository;
        this.produktRepository = produktRepository;
        this.kundeSucheRepository = kundeSucheRepository;
        this.rolleRepository = rolleRepository;
        this.adresseRepository = adresseRepository;
    }


    @Override
    @Transactional
    public void save(KundeDTO kundeDTO) {

        if (kundeDTO.getId() == null) {

            Kunde kunde = KundeKundeDTOAssembler.mapKundeDTOToKunde(kundeDTO, new Kunde());
            Long kundeNummerSequence = kundeRepository.getKundeNummerSequence();
            String kundeNummerAlsString = KundeNummerUtils.generateKundeNummerAlsString(kundeNummerSequence);
            kunde.setKundeNummer(kundeNummerAlsString);
            kundeRepository.save(kunde);

        } else {

            Optional<Kunde> kundeRepositoryById = kundeRepository.findById(kundeDTO.getId());

            if (kundeRepositoryById.isPresent()) {
                Kunde kundeFromDatenbank = kundeRepositoryById.get();

                clearKundeProduktList(kundeFromDatenbank);
                clearKundeRollenList(kundeFromDatenbank);
                clearKundeAddresseList(kundeFromDatenbank);

                Kunde kunde = KundeKundeDTOAssembler.mapKundeDTOToKunde(kundeDTO, kundeFromDatenbank);

                kundeRepository.save(kunde);
            }
        }


    }

    private void clearKundeAddresseList(Kunde kundeFromDatenbank) {

        List<Adresse> adresseList = kundeFromDatenbank.getAdresseList();
        adresseRepository.deleteAll(adresseList);
        adresseList.clear();
    }

    private void clearKundeProduktList(Kunde kundeFromDatenbank) {

        List<Produkt> produktList = kundeFromDatenbank.getProduktList();
        produktRepository.deleteAll(produktList);
        produktList.clear();
    }

    private void clearKundeRollenList(Kunde kundeFromDatenbank) {

        List<Rolle> rolleList = kundeFromDatenbank.getRolleList();
        rolleRepository.deleteAll(rolleList);
        rolleList.clear();
    }


    @Override
    public List<KundeDTO> findAll() {

        ArrayList<Kunde> kundeList = (ArrayList<Kunde>) kundeRepository.findAll();

        return kundeList.stream()
                .map(KundeKundeDTOAssembler::mapKundeToKundeDTO)
                .toList();
    }

    @Override
    public List<KundeZeileDTO> findAllKundeZeileDTO() {

        ArrayList<Kunde> kundeList = (ArrayList<Kunde>) kundeRepository.findAll();

        return kundeList.stream()
                .map(KundeKundeZeileDTOAssembler::mapKundeToKundeZeileDTO)
                .toList();
    }

    @Override
    public List<KundeZeileDTO> findAllKundeZeileDTOByNachname(String nachname) {

        ArrayList<Kunde> kundeList = (ArrayList<Kunde>) kundeRepository.findKundeByNachname(nachname);

        return kundeList.stream()
                .map(KundeKundeZeileDTOAssembler::mapKundeToKundeZeileDTO)
                .toList();
    }


    @Override
    @Transactional
    public KundeDTO findKundeById(Long id) {

        Optional<Kunde> kundeByID = kundeRepository.findById(id);

        KundeDTO kundeDTO = new KundeDTO();
        if (kundeByID.isPresent()) {
            kundeDTO = KundeKundeDTOAssembler.mapKundeToKundeDTO(kundeByID.get());
        }

        return kundeDTO;
    }

    @Override
    @Transactional
    public void deleteKundeById(Long id) {

        Optional<Kunde> kundeById = kundeRepository.findById(id);

        kundeById.ifPresent(kundeRepository::delete);
    }

    @Override
    public List<KundeDTO> findKundenByNachname(String nachname) {

        List<Kunde> kundenByNachname = kundeRepository.findKundeByNachname(nachname);

        return kundenByNachname.stream()
                .map(KundeKundeDTOAssembler::mapKundeToKundeDTO)
                .toList();
    }

    @Override
    public List<KundeZeileDTO> findeKunden(String kundeNummer, String steuerId, String nachname, String kundeArt, LocalDate geburtsdatumAB, LocalDate geburtsdatumBIS) {

        List<Kunde> kundeList = kundeSucheRepository.findKunden(kundeNummer, steuerId, nachname, kundeArt, geburtsdatumAB, geburtsdatumBIS);

        return kundeList.stream()
                .map(KundeKundeZeileDTOAssembler::mapKundeToKundeZeileDTO)
                .toList();
    }


}
