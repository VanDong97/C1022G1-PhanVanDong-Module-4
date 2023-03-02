package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> listAll(String productName);

    void save(Product product);

    Product finById(Integer id);

    void update(Product product);

    void delete(Integer id);
}
