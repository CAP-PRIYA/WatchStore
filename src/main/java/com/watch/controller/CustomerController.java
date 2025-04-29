package com.watch.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.watch.services.CustomerService;
import com.watchApp.pojo.Customers;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customers registerCustomer(@RequestBody Customers customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping("/{id}")
    public Optional<Customers> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PatchMapping("/{id}")
    public Customers updateCustomer(@PathVariable Long id, @RequestBody Customers customer) {
        return customerService.updateCustomer(id, customer);
    }
}

