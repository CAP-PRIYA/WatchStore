package com.watch.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watch.repository.OrdersRepository;
import com.watchApp.pojo.Orders;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrdersRepository orderRepository;

    @Autowired
    public OrderService(OrdersRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Get all orders by customer
    public List<Orders> getOrdersByCustomer(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    // Get order by ID
    public Optional<Orders> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    // Place a new order
    public Orders placeOrder(Orders order) {
        return orderRepository.save(order);
    }
}

