package io.marvi.oinos.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BootstrapWinesTests {

    Logger logger = LoggerFactory.getLogger(BootstrapWinesTests.class);

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    public void testLoadingJsonData() {
    }


}
