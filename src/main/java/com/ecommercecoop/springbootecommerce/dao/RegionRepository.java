package com.ecommercecoop.springbootecommerce.dao;

import com.ecommercecoop.springbootecommerce.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Integer> {
    Region findRegionById(int id);
}
