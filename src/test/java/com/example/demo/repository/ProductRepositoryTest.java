package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Product;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductsRepository repository;

    @Test
    void saveMethod() {
        Product product = new Product();
        product.setName("Produkt 2");
        product.setDescription("Produkt 1 description");
        product.setSku("101ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        Product savedObject = repository.save(product);
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
    void updateUsingSaveMethod() {
        Product productFound = repository.findById(1L).get();
        productFound.setName("Udpdated Produkt 1");
        repository.save(productFound);
        System.out.println("hello");
    }

    @Test
    void findById() {
        Product product = repository.findById(1L).get();
        System.out.println(product);
    }

    @Test
    void saveAllMethod() {
        Product product2 = new Product();
        product2.setName("Produckt4");
        product2.setDescription("Productct 2 description");
        product2.setSku("102ABC");
        product2.setPrice(new BigDecimal(200));
        product2.setActive(true);

        Product product3 = new Product();
        product3.setName("Produckt6");
        product3.setDescription("Productct 2 description");
        product3.setSku("102ABC");
        product3.setPrice(new BigDecimal(300));
        product3.setActive(true);

        repository.saveAll(List.of(product2, product3));
    }

    @Test
    void findAll() {
        List<Product> products = repository.findAll();
        System.out.println(products.size());
        products.forEach(System.out::println);
    }

    @Test
    void deleteById() {
        repository.deleteById(1L);
    }

    @Test
    void deleteMethodByEntitity() {
        Product productFound = repository.findById(4L).get();
        repository.delete(productFound);
    }

    @Test
    void deleteAll() {
        repository.deleteAll();
    }

    @Test
    void deleteAllEntities() {
        Product productFound1 = repository.findById(5L).get();
        Product productFound2 = repository.findById(6L).get();
        repository.deleteAll(List.of(productFound1, productFound2));
    }

    @Test
    void deleteAllById() {
        Product productFound1 = repository.findById(7L).get();
        Product productFound2 = repository.findById(8L).get();
        repository.deleteAllById(List.of(productFound1.getId(), productFound2.getId()));
    }

    @Test
    void existsById() {
        Product productFound1 = repository.findById(9L).get();
        boolean exists = repository.existsById(productFound1.getId());
        System.out.println("Product: " + exists);
    }

}
