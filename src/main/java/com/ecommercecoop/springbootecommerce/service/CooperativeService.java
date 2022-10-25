package com.ecommercecoop.springbootecommerce.service;

import com.ecommercecoop.springbootecommerce.dao.CooperativeRepository;
import com.ecommercecoop.springbootecommerce.entity.Product;

public interface CooperativeService {
    public void addProduct(Product p, int id);
}
