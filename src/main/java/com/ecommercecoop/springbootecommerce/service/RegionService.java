package com.ecommercecoop.springbootecommerce.service;

import com.ecommercecoop.springbootecommerce.entity.Cooperative;
import com.ecommercecoop.springbootecommerce.entity.RawMaterial;

public interface RegionService{
    public void addCooperative(Cooperative cooperative, int id);
    public void addRawMaterial(RawMaterial rm, int id);
}
