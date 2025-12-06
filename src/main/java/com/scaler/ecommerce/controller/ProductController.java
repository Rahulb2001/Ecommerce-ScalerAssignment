package com.scaler.ecommerce.controller;


import com.scaler.ecommerce.dtos.Categorydto;
import com.scaler.ecommerce.dtos.Productdto;
import com.scaler.ecommerce.exception.NotFoundException;
import com.scaler.ecommerce.model.Product;
import com.scaler.ecommerce.services.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products/")
@Slf4j
public class ProductController {

    @Autowired
    @Qualifier("databaseStorageProductService")
    IProductService iProductService;

    //Getmapping
    @GetMapping("{id}")
    public Productdto getProduct(@PathVariable Long id) {

        Product product = iProductService.getProductById(id);

        if(product==null){
            throw new NotFoundException("Product Not Found");
        }

        return from(product);
    }

    @GetMapping()
    public List<Productdto> getAllProducts() {

        List<Product> products = iProductService.getAllProducts();

        List<Productdto> productDtos = new ArrayList<>();
        for (Product product : products) {
            productDtos.add(from(product));
        }

        return productDtos;
    }


    @PostMapping()
    public Productdto createProduct(@RequestBody Product product) {

        log.info("Creating product {}", product);
        Product createdProduct = iProductService.createProduct(product);

        return from(createdProduct);
    }


    @DeleteMapping("{id}")
    public boolean deleteProduct(@PathVariable Long id) {

        return iProductService.deleteProduct(id);

    }

    @PutMapping("{id}")
    public Productdto updateProduct(@PathVariable Long id, @RequestBody Product product) {

        Product updatedProduct = iProductService.replaceProduct(id, product);

        return from(updatedProduct);
    }


    public Productdto from(Product product) {

        log.info("from {}", product);
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

//            dto.setCategory(categorydto);
            dto.setCategoryName(product.getCategory().getName());
        } else {
            dto.setCategory(null);
            dto.setCategoryName(null);
        }
        System.out.println(dto.getCategory());

//        dto.setCategoryName(product.getCategory().getName());

        log.info("Converted Product to Productdto: {}", dto);

        return dto;
    }


}