package de.dhbw.ase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class PEApplication {

    public static void main(String[] args) {
        System.setProperty("user.timezone", "Europe/Berlin");
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Berlin"));
        SpringApplication.run(PEApplication.class, args);
    }
}
