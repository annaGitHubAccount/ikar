package de.anna.springboot.service;

import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.xml.KundeZeileDTO;
import de.anna.springboot.model.entity.Kunde;
import de.anna.springboot.repository.AdresseRepository;
import de.anna.springboot.repository.KundeRepository;
import de.anna.springboot.repository.KundeSucheRepository;
import de.anna.springboot.repository.ProduktRepository;
import de.anna.springboot.repository.RolleRepository;
import de.anna.springboot.testDatenGenerator.KundeTestDatenGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class KundeServiceTest {


    @Mock
    private KundeRepository kundeRepository;

    @Mock
    private ProduktRepository produktRepository;

    @Mock
    private KundeSucheRepository kundeSucheRepository;

    @Mock
    private RolleRepository rolleRepository;

    @Mock
    private AdresseRepository adresseRepository;




    @Test
    public void findAllKundeZeileDTOTest(){

        ArrayList<Kunde> kundeArrayList = new ArrayList<>();

        Kunde kunde1 = KundeTestDatenGenerator.erstellBeispielhaftenKunden1();
        Kunde kunde2 = KundeTestDatenGenerator.erstellBeispielhaftenKunden2();

        kundeArrayList.add(kunde1);
        kundeArrayList.add(kunde2);

        when(kundeRepository.findAll()).thenReturn(kundeArrayList);

        KundeService kundeService = new KundeServiceImpl(kundeRepository, produktRepository, kundeSucheRepository, rolleRepository, adresseRepository);
        List<KundeZeileDTO> kundeZeileDTOList = kundeService.findAllKundeZeileDTO();

        KundeZeileDTO kundeZeileDTO1 = kundeZeileDTOList.get(0);

        assertEquals(2, kundeZeileDTOList.size());
        assertEquals(kunde1.getNachname(), kundeZeileDTO1.getNachname());

        verify(kundeRepository, atLeastOnce()).findAll();
    }

    @Test
    public void findKundenByNachname(){

        Kunde kunde1 = KundeTestDatenGenerator.erstellBeispielhaftenKunden1();
        ArrayList<Kunde> kundeArrayList = new ArrayList<>();
        kundeArrayList.add(kunde1);

        when(kundeRepository.findKundeByNachname(kunde1.getNachname())).thenReturn(kundeArrayList);

        KundeService kundeService = new KundeServiceImpl(kundeRepository, produktRepository, kundeSucheRepository, rolleRepository, adresseRepository);
        List<KundeDTO> kundenByNachnameList = kundeService.findKundenByNachname(kunde1.getNachname());

        assertEquals(1, kundenByNachnameList.size());
        verify(kundeRepository, atLeastOnce()).findKundeByNachname(kunde1.getNachname());
    }

}
