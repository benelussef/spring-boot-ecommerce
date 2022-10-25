package com.ecommercecoop.springbootecommerce.dao;

import com.ecommercecoop.springbootecommerce.entity.Cooperative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CooperativeRepository extends JpaRepository<Cooperative, Integer> {
    Cooperative findCooperativeById(int id);
}
