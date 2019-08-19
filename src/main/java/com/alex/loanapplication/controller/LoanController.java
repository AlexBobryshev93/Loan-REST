package com.alex.loanapplication.controller;

import com.alex.loanapplication.model.Loan;
import com.alex.loanapplication.repo.LoanRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("loans")
@AllArgsConstructor
public class LoanController {
    private LoanRepo loanRepo;

    @GetMapping
    List<Loan> listLoans() {
        return (ArrayList<Loan>) loanRepo.findAll();
    }

    @GetMapping("{id}")
    List<Loan> listLoansByUser(@PathVariable int id) {
        return (ArrayList<Loan>) loanRepo.findAllByUser(id);
    }

    @PostMapping
    boolean apply(@RequestBody Loan loan) {
        loan.getUser().getCountry().setLastApplicationTime(LocalDateTime.now());
        if (loan.isValid()) {
            loanRepo.save(loan);
            return true;
        }
        else return false;
    }
}
