package com.ecommercecoop.springbootecommerce.controller;

import com.ecommercecoop.springbootecommerce.entity.Cooperative;
import com.ecommercecoop.springbootecommerce.entity.RawMaterial;
import com.ecommercecoop.springbootecommerce.service.RegionService;
import net.bytebuddy.pool.TypePool;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/regions")
public class RegionController {
    private RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }
    @PostMapping("/addCooperative/{id}")
    public void addCoop(@RequestBody Cooperative cooperative, @PathVariable int id){
        regionService.addCooperative(cooperative, id);
    }
    @PostMapping("/addRawMaterial/{id}")
    public void addRawMaterial(@RequestBody RawMaterial rm, @PathVariable int id){
        regionService.addRawMaterial(rm, id);
    }
}
