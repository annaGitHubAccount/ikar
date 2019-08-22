package de.anna.springboot.service;

import de.anna.springboot.model.assembler.KundeKundeDTOAssembler;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.entity.Kunde;
import de.anna.springboot.model.entity.Produkt;
import de.anna.springboot.repository.KundeRepository;
import de.anna.springboot.repository.ProduktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KundeServiceImpl implements KundeService {

    @Autowired
    private KundeRepository kundeRepository;

    @Autowired
    private ProduktRepository produktRepository;


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

                clearKunde(kundeFromDatenbank);

                Kunde kunde = KundeKundeDTOAssembler.mapKundeDTOToKunde(kundeDTO, kundeFromDatenbank);

                kundeRepository.save(kunde);
            }
        }


    }

    private void clearKunde(Kunde kundeFromDatenbank) {

        List<Produkt> produktList = kundeFromDatenbank.getProduktList();

        for(Produkt produkt : produktList){
            produktRepository.delete(produkt);
        }
        produktList.clear();
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
        List<Kunde> kundenByNachname = kundeRepository.findKundenByNachname(nachname);

        for (Kunde kunde : kundenByNachname) {
            KundeDTO kundeDTO = KundeKundeDTOAssembler.mapKundeToKundeDTO(kunde);
            kundeDTOList.add(kundeDTO);
        }

        return kundeDTOList;
    }


}
