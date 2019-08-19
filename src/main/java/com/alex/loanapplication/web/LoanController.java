package com.alex.loanapplication.web;

import com.alex.loanapplication.model.Loan;
import com.alex.loanapplication.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("loans")
@AllArgsConstructor
public class LoanController {
    private LoanService loanService;

    @GetMapping
    List<Loan> listLoans() {
        return loanService.getAll();
    }

    @GetMapping("{id}")
    List<Loan> listLoansByUser(@PathVariable int id) {
        return loanService.getAllByUserId(id);
    }

    @PostMapping
    boolean apply(@RequestBody Loan loan) {
        return loanService.apply(loan);
    }
}
