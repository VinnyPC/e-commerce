package com.vinnypc.shoppingcart.controllers;

import com.vinnypc.shoppingcart.entities.Cart;
import com.vinnypc.shoppingcart.repositories.CartRepository;
import com.vinnypc.shoppingcart.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartService cartService;

    @GetMapping
    private List<Cart> getAll(){
        return cartRepository.findAll();
    };

    @GetMapping("/{id}")
    private Optional<Cart> getById(@PathVariable("id") Long id){
        return cartRepository.findById(id);
    };

    @PostMapping
    private Cart create(@RequestBody Cart cart ){
        return cartRepository.save(cart);
    }

    @PutMapping("/{id}")
    public Cart update(@PathVariable("id") Long id, @RequestBody Cart cart){
        return cartService.update(id, cart);
    }

    @DeleteMapping("/{id}")
    public Cart delete(@PathVariable("id") Long id){
        return cartService.delete(id);
    }


}
