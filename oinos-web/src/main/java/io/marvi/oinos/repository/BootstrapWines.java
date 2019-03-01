package io.marvi.oinos.repository;

import io.marvi.oinos.service.RegionService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class BootstrapWines {

    Logger logger = LoggerFactory.getLogger(BootstrapWines.class);

    RegionService regionService;

    private JSONObject assortment;

    private List<String> ignoredCountries = Arrays.asList("Övriga ursprung", "EU", "Varierande ursprung");

    public BootstrapWines(RegionService regionService) throws IOException, URISyntaxException {
        this.regionService = regionService;
        logger.info("BootstrapWines()");
        Path path = Paths.get(getClass().getClassLoader()
                .getResource("sortiment.json").toURI());
        this.assortment = new JSONObject(new String(Files.readAllBytes(path)));
    }

    @Transactional
    public void addWinesAndRegions() {
        logger.debug("addWinesAndRegions");
        JSONArray arr = assortment.getJSONArray("artiklar");
        for (int i = 0; i < arr.length(); i++) {
            String name = arr.getJSONObject(i).getString("name");
            logger.debug("Handling wine: " + name);
            String region = arr.getJSONObject(i).getString("region");
            String country = arr.getJSONObject(i).getString("country");
            if(region != null || region.equals("") && country != null || country.equals("")) {
                if(!ignoredCountries.contains(country)) {
                    regionService.findOrCreateRegion(region, country);
                }
            }
        }
    }
}
