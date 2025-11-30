package com.scaler.ecommerce.services;

import com.scaler.ecommerce.model.Product;

import java.util.List;

public interface IProductService {

    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Boolean deleteProduct(Long id);

    public Product replaceProduct(Long id, Product input) ;

    }
