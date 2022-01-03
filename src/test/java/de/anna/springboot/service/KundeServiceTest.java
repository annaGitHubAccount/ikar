package de.anna.springboot.service;

import de.anna.springboot.model.assembler.KundeKundeDTOAssembler;
import de.anna.springboot.model.dto.KundeDTO;
import de.anna.springboot.model.dto.xml.KundeZeileDTO;
import de.anna.springboot.model.entity.Kunde;
import de.anna.springboot.repository.AdresseRepository;
import de.anna.springboot.repository.KundeRepository;
import de.anna.springboot.repository.KundeSucheRepository;
import de.anna.springboot.repository.ProduktRepository;
import de.anna.springboot.repository.RolleRepository;
import de.anna.springboot.testDatenGenerator.KundeTestDatenGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
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

    private static Kunde kunde1;
    private static Kunde kunde2;


    @Before
    public void setUp(){

        ArrayList<Kunde> kundeArrayList = new ArrayList<>();

        ArrayList<Kunde> kundeArrayListByNachname = new ArrayList<>();

        kunde1 = KundeTestDatenGenerator.erstellBeispielhaftenKunden1();
        kunde2 = KundeTestDatenGenerator.erstellBeispielhaftenKunden2();

        kundeArrayList.add(kunde1);
        kundeArrayList.add(kunde2);

        kundeArrayListByNachname.add(kunde1);

        when(kundeRepository.findAll()).thenReturn(kundeArrayList);
        when(kundeRepository.findKundeByNachname(kunde1.getNachname())).thenReturn(kundeArrayListByNachname);

        Optional<Kunde> kunde1Optional = Optional.of(kunde1);
        when(kundeRepository.findById(KundeServiceTest.kunde1.getId())).thenReturn(kunde1Optional);
    }


    @Test
    public void findAllKundeZeileDTOTest(){

        KundeService kundeService = new KundeServiceImpl(kundeRepository, produktRepository, kundeSucheRepository, rolleRepository, adresseRepository);
        List<KundeZeileDTO> kundeZeileDTOList = kundeService.findAllKundeZeileDTO();

        KundeZeileDTO kundeZeileDTO1 = kundeZeileDTOList.get(0);

        assertEquals(2, kundeZeileDTOList.size());
        assertEquals(kunde1.getNachname(), kundeZeileDTO1.getNachname());
        verify(kundeRepository, atLeastOnce()).findAll();

    }



    @Test
    public void findKundenByNachname(){

        KundeService kundeService = new KundeServiceImpl(kundeRepository, produktRepository, kundeSucheRepository, rolleRepository, adresseRepository);
        List<KundeDTO> kundenByNachnameList = kundeService.findKundenByNachname(kunde1.getNachname());

        assertEquals(1, kundenByNachnameList.size());
        verify(kundeRepository, atLeastOnce()).findKundeByNachname(kunde1.getNachname());
    }


    @Test
    public void findKundeById(){

        KundeService kundeService = new KundeServiceImpl(kundeRepository, produktRepository, kundeSucheRepository, rolleRepository, adresseRepository);
        KundeDTO kundeDTO = kundeService.findKundeById(KundeServiceTest.kunde1.getId());

        //assertEquals(kunde1, kundeDTO);

    }

}
