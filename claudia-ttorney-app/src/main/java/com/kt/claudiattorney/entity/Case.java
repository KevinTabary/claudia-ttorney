package com.kt.claudiattorney.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "CASE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Case {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "HOURLY_RATE")
    private Double hourlyRate;
    @Column(name = "STATUS")
    private CaseStatus status;
    @OneToMany
    private List<Service> services; // OK
    @ManyToMany
    private List<Customer> customers; // DEVRAIT PLUTOT ETRE MANY TO MANY ????
    @OneToMany
    private List<OpposingCounsel> opposingCounsels; // SI C EST ONE TO ONE, ALORS List<OpposingCounsel> opposingCounsels ==> opposingCounsel
    @ManyToMany
    private List<Appointment> appointments; // DEVRAIT PLUTOT ETRE ONE TO MANY ????
    @OneToMany
    private List<Task> tasks; // DEVRAIT PLUTOT ETRE ONE TO MANY ????
}
