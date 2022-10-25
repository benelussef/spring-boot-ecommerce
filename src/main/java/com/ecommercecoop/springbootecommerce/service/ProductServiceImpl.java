package com.ecommercecoop.springbootecommerce.service;

import com.ecommercecoop.springbootecommerce.dao.ProductCategoryRepository;
import com.ecommercecoop.springbootecommerce.dao.ProductRepository;
import com.ecommercecoop.springbootecommerce.dao.RawMaterialRepository;
import com.ecommercecoop.springbootecommerce.entity.Product;
import com.ecommercecoop.springbootecommerce.entity.ProductCategory;
import com.ecommercecoop.springbootecommerce.entity.RawMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    RawMaterialRepository rawMaterialRepository;
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Transactional
    @Override
    public void addRowMaterial(RawMaterial rm, Long id) {
        rawMaterialRepository.saveAndFlush(rm);
        Product p = productRepository.findProductById(id);
        p.addRawMaterial(rm);
    }

    @Transactional
    @Override
    public void addProduct(Product product, Long id) {
        ProductCategory productCategory = productCategoryRepository.findProductCategoryById(id);
        product.setCategory(productCategory);
        productRepository.save(product);
    }

    @Override
    @Transactional
    public List<Product> findAvailableProducts() {
        return productRepository.findAvailableProducts();
    }
}
