package com.ecommercecoop.springbootecommerce.service;

import com.ecommercecoop.springbootecommerce.dao.CooperativeRepository;
import com.ecommercecoop.springbootecommerce.entity.Cooperative;
import com.ecommercecoop.springbootecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CooperativeServiceImpl implements CooperativeService{

    @Autowired
    CooperativeRepository cooperativeRepository;
    @Override
    public void addProduct(Product p, int id) {
        Cooperative cooperative = cooperativeRepository.findCooperativeById(id);
        cooperative.addProduct(p);
        cooperativeRepository.save(cooperative);
    }
}
