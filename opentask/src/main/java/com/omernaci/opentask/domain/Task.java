package com.omernaci.opentask.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String notes;

    private Date startDate;

    private Date dueDate;

    private int priority;

    private boolean completed;

}
