package com.kt.claudiattorney.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "OPPOSING_COUNSEL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpposingCounsel {

    @Column(name = "ID")
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "FAX_NUMBER")
    private String faxNumber;
    @Column(name = "MAIL")
    private String mail;
    @Column(name = "OTHER")
    private String other;
    @ManyToMany
    @JoinTable(name = "OPPOSING_COUNSEL_CASES", joinColumns = @JoinColumn(name = "OPPOSING_COUNSEL_ID"), inverseJoinColumns = @JoinColumn(name = "CASE_ID"))
    private List<Case> casesManaged;
}
