package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.Product;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PaginationAndSortingTest {
    
    @Autowired
    private ProductsRepository repository;

    @Test
    void pagination() {
        Page<Product> page = repository.findAll(PageRequest.of(0, 3));
        List<Product> products = page.getContent();
        products.forEach(p -> System.out.println(p));
    }

    @Test
	public void isActiveSort() {
	    List<Product> page = repository.findByActive( true, Sort.unsorted() );
	    System.out.println(page);
	    
	}

    @BeforeAll
	public void populateDb() {
		Product product1 = new Product("SKU001", "Product 1", "Description for Product 1", new BigDecimal("10.00"), true);
        Product product2 = new Product("SKU00", "Product 2", "Description for Product 2", new BigDecimal("10.00"), false);
        Product product3 = new Product("SKU003", "Product 3", "Description for Product 3", new BigDecimal("30.00"), true);
		repository.saveAll( List.of(product1, product2, product3) );
	}

	@AfterAll
	public void dePopulateDb() {
		repository.deleteAll();
	}
}
