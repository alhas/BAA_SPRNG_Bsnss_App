package com.business.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository) {
        return args -> {
            Employee bahtiyar = new Employee(
                    "bahtiyaralialhas@gmail.com",
                    "Bahtiyar",
                    "Ali",
                    "ALHAS",
                    "FullStack Developler",
                    "555 444 214",
                    "https://avatars.githubusercontent.com/u/34629971?s=400&u=cdc33eb3bc2f993a2fa0bbc030acf4047a15ab10&v=4",
                    LocalDate.of(2020, Month.FEBRUARY, 28)
            );

            Employee hakan = new Employee(
                    "hakan@outlook.com",
                    "Hakan",
                    null,
                    "Zaralioglu",
                    "Logisticci",
                    "562 232 123",
                    "https://cutt.ly/Jlfqzlm",
                    LocalDate.of(2020, Month.JANUARY, 10)
            );

            repository.saveAll(List.of(bahtiyar, hakan));

        };


    }

}
