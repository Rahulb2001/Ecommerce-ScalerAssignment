package com.scaler.ecommerce.controller;


import com.scaler.ecommerce.dtos.Categorydto;
import com.scaler.ecommerce.dtos.Productdto;
import com.scaler.ecommerce.model.Product;
import com.scaler.ecommerce.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    IProductService iProductService;

    @GetMapping("/products/{id}")
    public Productdto getProduct(@PathVariable Long id) {

        Product product = iProductService.getProductById(id);

        return from(product);
    }

    @GetMapping("/products")
    public List<Productdto> getAllProducts() {

        List<Product> products = iProductService.getAllProducts();

        List<Productdto> productDtos = new ArrayList<>();
        for (Product product : products) {
            productDtos.add(from(product));
        }

        return productDtos;
    }

    @DeleteMapping("/product/{id}")
    public Productdto deleteProduct(@PathVariable Long id) {
        Product product = iProductService.deleteProduct(id);

        return from(product);

    }

    @PostMapping("/products")
    public Productdto createProduct(Product product) {
        Product createdProduct = iProductService.createProduct(product);
        return from(createdProduct);
    }

    @PutMapping("/products/{id}")
    public Productdto updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = iProductService.replaceProduct(id, product);
        return from(updatedProduct);
    }


    public Productdto from(Product product) {

        Productdto dto = new Productdto();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        dto.setImageUrl(product.getImageUrl());

        System.out.println(product);


        if (product.getCategory() != null) {
            Categorydto categorydto = new Categorydto();

            categorydto.setName(product.getCategory().getName());
            categorydto.setDescription(product.getCategory().getDescription());
            categorydto.setId(product.getCategory().getId());

            dto.setCategoryName(product.getCategory().getName());

            // dto.setCategory(categorydto);

            System.out.println(categorydto);

        } else {
            dto.setCategoryName(null);
        }

        return dto;
    }


}
