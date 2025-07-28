
package com.bankmanagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loanType;
    private Double loanAmount;
    private LocalDate loanDate;
    private Double rateOfInterest;
    private Integer durationInYears;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer; // Link loan to a customer
}