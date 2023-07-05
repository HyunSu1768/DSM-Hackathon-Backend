package com.hackathon.fire_sos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FireSosApplication {

    public static void main(String[] args) {
        SpringApplication.run(FireSosApplication.class, args);
    }

}
