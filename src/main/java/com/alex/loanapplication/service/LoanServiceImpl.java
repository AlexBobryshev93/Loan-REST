package com.alex.loanapplication.service;

import com.alex.loanapplication.model.Loan;
import com.alex.loanapplication.repo.LoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanRepo loanRepo;

    @Override
    public List<Loan> getAll() {
        return (ArrayList<Loan>) loanRepo.findAll();
    }

    @Override
    public List<Loan> getAllByUserId(int id) {
        return loanRepo.findAllByUser(id);
    }

    @Override
    public boolean apply(Loan loan) {
        loan.getUser().getCountry().setLastApplicationTime(LocalDateTime.now());
        if (loan.isValid()) {
            loanRepo.save(loan);
            return true;
        }
        else return false;
    }
}
