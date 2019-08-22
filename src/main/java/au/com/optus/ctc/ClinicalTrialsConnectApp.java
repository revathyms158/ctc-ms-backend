package au.com.optus.ctc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ClinicalTrialsConnectApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ClinicalTrialsConnectApp.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "9090"));
        app.run(args);
    }
}
