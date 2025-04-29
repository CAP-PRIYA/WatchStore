package com.watch.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watch.repository.CustomersRepository;
import com.watchApp.pojo.Customers;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomersRepository customerRepository;

    @Autowired
    public CustomerService(CustomersRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Get all customers
    public List<Customers> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get customer by email
    public Optional<Customers> getCustomerByEmail(String email) {
        return Optional.ofNullable(customerRepository.findByEmail(email));
    }

    // Get customer by ID
    public Optional<Customers> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Register new customer
    public Customers addCustomer(Customers customer) {
        return customerRepository.save(customer);
    }

    // Update customer profile
    public Customers updateCustomer(Long id, Customers updatedCustomer) {
        if (customerRepository.existsById(id)) {
            updatedCustomer.setId(id);
            return customerRepository.save(updatedCustomer);
        }
        return null;
    }
}

