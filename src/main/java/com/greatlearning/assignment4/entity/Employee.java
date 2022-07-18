package com.greatlearning.assignment4.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
//Using lombook data annotation for persistence purposes.
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    private String firstName;
    private String lastName;
    private String email;
}
