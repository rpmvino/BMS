package com.bankmanagement.controller;

import com.bankmanagement.model.Customer;
import com.bankmanagement.model.Loan;
import com.bankmanagement.service.CustomerService;
import com.bankmanagement.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController
 {

    @Autowired
    private LoanService loanService;

    @Autowired

    private CustomerService customerService;

     @PostMapping("/apply")
     public String applyLoan(@RequestParam Long customerId, @RequestBody Loan loan) {
         Customer customer = customerService.getCustomerById(customerId)
                 .orElseThrow(() -> new RuntimeException("Customer not found"));

         loan.setCustomer(customer);
         loan.setLoanDate(LocalDate.now());
         loanService.applyLoan(loan);

         return "Loan applied successfully!";
     }

     @GetMapping("/view/{customerId}")
     public List<Loan> viewLoans(@PathVariable Long customerId) {
         return loanService.getLoansByCustomerId(customerId);
     }
}
