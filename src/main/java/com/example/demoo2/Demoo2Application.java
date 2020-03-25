package com.example.demoo2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demoo2Application {

    public static void main(String[] args) {

        SpringApplication.run(Demoo2Application.class, args);
    }

    @Bean
    public CommandLineRunner runner(ClientRepository clientRepository) {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {
                for (int i = 0; i < 20; i++) {
                    Task c = new Task("name" + i +"/n", "name" + i + "@gmail.com","Task"+i);
                    clientRepository.save(c);
                }
            }
        };
    }
}
