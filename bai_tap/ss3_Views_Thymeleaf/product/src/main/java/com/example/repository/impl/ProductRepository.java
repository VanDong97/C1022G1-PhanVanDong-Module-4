package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    public static List<Product> productList;
    static {
        productList = new ArrayList<Product>(){{
            add(new Product(1,"Audi 2",10000,"New","Join"));
            add(new Product(2,"Audi 3",20000,"New","Join"));
            add(new Product(3,"Sudi 4",30000,"New","Join"));
            add(new Product(4,"Audi 5",40000,"New","Join"));
        }};
    }

    @Override
    public List<Product> listAll(String productName) {
        if (productName == null){
            return productList;
        }
        List<Product> products = new ArrayList<>();
        for (Product p: productList) {
            if (p.getProductName().contains(productName)){
                products.add(p);
            }
        }
        return products;
    }

    @Override
    public void save(Product product) {
        product.setId(productList.size() + 1);
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product p: productList) {
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public void update( Product product) {
        for (Product p: productList) {
            if (product.getId() == p.getId()){
                p.setProductName(product.getProductName());
                p.setPrice(product.getPrice());
                p.setStatus(product.getStatus());
                p.setProduce(product.getProduce());
            }
        }
    }

    @Override
    public void remove(int id) {
        productList.remove(findById(id));
    }
}
