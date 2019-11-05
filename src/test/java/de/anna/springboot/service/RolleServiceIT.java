package de.anna.springboot.service;

import de.anna.springboot.model.dto.RolleDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
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

        Assert.assertEquals("PO123", rolleFromDB.get(0).getName());

    }
}
