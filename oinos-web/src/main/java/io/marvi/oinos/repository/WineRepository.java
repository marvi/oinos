package io.marvi.oinos.repository;

import io.marvi.oinos.model.Wine;
import org.springframework.data.repository.CrudRepository;

public interface WineRepository extends CrudRepository<Wine, Long> {

    Wine findByName(String name);
}
