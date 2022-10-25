package com.ecommercecoop.springbootecommerce.dao;


import com.ecommercecoop.springbootecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductById(Long id);

    @RestResource(path = "/products-by-keyword")
    public List<Product> findByNameContains(@Param("keyword") String keyword);

    @Query("SELECT p FROM Product p WHERE p.units_in_stock > 0 ")
    public List<Product> findAvailableProducts();
}
