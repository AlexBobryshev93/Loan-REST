package com.alex.loanapplication.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String surname;
    private Country country;
}
