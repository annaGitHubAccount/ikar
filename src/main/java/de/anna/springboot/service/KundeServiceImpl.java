package de.anna.springboot.service;

import de.anna.springboot.model.assembler.KundeKundeDTOAssembler;
import de.anna.springboot.model.assembler.KundeKundeZeileDTOAssembler;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.xml.KundeZeileDTO;
import de.anna.springboot.model.entity.Kunde;
import de.anna.springboot.model.entity.Produkt;
import de.anna.springboot.model.entity.Rolle;
import de.anna.springboot.repository.KundeRepository;
import de.anna.springboot.repository.KundeSucheRepository;
import de.anna.springboot.repository.ProduktRepository;
import de.anna.springboot.repository.RolleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KundeServiceImpl implements KundeService {

    private final KundeRepository kundeRepository;

    @Autowired
    private ProduktRepository produktRepository;

    @Autowired
    private KundeSucheRepository kundeSucheRepository;

    @Autowired
    private RolleRepository rolleRepository;


    public KundeServiceImpl(KundeRepository kundeRepository) {
        this.kundeRepository = kundeRepository;
    }


    @Override
    @Transactional
    public void save(KundeDTO kundeDTO) {

        if (kundeDTO.getId() == null) {

            Kunde kunde = KundeKundeDTOAssembler.mapKundeDTOToKunde(kundeDTO, new Kunde());
            kundeRepository.save(kunde);

        } else {

            Optional<Kunde> kundeRepositoryById = kundeRepository.findById(kundeDTO.getId());

            if (kundeRepositoryById.isPresent()) {
                Kunde kundeFromDatenbank = kundeRepositoryById.get();

                clearKundeProduktList(kundeFromDatenbank);
                clearKundeRollenList(kundeFromDatenbank);

                Kunde kunde = KundeKundeDTOAssembler.mapKundeDTOToKunde(kundeDTO, kundeFromDatenbank);

                kundeRepository.save(kunde);
            }
        }


    }

    private void clearKundeProduktList(Kunde kundeFromDatenbank) {

        List<Produkt> produktList = kundeFromDatenbank.getProduktList();

        for (Produkt produkt : produktList) {
            produktRepository.delete(produkt);
        }
        produktList.clear();
    }

    private void clearKundeRollenList(Kunde kundeFromDatenbank){

        List<Rolle> rolleList = kundeFromDatenbank.getRolleList();

        for(Rolle rolle : rolleList){
            rolleRepository.delete(rolle);
        }
        rolleList.clear();
    }


    @Override
    public List<KundeDTO> findAll() {

        List<KundeDTO> kundeDTOList = new ArrayList<>();

        ArrayList<Kunde> kundeList = (ArrayList<Kunde>) kundeRepository.findAll();

        for (Kunde kunde : kundeList) {
            KundeDTO kundeDTO = KundeKundeDTOAssembler.mapKundeToKundeDTO(kunde);
            kundeDTOList.add(kundeDTO);
        }

        return kundeDTOList;
    }

    @Override
    public List<KundeZeileDTO> findAllKundeZeileDTO() {

        List<KundeZeileDTO> kundeZeileDTOList = new ArrayList<>();

        ArrayList<Kunde> kundeList = (ArrayList<Kunde>) kundeRepository.findAll();

        for (Kunde kunde : kundeList) {
            KundeZeileDTO kundeZeileDTO = KundeKundeZeileDTOAssembler.mapKundeToKundeZeileDTO(kunde);
            kundeZeileDTOList.add(kundeZeileDTO);
        }

        return kundeZeileDTOList;
    }

    @Override
    public List<KundeZeileDTO> findAllKundeZeileDTOByNachname(String nachname) {

        List<KundeZeileDTO> kundeZeileDTOList = new ArrayList<>();

        ArrayList<Kunde> kundeList = (ArrayList<Kunde>) kundeRepository.findKundeByNachname(nachname);

        for (Kunde kunde : kundeList) {

            KundeZeileDTO kundeZeileDTO = KundeKundeZeileDTOAssembler.mapKundeToKundeZeileDTO(kunde);
            kundeZeileDTOList.add(kundeZeileDTO);
        }

        return kundeZeileDTOList;
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

        if (kundeById.isPresent()) {
            kundeRepository.delete(kundeById.get());
        }
    }

    @Override
    public List<KundeDTO> findKundenByNachname(String nachname) {

        List<KundeDTO> kundeDTOList = new ArrayList<>();
        List<Kunde> kundenByNachname = kundeRepository.findKundeByNachname(nachname);

        for (Kunde kunde : kundenByNachname) {
            KundeDTO kundeDTO = KundeKundeDTOAssembler.mapKundeToKundeDTO(kunde);
            kundeDTOList.add(kundeDTO);
        }

        return kundeDTOList;
    }

    @Override
    public List<KundeZeileDTO> findeKunden(Long kundeNummer, String steuerId, String nachname, String kundeArt, LocalDate geburtsdatumAB, LocalDate geburtsdatumBIS) {

        List<KundeZeileDTO> kundeZeileDTOList = new ArrayList<>();

        List<Kunde> kundeList = kundeSucheRepository.findKunden(kundeNummer, steuerId, nachname, kundeArt, geburtsdatumAB, geburtsdatumBIS);

        for (Kunde kunde : kundeList) {
            KundeZeileDTO kundeZeileDTO = KundeKundeZeileDTOAssembler.mapKundeToKundeZeileDTO(kunde);
            kundeZeileDTOList.add(kundeZeileDTO);
        }

        return kundeZeileDTOList;
    }


}
