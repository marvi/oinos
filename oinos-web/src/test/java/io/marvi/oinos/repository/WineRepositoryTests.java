package io.marvi.oinos.repository;

import io.marvi.oinos.model.Bottle;
import io.marvi.oinos.model.Wine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WineRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private WineRepository wineRepository;

    @Autowired
    private BottleRepository bottleRepository;

    @Test
    public void whenFindByName_thenReturnWine() {
        Wine grange  = new Wine("Grange");
        Bottle bottleOf1994Grange = new Bottle(grange, 1994, 3500, new Date());
        grange.addBottle(bottleOf1994Grange);
        entityManager.persist(grange);
        entityManager.flush();
        Wine found = wineRepository.findByName("Grange");
        assertThat(found.getName())
                .isEqualTo(grange.getName());
        assertThat(found.getBottles().size()).isEqualTo(1);
    }

    @Test
    public void addThenRemoveBottles() {
        Wine petrus = new Wine("Château Petrus");
        petrus.addBottle(new Bottle(petrus, 1978, 13500, new Date()));
        Bottle petrus1984 = new Bottle(petrus, 1984, 34222, new Date());
        petrus.addBottle(petrus1984);
        petrus.addBottle(new Bottle(petrus, 1998, 12322, new Date()));
        petrus.addBottle(new Bottle(petrus, 2001, 6700, new Date()));
        entityManager.persist(petrus);
        entityManager.flush();
        Wine found = wineRepository.findByName("Château Petrus");
        assertThat(found.getName())
                .isEqualTo(petrus.getName());
        assertThat(found.getBottles().size()).isEqualTo(4);
        petrus.removeBottle(petrus1984);
        assertThat(found.getBottles().size()).isEqualTo(3);
        List<Bottle> shouldBeEmpty = bottleRepository.findByVintage(1984);
        assertThat(shouldBeEmpty.size()).isEqualTo(0);
    }

}
