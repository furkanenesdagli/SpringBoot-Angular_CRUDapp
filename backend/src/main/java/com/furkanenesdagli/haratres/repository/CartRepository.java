package com.furkanenesdagli.haratres.repository;

import com.furkanenesdagli.haratres.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
