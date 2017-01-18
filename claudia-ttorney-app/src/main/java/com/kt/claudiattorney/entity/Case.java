package com.kt.claudiattorney.entity;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "CASE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Case {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;
    @Column(name = "DESCRIPTION")
    @NotEmpty(message = "Description cannot be null !")
    private String description;
    @Column(name = "HOURLY_RATE")
    @NotNull(message = "Hourly rate cannot be null !")
    private Double hourlyRate;
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Case status cannot be null !")
    private CaseStatus status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aCase")
    private List<Prestation> prestations;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CUSTOMER_CASE", joinColumns = @JoinColumn(name = "CASE_ID"), inverseJoinColumns = @JoinColumn(name = "CUSTOMER_ID"))
    private List<Customer> customers;
    @ManyToMany(mappedBy = "casesManaged")
    private List<OpposingCounsel> opposingCounsels;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aCase")
    private List<Appointment> appointments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aCase")
    private List<Task> tasks;

    public List<Customer> getCustomers() {
        if (customers == null) {
            customers = Lists.newArrayList();
        }
        return customers;
    }
}
