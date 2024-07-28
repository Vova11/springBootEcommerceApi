package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Product;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductsRepository repository;

    @Test
    public void findByName() {
        Product product = repository.findByName("Produckt3");
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    public void findByNameOrDescription() {
        List<Product> products = repository.findByNameOrDescription("Produckt3", "Productct 2 description");
        products.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    public void findByNameAndDescription() {
        //Fail
        List<Product> products = repository.findByNameAndDescription("Produckt", "Productct 2 description");
        // Assert that the list is empty
        assertTrue(products.isEmpty(), "The list of products should be empty");
    }

    @Test
    public void findDistinctByName() {
        //Fail
        Product product = repository.findDistinctByName("Produckt3");
        System.out.println(product);
        // Assert that the product is null
        assertNotNull(product, "The product should be null since 'Produckt1' does not exist");
    }


    @Test
    public void findByPriceGreaterThan() {
        //Fail
        List<Product> products = repository.findByPriceGreaterThan(new BigDecimal(100));
        products.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
        // If the list is empty, assertTrue should pass
        assertTrue(products.isEmpty(), "The product list should be empty if no products are found with price greater than 100");

        // If the list is not empty, assertFalse should pass
        assertFalse(products.isEmpty(), "The product list should not be empty if products are found with price greater than 100");
        
    }

    @Test
    public void findByPriceLessThan() {
        //Fail
        List<Product> products = repository.findByPriceLessThan(new BigDecimal(100));
        products.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    public void findByPNameContaining() {
        //Fail
        List<Product> products = repository.findByNameContaining("Produckt3");
        products.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    public void findByNameLike() {
        //Fail
        List<Product> products = repository.findByNameLike("Produckt3");
        products.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }


    @Test
    public void priceBetween() {
        //Fail
        List<Product> products = repository.findByPriceBetween(new BigDecimal(100), new BigDecimal(200));
        products.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
    



}
