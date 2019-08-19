package com.alex.loanapplication.service;

import com.alex.loanapplication.model.Loan;

import java.util.List;

public interface LoanService {
    List<Loan> getAll();
    List<Loan> getAllByUserId(int id);
    boolean apply(Loan loan);
}
