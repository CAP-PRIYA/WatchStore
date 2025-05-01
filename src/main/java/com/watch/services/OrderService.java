package com.watch.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watch.repository.CustomersRepository;
import com.watch.repository.OrdersRepository;
import com.watch.repository.WatchesRepository;
import com.watchApp.pojo.Customers;
import com.watchApp.pojo.Orders;
import com.watchApp.pojo.Watches;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrdersRepository orderRepository;
    
    private final CustomersRepository customersRepository;

    private final WatchesRepository watchesRepository;
    
    @Autowired
    public OrderService(OrdersRepository orderRepository,CustomersRepository customersRepository,WatchesRepository watchesRepository) {
        this.orderRepository = orderRepository;
        this.customersRepository=customersRepository;
        this.watchesRepository=watchesRepository;
    }

    // Get all orders by customer
    public List<Orders> getOrdersByCustomer(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    // Get order by ID
    public Optional<Orders> getOrderById(Long id) {
    	
    	Optional<Orders> orderDetails=orderRepository.findById(id); 
    	if (!orderDetails.isPresent()) {
            throw new RuntimeException("Invalid Order Id");
        }
        return orderDetails;
    }

    // Place a new order
    public Orders placeOrder(Orders order) {
    	 // Fetch the customer by customer_id 
        Optional<Customers> customerOpt = customersRepository.findById(order.getCustomer().getId());
        if (!customerOpt.isPresent()) {
            throw new RuntimeException("Customer not found");
        }

        Customers customer = customerOpt.get();
        order.setCustomer(customer);  // Set the customer in the order object
        
        
        Optional<Watches> watch=watchesRepository.findById(order.getWatch().getId()); 
    	if (!watch.isPresent()) {
            throw new RuntimeException("Invalid watch Id");
        }
    	
    	Watches watchDetails=watch.get();
    	order.setWatch(watchDetails);

        // Set the order date to the current date if not provided
        if (order.getOrderDate() == null) {
            order.setOrderDate(LocalDate.now().atStartOfDay());
        }
        return orderRepository.save(order);
    }
}

