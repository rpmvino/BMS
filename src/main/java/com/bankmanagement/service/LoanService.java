package com.bankmanagement.service;

import com.bankmanagement.model.Loan;
import com.bankmanagement.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public Loan applyLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public List<Loan> getLoansByCustomerId(Long customerId) {
        return loanRepository.findByCustomerId(customerId);
    }
}