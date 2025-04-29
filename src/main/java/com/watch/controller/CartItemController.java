package com.watch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.watch.services.CartItemService;
import com.watchApp.pojo.CartItems;

@RestController
@RequestMapping("/api/cart")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/{customerId}/add/{watchId}")
    public CartItems addToCart(@PathVariable Long customerId, @PathVariable Long watchId, @RequestBody CartItems item) {
        return cartItemService.addToCart(item,customerId,watchId);
    }

    @GetMapping("/{customerId}")
    public List<CartItems> getCartItems(@PathVariable Long customerId) {
        return cartItemService.getCartItemsByCustomer(customerId);
    }

    @PatchMapping("/{id}")
    public CartItems updateCartItem(@PathVariable Long id, @RequestBody CartItems updatedItem) {
        return cartItemService.updateCartItem(id, updatedItem);
    }
}
