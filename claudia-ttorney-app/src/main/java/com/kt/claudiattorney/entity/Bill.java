package com.kt.claudiattorney.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "BILL")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Bill {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;
    @Column(name = "DATE")
    private Date date;
    @Column(name = "AMOUNT")
    private Double amount;
    @OneToMany(mappedBy = "bill")
    private List<Prestation> prestations;
}
