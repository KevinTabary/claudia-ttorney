package com.kt.claudiattorney.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity(name = "TASK")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "DEADLINE")
    private Date deadline;
    @Column(name = "STATUS")
    private TaskStatus status;
    @ManyToOne
    private Case aCase;
}
