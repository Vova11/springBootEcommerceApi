package com.example.demo.repository;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductVariant;

@SpringBootTest
public class ProductVariantRepositoryTest {

    @Autowired
    private ProductsRepository repository;


    @Test
    void saveMethod() {
        
        Product product = new Product();
        product.setName("Produckt 1");
        product.setDescription("Produkt 1 description");
        product.setSku("Z89aa5");
        product.setPrice(new BigDecimal(40));
        product.setActive(true);

        ProductVariant pv1 = new ProductVariant();
        pv1.setVariant("small");
        pv1.setStock(20);
        pv1.setProduct(product);
        product.getProductVariants().add(pv1);
        
        ProductVariant pv2 = new ProductVariant();
        pv2.setVariant("medium");
        pv2.setStock(5);
        pv2.setProduct(product);
        product.getProductVariants().add(pv2);

        repository.save(product);


        

        
        
    
        
        // Product product = new Product();
        // product.setName("Produkt 2");
        // product.setDescription("Produkt 1 description");
        // product.setSku("123ABC");
        // product.setPrice(new BigDecimal(100));
        // product.setActive(true);

        // ProductVariant pv1 = new ProductVariant();
        // pv1.setType("small");
        // pv1.setStock(20);
        // ProductVariant pv2 = new ProductVariant();
        // pv2.setType("medium");
        // pv2.setStock(5);
        
        // Product saveProduct = productRepository.save(product);
        // saveProduct.getProductVariants().add(pv1);
        // saveProduct.getProductVariants().add(pv2);

    }

}
