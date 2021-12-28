package de.anna.springboot.controller;

import de.anna.springboot.controller.helper.ButtonNachLinksHelperVonProdukt;
import de.anna.springboot.controller.helper.ButtonNachRechtsHelperVonProdukt;
import de.anna.springboot.controller.helper.RolleDTOHelper;
import de.anna.springboot.model.assembler.KundeDTOKundeFormAssembler;
import de.anna.springboot.model.assembler.ProduktStammdatenDTOProduktDTOAssembler;
import de.anna.springboot.model.dto.*;
import de.anna.springboot.model.enums.KundeArt;
import de.anna.springboot.model.form.KundeForm;
import de.anna.springboot.model.validator.KundeFormValidator;
import de.anna.springboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/ikar/web")
public class KundeWebController {

    private static final String KUNDE_FORM = "kundeForm";
    private static final String KUNDE_LIST = "kundeList";
    private static final String PRODUKT_STAMMDATEN_LIST = "produktStammdatenList";
    private static final String PRODUKT_LIST = "produktList";
    private static final String TAB_NUMMER = "TabNummer";

    @Autowired
    private KundeService kundeService;

    @Autowired
    private KundeFormValidator kundeFormValidator;

    @Autowired
    private ProduktStammdatenService produktStammdatenService;

    @Autowired
    private ButtonNachRechtsHelperVonProdukt buttonNachRechtsHelperVonProdukt;

    @Autowired
    private ButtonNachLinksHelperVonProdukt buttonNachLinksHelperVonProdukt;

    @Autowired
    private RolleDTOHelper rolleDTOHelper;

    @Autowired
    private LandService landService;

    @Autowired
    private BundeslandService bundeslandService;

    @Autowired
    private OrtService ortService;


    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(kundeFormValidator);
    }


    @GetMapping("/addkunde")
    public String kundeFormularZeigen(Model model) {

        KundeForm kundeForm = new KundeForm();

        List<ProduktStammdatenDTO> produktStammdatenDTOList = produktStammdatenService.findAll();
        List<String> produkStammdatenListAlsName = new ArrayList<>();
        for (ProduktStammdatenDTO produktStammdatenDTO : produktStammdatenDTOList) {
            produkStammdatenListAlsName.add(produktStammdatenDTO.getName());
        }
        kundeForm.setProduktStammdatenList(produkStammdatenListAlsName);

        List<LandDTO> landDTOList = landService.findAll();
        kundeForm.setLandDTOList(landDTOList);
        kundeForm.setLandDTOListPostanschrift(landDTOList);

        kundeForm.setKundeArtMap(KundeArt.convertKundeArtEnumToTextTextMap());

        model.addAttribute(KUNDE_FORM, kundeForm);

        return "addKunde";
    }


    @PostMapping("/kundeweiterleiten")
    public String kundeWeiterleiten(Model model, @Valid @ModelAttribute(KUNDE_FORM) KundeForm kundeForm, BindingResult resultOfValidation) {

        List<LandDTO> landDTOList = landService.findAll();

        setAuswahllistenVonPostanschriftFuerKundeForm(kundeForm, landDTOList);

        setAuswahllistenVonMeldeanschriftFuerKundeForm(kundeForm, landDTOList);

        kundeForm.setKundeArtMap(KundeArt.convertKundeArtEnumToTextTextMap());

        if (resultOfValidation.hasErrors()) {

            model.addAttribute(KUNDE_FORM, kundeForm);
            return "addKunde";

        } else {

            model.addAttribute(KUNDE_FORM, kundeForm);
            return "kundeWeiterleiten";
        }
    }

    private void setAuswahllistenVonMeldeanschriftFuerKundeForm(@ModelAttribute(KUNDE_FORM) @Valid KundeForm kundeForm, List<LandDTO> landDTOList) {

        LandDTO landDTOMeldeanschrift = landService.findLandBySymbol(kundeForm.getLandVonMeldeanschrift());
        kundeForm.setLandVonMeldeanschriftName(landDTOMeldeanschrift.getName());

        String bundeslandVonMeldeanschrift = kundeForm.getBundeslandVonMeldeanschrift();
        List<OrtDTO> ortByBundesland = ortService.findOrtByBundesland(bundeslandVonMeldeanschrift);
        kundeForm.setOrtDTOList(ortByBundesland);

        String landVonMeldeanschrift = kundeForm.getLandVonMeldeanschrift();
        List<BundeslandDTO> bundeslandByLandList = bundeslandService.findBundeslandByLand(landVonMeldeanschrift);
        kundeForm.setBundeslandDTOList(bundeslandByLandList);

        kundeForm.setLandDTOList(landDTOList);
    }

    private void setAuswahllistenVonPostanschriftFuerKundeForm(@ModelAttribute(KUNDE_FORM) @Valid KundeForm kundeForm, List<LandDTO> landDTOList) {

        if (kundeForm.getLandVonPostanschrift() != null) {
            LandDTO landDTOPostanschrift = landService.findLandBySymbol(kundeForm.getLandVonPostanschrift());
            kundeForm.setLandVonPostanschriftName(landDTOPostanschrift.getName());
        }

        if (kundeForm.getBundeslandVonPostanschrift() != null) {
            String bundeslandVonPostanschrift = kundeForm.getBundeslandVonPostanschrift();
            List<OrtDTO> ortByBundeslandPostanschrift = ortService.findOrtByBundesland(bundeslandVonPostanschrift);
            kundeForm.setOrtDTOListPostanschrift(ortByBundeslandPostanschrift);
        }

        if (kundeForm.getLandVonPostanschrift() != null) {
            String landVonPostanschrift = kundeForm.getLandVonPostanschrift();
            List<BundeslandDTO> bundeslandByLandListPostanschrift = bundeslandService.findBundeslandByLand(landVonPostanschrift);
            kundeForm.setBundeslandDTOListPostanschrift(bundeslandByLandListPostanschrift);
        }

        kundeForm.setLandDTOListPostanschrift(landDTOList);
    }

    private List<ProduktDTO> createProduktListDTOFromKundeForm(KundeForm kundeForm) {

        List<ProduktDTO> produktGewaehlteList = new ArrayList<>();
        List<String> produktGewaehlteListAlsName = kundeForm.getProduktList();

        List<ProduktStammdatenDTO> produktStammdatenDTOList = produktStammdatenService.findAll();

        for (ProduktStammdatenDTO produktStammdatenDTO : produktStammdatenDTOList) {

            for (String gewaehlteProduktAlsName : produktGewaehlteListAlsName) {
                if (gewaehlteProduktAlsName.equals(produktStammdatenDTO.getName())) {
                    produktGewaehlteList.add(new ProduktDTO(produktStammdatenDTO.getSymbol(), gewaehlteProduktAlsName, produktStammdatenDTO.getPreis(), produktStammdatenDTO.isAktiv()));
                }
            }
        }
        return produktGewaehlteList;
    }


    @PostMapping("/savekunde")
    public String saveKunde(@ModelAttribute(KUNDE_FORM) @Valid KundeForm kundeForm, Model model) {

        List<ProduktDTO> produktListDTOFromKundeForm = createProduktListDTOFromKundeForm(kundeForm);
        KundeDTO kundeDTO = KundeDTOKundeFormAssembler.mapKundeFormToKundeDTO(kundeForm, produktListDTOFromKundeForm);
        kundeService.save(kundeDTO);

        List<KundeDTO> kundeDTOList = kundeService.findAll();
        model.addAttribute(KUNDE_LIST, kundeDTOList);

        return "redirect:/ikar/kundesucheform/listevonkunden";
    }


    @GetMapping("/editkunde/{id}")
    public String editKunde(@PathVariable Long id, Model model) {

        KundeDTO kundeDTOById = kundeService.findKundeById(id);
        KundeForm kundeForm = KundeDTOKundeFormAssembler.mapKundeDTOToKundeForm(kundeDTOById);

        List<String> produkStammdatenListAlsName = setProduktStammdatenFuerKundeFormular(kundeDTOById);
        kundeForm.setProduktStammdatenList(produkStammdatenListAlsName);

        List<String> produkListAlsName = setProduktenFuerKundeFormular(kundeDTOById);
        kundeForm.setProduktList(produkListAlsName);

        List<LandDTO> landDTOList = landService.findAll();
        kundeForm.setLandDTOList(landDTOList);
        String bundeslandVonPostanschrift = kundeForm.getBundeslandVonPostanschrift();
        List<OrtDTO> ortByBundeslandPostanschrift = ortService.findOrtByBundesland(bundeslandVonPostanschrift);
        String landVonPostanschrift = kundeForm.getLandVonPostanschrift();
        List<BundeslandDTO> bundeslandByLandListPostanschrift = bundeslandService.findBundeslandByLand(landVonPostanschrift);
        String bundeslandVonMeldeanschrift = kundeForm.getBundeslandVonMeldeanschrift();
        List<OrtDTO> ortByBundesland = ortService.findOrtByBundesland(bundeslandVonMeldeanschrift);
        String landVonMeldeanschrift = kundeForm.getLandVonMeldeanschrift();
        List<BundeslandDTO> bundeslandByLandList = bundeslandService.findBundeslandByLand(landVonMeldeanschrift);
        kundeForm.setOrtDTOListPostanschrift(ortByBundeslandPostanschrift);
        kundeForm.setLandDTOListPostanschrift(landDTOList);
        kundeForm.setBundeslandDTOListPostanschrift(bundeslandByLandListPostanschrift);
        kundeForm.setLandDTOList(landDTOList);
        kundeForm.setOrtDTOList(ortByBundesland);
        kundeForm.setBundeslandDTOList(bundeslandByLandList);

        kundeForm.setKundeArtMap(KundeArt.convertKundeArtEnumToTextTextMap());

        model.addAttribute(KUNDE_FORM, kundeForm);

        return "editKunde";
    }

    private List<String> setProduktenFuerKundeFormular(KundeDTO kundeDTOById) {

        List<ProduktDTO> produktDTOListVonKunden = kundeDTOById.getProduktDTOList();

        List<String> produkListAlsName = new ArrayList<>();
        for (ProduktDTO produktDTO : produktDTOListVonKunden) {
            produkListAlsName.add(produktDTO.getName());
        }
        return produkListAlsName;
    }

    private List<String> setProduktStammdatenFuerKundeFormular(KundeDTO kundeDTOById) {

        List<ProduktStammdatenDTO> produktStammdatenDTOList = produktStammdatenService.findAll();
        List<ProduktDTO> produktStammdatenList = ProduktStammdatenDTOProduktDTOAssembler.convertProduktStammdatenDTOToProduktDTO(produktStammdatenDTOList);
        List<ProduktDTO> produktDTOListVonKunden = kundeDTOById.getProduktDTOList();
        produktStammdatenList.removeAll(produktDTOListVonKunden);

        List<String> produkStammdatenListAlsName = new ArrayList<>();
        for (ProduktDTO produktStammdaten : produktStammdatenList) {
            produkStammdatenListAlsName.add(produktStammdaten.getName());
        }
        return produkStammdatenListAlsName;
    }


    @PostMapping("/kundeweiterleitenedit")
    public String kundeWeiterleitenEdit(Model model, KundeForm kundeForm) {

        List<LandDTO> landDTOList = landService.findAll();

        setAuswahllistenVonPostanschriftFuerKundeForm(kundeForm, landDTOList);

        setAuswahllistenVonMeldeanschriftFuerKundeForm(kundeForm, landDTOList);

        kundeForm.setKundeArtMap(KundeArt.convertKundeArtEnumToTextTextMap());

        model.addAttribute(KUNDE_FORM, kundeForm);

        return "kundeWeiterleitenEdit";
    }


    @GetMapping("/deletekunde/{id}")
    public String deleteKunde(@PathVariable Long id, Model model) {

        kundeService.deleteKundeById(id);

        List<KundeDTO> kundeDTOList = kundeService.findAll();
        model.addAttribute(KUNDE_LIST, kundeDTOList);

        return "redirect:/ikar/kundesucheform/listevonkunden";
    }


    @PostMapping("/bundeslaenderVonMeldeanschrift")
    public String showBundeslaenderVonMeldeanschrift(Model model, KundeForm kundeForm) {

        String landVonMeldeanschrift = kundeForm.getLandVonMeldeanschrift();
        List<BundeslandDTO> bundeslandByLandListMeldeanschrift = bundeslandService.findBundeslandByLand(landVonMeldeanschrift);

        String landVonPostanschrift = kundeForm.getLandVonPostanschrift();
        List<BundeslandDTO> bundeslandByLandListPostanschrift = bundeslandService.findBundeslandByLand(landVonPostanschrift);

        String bundeslandVonMeldeanschrift = kundeForm.getBundeslandVonMeldeanschrift();
        List<OrtDTO> ortByBundesland = ortService.findOrtByBundesland(bundeslandVonMeldeanschrift);

        List<LandDTO> landDTOList = landService.findAll();

        kundeForm.setBundeslandDTOList(bundeslandByLandListMeldeanschrift);
        kundeForm.setLandDTOList(landDTOList);
        kundeForm.setKundeArtMap(KundeArt.convertKundeArtEnumToTextTextMap());

        kundeForm.setLandDTOListPostanschrift(landDTOList);
        kundeForm.setBundeslandDTOListPostanschrift(bundeslandByLandListPostanschrift);

        kundeForm.setOrtDTOList(ortByBundesland);
        kundeForm.setLandDTOList(landDTOList);

        model.addAttribute(KUNDE_FORM, kundeForm);
        model.addAttribute(TAB_NUMMER, 1);

        if (kundeForm.getId() == null) {
            return "addKunde";
        } else {
            return "editKunde";
        }
    }

    @PostMapping("/orteVonMeldeanschrift")
    public String showOrteVonMeldeanschrift(Model model, KundeForm kundeForm) {

        String bundeslandVonMeldeanschrift = kundeForm.getBundeslandVonMeldeanschrift();
        List<OrtDTO> ortByBundesland = ortService.findOrtByBundesland(bundeslandVonMeldeanschrift);

        String bundeslandVonPostanschrift = kundeForm.getBundeslandVonPostanschrift();
        List<OrtDTO> ortByBundeslandPostanschrift = ortService.findOrtByBundesland(bundeslandVonPostanschrift);

        List<LandDTO> landDTOList = landService.findAll();

        String landVonMeldeanschrift = kundeForm.getLandVonMeldeanschrift();
        List<BundeslandDTO> bundeslandByLandList = bundeslandService.findBundeslandByLand(landVonMeldeanschrift);

        String landVonPostanschrift = kundeForm.getLandVonPostanschrift();
        List<BundeslandDTO> bundeslandByLandListPostanschrift = bundeslandService.findBundeslandByLand(landVonPostanschrift);

        kundeForm.setOrtDTOList(ortByBundesland);
        kundeForm.setLandDTOList(landDTOList);
        kundeForm.setBundeslandDTOList(bundeslandByLandList);
        kundeForm.setKundeArtMap(KundeArt.convertKundeArtEnumToTextTextMap());

        kundeForm.setOrtDTOListPostanschrift(ortByBundeslandPostanschrift);
        kundeForm.setLandDTOListPostanschrift(landDTOList);
        kundeForm.setBundeslandDTOListPostanschrift(bundeslandByLandListPostanschrift);
        kundeForm.setLandDTOList(landDTOList);

        model.addAttribute(KUNDE_FORM, kundeForm);
        model.addAttribute(TAB_NUMMER, 1);

        if (kundeForm.getId() == null) {
            return "addKunde";
        } else {
            return "editKunde";
        }
    }

    @PostMapping("/bundeslaenderVonPostanschrift")
    public String showBundeslaenderVonPostanschrift(Model model, KundeForm kundeForm) {

        String landVonPostanschrift = kundeForm.getLandVonPostanschrift();
        List<BundeslandDTO> bundeslandByLandListPostanschrift = bundeslandService.findBundeslandByLand(landVonPostanschrift);

        List<LandDTO> landDTOList = landService.findAll();

        String bundeslandVonMeldeanschrift = kundeForm.getBundeslandVonMeldeanschrift();
        List<OrtDTO> ortByBundesland = ortService.findOrtByBundesland(bundeslandVonMeldeanschrift);

        String landVonMeldeanschrift = kundeForm.getLandVonMeldeanschrift();
        List<BundeslandDTO> bundeslandByLandList = bundeslandService.findBundeslandByLand(landVonMeldeanschrift);

        kundeForm.setKundeArtMap(KundeArt.convertKundeArtEnumToTextTextMap());

        kundeForm.setLandDTOListPostanschrift(landDTOList);
        kundeForm.setBundeslandDTOListPostanschrift(bundeslandByLandListPostanschrift);

        kundeForm.setOrtDTOList(ortByBundesland);
        kundeForm.setLandDTOList(landDTOList);
        kundeForm.setBundeslandDTOList(bundeslandByLandList);

        model.addAttribute(KUNDE_FORM, kundeForm);
        model.addAttribute(TAB_NUMMER, 2);

        if (kundeForm.getId() == null) {
            return "addKunde";
        } else {
            return "editKunde";
        }
    }

    @PostMapping("/orteVonPostanschrift")
    public String showOrteVonPostanschrift(Model model, KundeForm kundeForm) {

        String bundeslandVonPostanschrift = kundeForm.getBundeslandVonPostanschrift();
        List<OrtDTO> ortByBundeslandPostanschrift = ortService.findOrtByBundesland(bundeslandVonPostanschrift);

        List<LandDTO> landDTOList = landService.findAll();

        String landVonPostanschrift = kundeForm.getLandVonPostanschrift();
        List<BundeslandDTO> bundeslandByLandListPostanschrift = bundeslandService.findBundeslandByLand(landVonPostanschrift);

        String bundeslandVonMeldeanschrift = kundeForm.getBundeslandVonMeldeanschrift();
        List<OrtDTO> ortByBundesland = ortService.findOrtByBundesland(bundeslandVonMeldeanschrift);

        String landVonMeldeanschrift = kundeForm.getLandVonMeldeanschrift();
        List<BundeslandDTO> bundeslandByLandList = bundeslandService.findBundeslandByLand(landVonMeldeanschrift);

        kundeForm.setKundeArtMap(KundeArt.convertKundeArtEnumToTextTextMap());

        kundeForm.setOrtDTOListPostanschrift(ortByBundeslandPostanschrift);
        kundeForm.setLandDTOListPostanschrift(landDTOList);
        kundeForm.setBundeslandDTOListPostanschrift(bundeslandByLandListPostanschrift);
        kundeForm.setLandDTOList(landDTOList);

        kundeForm.setOrtDTOList(ortByBundesland);
        kundeForm.setLandDTOList(landDTOList);
        kundeForm.setBundeslandDTOList(bundeslandByLandList);

        model.addAttribute(KUNDE_FORM, kundeForm);
        model.addAttribute(TAB_NUMMER, 2);

        if (kundeForm.getId() == null) {
            return "addKunde";
        } else {
            return "editKunde";
        }
    }
}
