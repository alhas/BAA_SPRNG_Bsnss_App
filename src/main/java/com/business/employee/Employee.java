package com.business.employee;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;


@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;

    private String email;
    private String name;
    private String midname;
    private String surname;
    private String position;
    private LocalDate startDate;

    @Transient
    private String workedTime;

    public Employee(String email, String name, String midname, String surname, String position, LocalDate startDate) {
        this.email = email;
        this.name = name;
        this.midname = midname;
        this.surname = surname;
        this.position = position;
        this.startDate = startDate;
    }

    public String getWorkedTime() {
        Period workedTime = Period.between(this.startDate, LocalDate.now());

        return workedTime.getYears() + "Y "
                + workedTime.getMonths() + "M "
                + workedTime.getDays() + "D ";

    }

}
