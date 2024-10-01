package com.georgievl.thymeleafproject.services;

import com.georgievl.thymeleafproject.domain.Product;

import java.util.List;

public interface ProductService {
    Product getProduct(Integer id);
    List<Product> getAllProducts();
}
