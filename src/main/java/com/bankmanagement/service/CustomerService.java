package com.bankmanagement.service;

import com.bankmanagement.model.Customer;
import com.bankmanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Customer registerCustomer(Customer customer) {
        logger.info("Registering customer with username: {}", customer.getUsername());
        // Check for duplicate username
        if (customerRepository.findByUsername(customer.getUsername().toLowerCase()).isPresent()) {
            throw new IllegalArgumentException("Username already exists!");
        }
        // Encrypt the password before saving
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customer) {
        Customer existingCustomer = customerRepository.findById(id).orElseThrow();
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setContactNo(customer.getContactNo());
        existingCustomer.setAddress(customer.getAddress());
        return customerRepository.save(existingCustomer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> login(String username, String password) {
        logger.info("Attempting login for username: {}", username);
        Optional<Customer> customer = customerRepository.findByUsername(username);
        if (customer.isPresent() && passwordEncoder.matches(password, customer.get().getPassword())) {
            logger.info("Login successful for username: {}", username);
            return customer;
        }
        logger.warn("Login failed for username: {}", username);
        return Optional.empty();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }
}
