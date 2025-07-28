package com.bankmanagement.controller;

import com.bankmanagement.model.Customer;
import com.bankmanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController
 {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody Customer customer) {
        return customerService.registerCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

     @PostMapping("/login")
     public String login(@RequestParam String username, @RequestParam String password) {
         Optional<Customer> customer = customerService.login(username, password);
         if (customer.isPresent()) {
             return "Login successful!";
         } else {
             return "Invalid username or password!";
         }
     }

     @PostMapping("/logout")
     public String logout() {
         // Invalidate session (if using session-based auth)
         return "Logged out successfully!";
     }
}
