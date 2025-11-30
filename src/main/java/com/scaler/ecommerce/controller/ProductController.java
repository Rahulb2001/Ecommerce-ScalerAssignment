package com.scaler.ecommerce.controller;


import com.scaler.ecommerce.dtos.Categorydto;
import com.scaler.ecommerce.dtos.Productdto;
import com.scaler.ecommerce.model.Product;
import com.scaler.ecommerce.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    IProductService iProductService;

    //Getmapping
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
    public boolean deleteProduct(Long id) {

        return true;

    }


    public Productdto from(Product product) {

        Productdto dto = new Productdto();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        dto.setImageUrl(product.getImageUrl());
        dto.setCategoryName(product.getCategory().getName());


        System.out.println(product);


        Categorydto categorydto = new Categorydto();
        if (product.getCategory() != null) {
            categorydto.setName(product.getCategory().getName());
            categorydto.setDescription(product.getCategory().getDescription());
            categorydto.setId(product.getCategory().getId());

        }
        System.out.println(categorydto);

//        dto.setCategoryName(product.getCategory().getName());

        return dto;


    }


}
