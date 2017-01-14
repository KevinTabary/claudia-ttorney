package com.kt.claudiattorney.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "APPOINTMENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Column(name = "ID")
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "DATE")
    private Date date;
    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private AppointmentType type;
    @ManyToOne
    @JoinColumn(name = "CASE_ID")
    private Case aCase;
}
