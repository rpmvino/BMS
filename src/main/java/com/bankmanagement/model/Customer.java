
package com.bankmanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String username; // Unique
    private String password;
    private String address;
    private String state;
    private String country;
    private String email; // Unique
    private String pan;
    private String contactNo;
    private String accountType;
}
