package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.Product;

public interface ProductService {

    public Iterable<Product> listAllProducts();

    public Product  getProductById(Integer id);

    public Product saveProduct(Product product);

    public void deleteProduct(Integer id);

}
