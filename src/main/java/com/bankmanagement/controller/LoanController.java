package com.bankmanagement.controller;

import com.bankmanagement.model.Loan;
import com.bankmanagement.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loans")
public class LoanController
 {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public Loan applyLoan(@RequestBody Loan loan) {
        return loanService.applyLoan(loan);
    }
}
