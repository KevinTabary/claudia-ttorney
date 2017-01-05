package com.kt.claudiattorney.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "OPPOSING_COUNSEL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpposingCounsel {

    @Column(name = "ID")
    @Id
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "ADRESS")
    private String adress;
    @Column(name = "PHONENUMBER")
    private String phoneNumber;
    @Column(name = "FAXNUMBER")
    private String faxNumber;
    @Column(name = "MAIL")
    private String mail;
    @Column(name = "OTHER")
    private String other;
}
