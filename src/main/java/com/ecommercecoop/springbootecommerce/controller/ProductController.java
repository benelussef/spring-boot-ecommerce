package com.ecommercecoop.springbootecommerce.controller;


import com.ecommercecoop.springbootecommerce.entity.Product;
import com.ecommercecoop.springbootecommerce.entity.RawMaterial;
import com.ecommercecoop.springbootecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addRawMaterial/{id}")
    public void addRm(@RequestBody RawMaterial rm, @PathVariable Long id){
        productService.addRowMaterial(rm, id);
    }

    @PostMapping("/addProduct/{id}")
    public void addCategory(@RequestBody Product p, @PathVariable Long id){
        productService.addProduct(p, id);
    }
    @GetMapping("/availableProducts")
    public List<Product> getAvailableProducts() {
        return productService.findAvailableProducts();
    }
}
