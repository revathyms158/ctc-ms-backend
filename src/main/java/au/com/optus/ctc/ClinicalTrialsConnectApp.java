package au.com.optus.ctc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Collections;

@EnableWebMvc
@EnableConfigurationProperties
@EntityScan(basePackages = {"au.com.optus.ctc.model"})
@EnableJpaAuditing
@SpringBootApplication
public class ClinicalTrialsConnectApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ClinicalTrialsConnectApp.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "9090"));
        app.run(args);
    }
}
