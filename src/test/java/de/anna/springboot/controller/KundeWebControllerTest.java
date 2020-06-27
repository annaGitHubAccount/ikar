package de.anna.springboot.controller;

import de.anna.springboot.model.dto.LandDTO;
import de.anna.springboot.model.dto.ProduktStammdatenDTO;
import de.anna.springboot.service.*;


import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;


public class KundeWebControllerTest {

    private KundeWebController kundeWebController;


    @Mock
    private KundeService kundeService;

    @Mock
    private ProduktStammdatenService produktStammdatenService;

    @Mock
    private LandService landService;

    @Mock
    private BundeslandService bundeslandService;

    @Mock
    private OrtService ortService;

    @Mock
    private Model model;


    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);

        kundeWebController = new KundeWebController(kundeService, produktStammdatenService, landService, bundeslandService, ortService);

        List<ProduktStammdatenDTO> produktStammdatenDTOList = new ArrayList<>();
        produktStammdatenDTOList.add(new ProduktStammdatenDTO());
        produktStammdatenDTOList.add(new ProduktStammdatenDTO());
        Mockito.when(produktStammdatenService.findAll()).thenReturn(produktStammdatenDTOList);

        List<LandDTO> landDTOList = new ArrayList<>();
        landDTOList.add(new LandDTO());
        landDTOList.add(new LandDTO());
        Mockito.when(landService.findAll()).thenReturn(landDTOList);
    }


    @Test
    public void kundeFormularZeigenTest() {

        Mockito.when(model.addAttribute(ArgumentMatchers.eq("kundeForm"), any())).thenReturn(null);

        String jspSeite = kundeWebController.kundeFormularZeigen(model);
        Mockito.verify(produktStammdatenService, atLeastOnce()).findAll();
        Mockito.verify(landService, atLeastOnce()).findAll();

    }
}
