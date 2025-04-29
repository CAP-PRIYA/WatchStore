package com.watch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.watchApp.pojo.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {

    // Find customer by email
    Customers findByEmail(String email);

    // Optional: Find customers by name (partial match)
    List<Customers> findByNameContainingIgnoreCase(String name);
}
