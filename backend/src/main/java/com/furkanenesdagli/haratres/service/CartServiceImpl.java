package com.furkanenesdagli.haratres.service;

import com.furkanenesdagli.haratres.dto.CartDto;
import com.furkanenesdagli.haratres.dto.ProductDto;
import com.furkanenesdagli.haratres.mapper.CartMapper;
import com.furkanenesdagli.haratres.mapper.ProductMapper;
import com.furkanenesdagli.haratres.model.Cart;
import com.furkanenesdagli.haratres.model.Product;
import com.furkanenesdagli.haratres.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;
    private final ProductService productService;

    public CartServiceImpl(CartRepository repository,ProductService productService){
        this.cartRepository = repository;
        this.productService = productService;
    }

    @Override
    public List<CartDto> getAllCart() {
        return cartRepository.findAll()
                .stream()
                .map(CartMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean addToCart(Long productId, Integer quantity) {
        Product product = productService.getProductModelByid(productId);
        if (product !=null && quantity <= product.getStock()){
            Cart cart = new Cart();
            cart.setProduct(product);
            cart.setQuantity(quantity);
            try {
                cartRepository.save(cart);
            }catch (Exception e){
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean deleteToCart(Long id, Integer quantity) {
        Cart cart = cartRepository.findById(id).orElse(null);
        if (cart != null){
            try {
                Integer cartQuantity = cart.getQuantity();

                if (quantity < cartQuantity){
                    cart.setQuantity(cartQuantity-quantity);
                    cartRepository.save(cart);
                    return Boolean.TRUE;
                }else if (quantity.equals(cartQuantity)){
                    cartRepository.delete(cart);
                    return Boolean.TRUE;
                }else {
                    return Boolean.FALSE;
                }
            }catch (Exception e){
                return Boolean.FALSE;
            }
        }
        return Boolean.FALSE;
    }
}
