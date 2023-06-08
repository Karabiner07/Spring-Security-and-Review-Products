package com.karabiner.securityproduct.review.controller;

import com.karabiner.securityproduct.review.entity.Product;
import com.karabiner.securityproduct.review.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);

    }
    @GetMapping("/products")
    public List<Product> fetchProductList(){
        return productService.fetchProductList();

    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long productId){
        return productService.fetchProductById(productId);
    }

    @GetMapping("/products/name/{name}")
    public List<Product> fetchAllByProductName(@PathVariable("name") String productName){
        return productService.fetchAllByProductName(productName);
    }

    @GetMapping("/products/brand/{brand}")
    public List<Product> fetchAllByProductBrand(@PathVariable("brand") String productBrand){
        return productService.fetchAllByProductBrand(productBrand);
    }

    @GetMapping("/products/code/{code}")
    public Product fetchProductByCode(@PathVariable("code") String productCode){
        return productService.fetchProductByCode(productCode);
    }

}
