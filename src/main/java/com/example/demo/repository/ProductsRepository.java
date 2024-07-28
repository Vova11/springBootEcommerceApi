package com.example.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Product;

public interface ProductsRepository extends BaseRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE " +
           "p.name LIKE %:query% OR p.description LIKE %:query%")
    List<Product> searchProducts(String query);

    Product findByName(String name);

    List<Product> findByNameOrDescription(String name, String description);

    List<Product> findByNameAndDescription(String name, String description);

    Product findDistinctByName(String name);

    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product> findByPriceLessThan(BigDecimal price);

    List<Product> findByNameContaining(String name);

    List<Product> findByNameLike(String name);

    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    List<Product> findByDateCreated(LocalDateTime startDate);

    // JPQL
    @Query("select p from Product p where p.name = ?1 or p.description = ?2")
    List<Product> findByNameOrDescriptionJpqlIndexParam(String name, String description);

    Page<Product> findAll(Pageable pageable);

    List<Product> findByActive(Boolean active, Sort sort);

}
