package com.alex.loanapplication.repo;

import com.alex.loanapplication.model.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepo extends CrudRepository<Loan, Integer> {
    List<Loan> findAllByUser(int userId);
}
