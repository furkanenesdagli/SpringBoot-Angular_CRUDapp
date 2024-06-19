package com.furkanenesdagli.haratres.service;

import com.furkanenesdagli.haratres.dto.CartDto;

import java.util.List;

public interface CartService {

    List<CartDto> getAllCart();
    Boolean addToCart(Long productId, Integer quantity);
    Boolean deleteToCart(Long id, Integer quantity);
}
