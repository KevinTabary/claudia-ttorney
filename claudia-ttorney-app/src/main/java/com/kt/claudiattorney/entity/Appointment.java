package com.kt.claudiattorney.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Entity(name = "APPOINTMENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Column(name = "ID")
    @Id
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "TYPE")
    private AppointmentType type;

    @ManyToMany
    private List<Case> cases;

}
