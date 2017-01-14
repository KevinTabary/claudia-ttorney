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
    @GeneratedValue
    private Long id;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "HOURLY_RATE")
    private Double hourlyRate;
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private CaseStatus status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aCase")
    private List<Prestation> prestations;
    @ManyToMany(mappedBy = "cases")
    private List<Customer> customers;
    @ManyToMany(mappedBy = "casesManaged")
    private List<OpposingCounsel> opposingCounsels;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aCase")
    private List<Appointment> appointments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aCase")
    private List<Task> tasks;
}
