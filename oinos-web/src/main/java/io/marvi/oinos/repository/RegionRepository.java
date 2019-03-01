package io.marvi.oinos.repository;

import io.marvi.oinos.model.Region;
import io.marvi.oinos.model.Wine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RegionRepository extends CrudRepository<Region, Long> {

    Optional<Region> findOneByName(String name);

}
