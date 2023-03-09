package com.example.cart.service;

import com.example.cart.model.Cart;
import com.example.cart.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Cart> findAll();
    Optional<Product> findById(Long id);
}
