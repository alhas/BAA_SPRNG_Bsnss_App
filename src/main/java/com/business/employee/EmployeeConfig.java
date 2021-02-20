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
                    LocalDate.of(2020, Month.FEBRUARY, 28)
            );

            Employee hakan = new Employee(
                    "hakan@outlook.com",
                    "Hakan",
                    "",
                    "Zaralioglu",
                    "Logisticci",
                    LocalDate.of(2020, Month.JANUARY, 10)
            );

            repository.saveAll(List.of(bahtiyar, hakan));

        };


    }

}
