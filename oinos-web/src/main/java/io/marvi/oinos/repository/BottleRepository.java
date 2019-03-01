package io.marvi.oinos.repository;

import io.marvi.oinos.model.Bottle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BottleRepository extends CrudRepository<Bottle, Long> {

    List<Bottle> findByVintage(Integer vintage);

}
