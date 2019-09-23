package au.com.optus.ctc;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author revathyms
 */
@EnableWebMvc
@EnableConfigurationProperties
@EntityScan(basePackages = { "au.com.optus.ctc.model" })
@EnableJpaAuditing
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ClinicalTrialsConnectApp {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ClinicalTrialsConnectApp.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "9090"));
		app.run(args);
	}
}


