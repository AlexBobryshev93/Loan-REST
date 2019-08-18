package com.alex.loanapplication.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "loans")
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double amount;
    private LocalDate term;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private boolean approved;
}
