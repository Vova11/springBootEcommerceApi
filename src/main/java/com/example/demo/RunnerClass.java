package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.example.demo.repository.ProductsRepository;

public class RunnerClass implements CommandLineRunner{

    @Autowired
    ProductsRepository repo;
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Ruuniiiiii");
        System.out.println("Ruuniiiiii");
        System.out.println("Ruuniiiiii");
        System.out.println("Ruuniiiiii");
        System.out.println("Ruuniiiiii");
        System.out.println("Ruuniiiiii");
    }

}
