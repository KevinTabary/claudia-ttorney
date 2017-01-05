package com.kt.claudiattorney.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity(name = "BILL")
public class Bill {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "DATE")
    private Date date;
    @OneToMany
    private List<Service> services;
}
