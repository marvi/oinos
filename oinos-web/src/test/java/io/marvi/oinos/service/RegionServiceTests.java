package io.marvi.oinos.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegionServiceTests {

    @Autowired
    private RegionService regionService;


    @Test
    public void testFindOrCreateRegion() {

        String country = "Frankrike";
        String region1 = "Bordeaux";
        String region2 = "Alsace";

        regionService.findOrCreateRegion(region1, country);
        regionService.findOrCreateRegion(region2, country);
        regionService.findOrCreateRegion(region2, country);

    }

}
