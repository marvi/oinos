package io.marvi.oinos;

import io.marvi.oinos.repository.BootstrapWines;
import io.marvi.oinos.service.RegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("io.marvi.oinos.model")
@EnableJpaRepositories("io.marvi.oinos.repository")
@Configuration
@SpringBootApplication
public class OinosApplication {

	private static final Logger log = LoggerFactory.getLogger(OinosApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OinosApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(RegionService regionService) {
		return args -> {
			BootstrapWines bw = new BootstrapWines(regionService);
			bw.addWinesAndRegions();
		};
	}

}
