package com.karabiner.securityproduct.review.service;

import com.karabiner.securityproduct.review.entity.Product;

import java.util.List;

public interface ProductService {
    public Product saveProduct(Product product);

    public List<Product> fetchProductList();

    public Product fetchProductById(Long productId);

    public List<Product> fetchAllByProductName(String productName);

    public List<Product> fetchAllByProductBrand(String productBrand);

    public Product fetchProductByCode(String productCode);
}
