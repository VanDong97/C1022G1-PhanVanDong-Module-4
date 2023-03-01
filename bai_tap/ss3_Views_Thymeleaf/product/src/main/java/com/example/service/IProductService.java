package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> listAll(String productName);

    void save (Product product);

    Product findById(int id);

    void update(Product product);

    void remove(int id);
}
