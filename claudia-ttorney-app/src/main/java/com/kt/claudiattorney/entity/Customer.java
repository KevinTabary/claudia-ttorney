package com.kt.claudiattorney.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "CUSTOMER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "ADRESS")
    private String adress;
    @Column(name = "PHONENUMBER")
    private String phoneNumber;
    @Column(name = "MAIL")
    private String mail;
    @Column(name = "OTHER")
    private String other;
    @Column(name = "VAT")
    private Double vat;
}
