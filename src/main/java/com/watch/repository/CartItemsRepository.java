package com.watch.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.watchApp.pojo.CartItems;


public interface  CartItemsRepository extends JpaRepository<CartItems, Long> {

    // Get all items in a customer's cart
    List<CartItems> findByCustomerId(Long customerId);

    // Get specific cart item for a customer and watch
    Optional<CartItems> findByCustomerIdAndWatchId(Long customerId, Long watchId);

    // Delete a specific watch from a customer's cart
    void deleteByCustomerIdAndWatchId(Long customerId, Long watchId);
}
