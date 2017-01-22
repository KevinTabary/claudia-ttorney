package com.kt.claudiattorney.entity;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "CASE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CourtCase {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courtCase")
    private List<Prestation> prestations;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "courtCases")
    private List<Customer> customers;
    @ManyToMany(mappedBy = "casesManaged")
    private List<OpposingCounsel> opposingCounsels;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courtCase")
    private List<Appointment> appointments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courtCase")
    private List<Task> tasks;

    public List<Customer> getCustomers() {
        if (customers == null) {
            customers = Lists.newArrayList();
        }
        return customers;
    }
}
