package com.watch.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.watchApp.pojo.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {


    // Get orders by customer
    List<Orders> findByCustomerId(Long customerId);

    // Optional: Get orders within a date range
    List<Orders> findByOrderDateBetween(LocalDateTime start, LocalDateTime end);
}
