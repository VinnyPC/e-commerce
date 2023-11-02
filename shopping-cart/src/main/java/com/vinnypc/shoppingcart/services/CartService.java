package com.vinnypc.shoppingcart.services;

import com.vinnypc.shoppingcart.entities.Cart;
import com.vinnypc.shoppingcart.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    public Cart update(Long id, Cart cart){
        Cart updated = cartRepository.findById(id).get();
        updated.setNome(cart.getNome());
        updated.setQuantidade(cart.getQuantidade());

        return cartRepository.save(updated);
    }

    public Cart delete(Long id){
        Cart produto = cartRepository.findById(id).get();
        cartRepository.deleteById(id);
        return produto;
    }

}
