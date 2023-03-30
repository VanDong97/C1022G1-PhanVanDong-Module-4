package com.example.cart.repository;

import com.example.cart.model.Cart;
import com.example.cart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProductRepository extends JpaRepository<Cart,Integer> {

    Optional<Product> findById(Long id);
}
