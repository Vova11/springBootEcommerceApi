package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductsRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImp implements ProductService{

    private ProductsRepository repository;
    
    public ProductServiceImp(ProductsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> searchProducts(String query) {
        List<Product> products = repository.searchProducts(query);
        return products;
    }

}
