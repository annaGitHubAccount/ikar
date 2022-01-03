package de.anna.springboot.service;

import de.anna.springboot.model.dto.RolleDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RolleServiceIT {

    @Autowired
    private RolleService rolleService;

    @Test
    public void shouldEineRolleInDerDatenbankSpeichern(){

        RolleDTO rolleDTO = new RolleDTO();
        rolleDTO.setName("PO123");
        rolleDTO.setKundeId(1L);

        rolleService.save(rolleDTO);

        List<RolleDTO> rolleFromDB = rolleService.findRolleByName("PO123");

        assertEquals("PO123", rolleFromDB.get(0).getName());

    }
}
