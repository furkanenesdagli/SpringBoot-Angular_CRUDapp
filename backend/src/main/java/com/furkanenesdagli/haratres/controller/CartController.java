package com.furkanenesdagli.haratres.controller;

import com.furkanenesdagli.haratres.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    //POST  /api/v1/carts?productId=7&quantity=8

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestParam Long productId, @RequestParam Integer quantity) {
        if (cartService.addToCart(productId, quantity))
            return ResponseEntity.ok().build();

        return ResponseEntity.badRequest().build();
    }

    //DELETE  /api/v1/carts/7?quantity=8

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteToCart(@PathVariable Long id, @RequestParam Integer quantity){
        if (cartService.deleteToCart(id,quantity))
            return ResponseEntity.ok().build();

        return ResponseEntity.badRequest().build();
    }

    //GET //POST  /api/v1/carts

    @GetMapping
    public ResponseEntity<?> getCarts() {
        return ResponseEntity.ok(cartService.getAllCart());
    }


}
