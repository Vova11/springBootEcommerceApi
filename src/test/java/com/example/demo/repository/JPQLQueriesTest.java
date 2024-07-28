package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Product;

@SpringBootTest
public class JPQLQueriesTest {

    @Autowired
    private ProductsRepository repository;

    @Test
    public void findByNameOrDescription() {
        //Fail
        List<Product> products = repository.findByNameOrDescriptionJpqlIndexParam("Produckt1","Psasa");
        products.forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

}
