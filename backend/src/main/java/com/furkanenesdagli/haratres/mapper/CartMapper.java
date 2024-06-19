package com.furkanenesdagli.haratres.mapper;

import com.furkanenesdagli.haratres.dto.CartDto;
import com.furkanenesdagli.haratres.dto.ProductDto;
import com.furkanenesdagli.haratres.model.Cart;
import com.furkanenesdagli.haratres.model.Product;

public class CartMapper {

    public static CartDto entityToDto(Cart cart) {
        CartDto dto = new CartDto();
        dto.setId(cart.getId());
        dto.setProduct(ProductMapper.entityToDto(cart.getProduct()));
        dto.setQuantity(cart.getQuantity());
        return dto;
    }
}
