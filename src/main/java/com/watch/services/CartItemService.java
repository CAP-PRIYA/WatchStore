package com.watch.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watch.repository.CartItemsRepository;
import com.watch.repository.CustomersRepository;
import com.watch.repository.WatchesRepository;
import com.watchApp.pojo.CartItems;
import com.watchApp.pojo.Customers;
import com.watchApp.pojo.Watches;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {

    private final CartItemsRepository cartItemRepository;
    private final CustomersRepository customersRepository;
    private final WatchesRepository watchesRepository;

    @Autowired
    public CartItemService(CartItemsRepository cartItemRepository,CustomersRepository customersRepository,WatchesRepository watchesRepository) {
        this.cartItemRepository = cartItemRepository;
        this.customersRepository=customersRepository;
        this.watchesRepository=watchesRepository;
    }
    
    // Get all cart items for a customer
    public List<CartItems> getCartItemsByCustomer(Long customerId) {
        return cartItemRepository.findByCustomerId(customerId);
    }

    // Get specific cart item
    public Optional<CartItems> getCartItem(Long customerId, Long watchId) {	
        return cartItemRepository.findByCustomerIdAndWatchId(customerId, watchId);
    }

    // Add a watch to the cart
    public CartItems addToCart(CartItems cartItem,long customerId,long watchId) {
    	Customers customer=customersRepository.findById(customerId).get();
    	cartItem.setCustomer(customer);
    	Watches customerWatch=watchesRepository.findById(watchId).get();
    	cartItem.setWatch(customerWatch);
        return cartItemRepository.save(cartItem);
    }

    // Update cart item quantity
    public CartItems updateCartItem(Long id, CartItems updatedCartItem) {
        if (cartItemRepository.existsById(id)) {
            updatedCartItem.setId(id);
            return cartItemRepository.save(updatedCartItem);
        }
        return null;
    }

    // delete by id
	public void deleteCartItem(Long id) {
		cartItemRepository.deleteById(id);
	}
}

