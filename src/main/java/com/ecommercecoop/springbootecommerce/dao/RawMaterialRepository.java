package com.ecommercecoop.springbootecommerce.dao;

import com.ecommercecoop.springbootecommerce.entity.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawMaterialRepository extends JpaRepository<RawMaterial, Integer> {
}
