package io.marvi.oinos.repository;

import io.marvi.oinos.model.Country;
import io.marvi.oinos.model.Region;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends CrudRepository<Country, Long> {

    Optional<Country> findOneByName(String name);

}
