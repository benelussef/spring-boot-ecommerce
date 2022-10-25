package com.ecommercecoop.springbootecommerce.service;

import com.ecommercecoop.springbootecommerce.dao.RegionRepository;
import com.ecommercecoop.springbootecommerce.entity.Cooperative;
import com.ecommercecoop.springbootecommerce.entity.RawMaterial;
import com.ecommercecoop.springbootecommerce.entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl implements RegionService{
    @Autowired
    RegionRepository regionRepository;
    @Override
    public void addCooperative(Cooperative cooperative, int id) {
        Region region = regionRepository.findRegionById(id);
        region.addCooperative(cooperative);
        regionRepository.save(region);
    }

    @Override
    public void addRawMaterial(RawMaterial rm, int id) {
        Region region = regionRepository.findRegionById(id);
        region.addRawMaterial(rm);
        regionRepository.save(region);
    }
}
