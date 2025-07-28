
package com.bankmanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private Double amount;
    private String type; // DEPOSIT or WITHDRAWAL
}