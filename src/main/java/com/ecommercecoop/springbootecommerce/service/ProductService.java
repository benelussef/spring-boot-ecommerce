package com.ecommercecoop.springbootecommerce.service;
import com.ecommercecoop.springbootecommerce.entity.Product;
import com.ecommercecoop.springbootecommerce.entity.ProductCategory;
import com.ecommercecoop.springbootecommerce.entity.RawMaterial;

import java.util.List;


public interface ProductService {
    public void addRowMaterial(RawMaterial rm, Long id);
    public void addProduct(Product product, Long id);
    public List<Product> findAvailableProducts();
}
