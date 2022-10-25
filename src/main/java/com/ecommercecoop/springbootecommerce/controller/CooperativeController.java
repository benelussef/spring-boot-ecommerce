package com.ecommercecoop.springbootecommerce.controller;


import com.ecommercecoop.springbootecommerce.entity.Product;
import com.ecommercecoop.springbootecommerce.service.CooperativeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cooperatives")
public class CooperativeController {
    private CooperativeService cooperativeService;
    public CooperativeController(CooperativeService cooperativeService) {
        this.cooperativeService = cooperativeService;
    }
    @PostMapping("/addProductToCooperative/{id}")
    public void addProduct(@RequestBody Product p, @PathVariable int id){
        cooperativeService.addProduct(p, id);
    }
}
