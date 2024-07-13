package com.example.boardcopendium04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BoardCopendium04Application {

    public static void main(String[] args) {
        SpringApplication.run(BoardCopendium04Application.class, args);
    }

}
