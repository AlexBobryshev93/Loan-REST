package com.alex.loanapplication.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
@Table(name = "loans")
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double amount;
    private Period term;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public boolean isValid() {
        if (user.isBlacklisted()
                || LocalDateTime.now().isBefore(user.getCountry().getLastApplicationTime().plusSeconds(1))) return false;
        else return true;
    }
}
