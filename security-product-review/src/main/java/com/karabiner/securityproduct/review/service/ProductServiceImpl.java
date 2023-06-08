package com.karabiner.securityproduct.review.service;

import com.karabiner.securityproduct.review.entity.Product;
import com.karabiner.securityproduct.review.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> fetchProductList() {
        return productRepository.findAll();
    }

    @Override
    public Product fetchProductById(Long productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public List<Product> fetchAllByProductName(String productName) {
        return productRepository.findAllByProductName(productName);
    }

    @Override
    public List<Product> fetchAllByProductBrand(String productBrand) {
        return productRepository.findAllByProductBrand(productBrand);
    }

    @Override
    public Product fetchProductByCode(String productCode) {
        return productRepository.findByProductCode(productCode);
    }


}
