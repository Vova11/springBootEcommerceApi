package com.example.demo.repository;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductCategory;

import jakarta.transaction.Transactional;

@SpringBootTest
public class ProductCategoryRepositoryTest {

     @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    void saveProductCategory(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("books");
        productCategory.setCategoryDescription("books description");

        Product product1 = new Product();
        product1.setName("Core Java");
        product1.setPrice(new BigDecimal(1000));
        product1.setSku("ABCD");
        product1.setActive(true);
        product1.setCategory(productCategory);
        productCategory.getProducts().add(product1);

        Product product2 = new Product();
        product2.setName("Effective Java");
        product2.setPrice(new BigDecimal(2000));
        product2.setSku("ABCDE");
        product2.setActive(true);
        product2.setCategory(productCategory);
        productCategory.getProducts().add(product2);

        productCategoryRepository.save(productCategory);
    }


    @Test
    @Transactional
    void fetchProductCategory(){
        ProductCategory category = productCategoryRepository.findById(1L).get();
        System.out.println(category);
    }


}


