package com.kt.claudiattorney.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "TASK")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "DEADLINE")
    private Date deadline;
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @ManyToOne
    @JoinColumn(name = "CASE_ID")
    private Case aCase;
}
