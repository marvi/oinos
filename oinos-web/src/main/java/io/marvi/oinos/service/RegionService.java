package io.marvi.oinos.service;

import io.marvi.oinos.model.Country;
import io.marvi.oinos.model.Region;
import io.marvi.oinos.repository.CountryRepository;
import io.marvi.oinos.repository.RegionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RegionService {

    private static final Logger log = LoggerFactory.getLogger(RegionService.class);

    private RegionRepository regionRepository;
    private CountryRepository countryRepository;

    public RegionService(RegionRepository regionRepository, CountryRepository countryRepository) {
        this.regionRepository = regionRepository;
        this.countryRepository = countryRepository;
    }

    public Iterable<Region> list() {
        return regionRepository.findAll();
    }

    @Transactional
    public Region findOrCreateRegion(String regionName, String countryName) {
        log.debug("findOrCreateRegion - Region: " + regionName + " Country: " + countryName);
        final Country country = countryRepository.findOneByName(countryName)
                .orElseGet(() -> countryRepository.save(new Country(countryName)));
        log.debug(country.toString());
        Region region = regionRepository.findOneByName(regionName)
                .orElseGet(() -> regionRepository.save(new Region(regionName, country)));
        country.addRegion(region);
        log.debug(region.toString());
        return region;
    }


}
