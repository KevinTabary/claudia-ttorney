package com.kt.claudiattorney.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "CUSTOMER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "MAIL")
    private String mail;
    @Column(name = "OTHER")
    private String other;
    @Column(name = "VAT")
    private Double vat;
    @ManyToMany
    @JoinTable(name = "CUSTOMER_CASE", joinColumns = @JoinColumn(name = "CUSTOMER_ID"), inverseJoinColumns = @JoinColumn(name = "CASE_ID"))
    private List<Case> cases;
}
