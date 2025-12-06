package com.scaler.ecommerce.services;

import com.scaler.ecommerce.model.Product;
import com.scaler.ecommerce.repos.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("databaseStorageProductService")
@Slf4j
public class StorageProductService implements IProductService {

    @Autowired
    ProductRepository productRepository;


    @Override
    public Product getProductById(Long id) {

        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        }

        return null;
    }

    @Override
    public List<Product> getAllProducts() {

        List<Product> products = productRepository.findAll();
        if (products != null) {
            return products;
        }
        return null;
    }

    @Override
    public Product createProduct(Product product) {

        log.info("Creating product with id {}", product.getId());
        log.info("Creating product with name {}", product.getName());

        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        } else {
            Product pro = productRepository.save(product);
            return pro;

        }

    }

    @Override
    public Boolean deleteProduct(Long id) {

        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Product replaceProduct(Long id, Product input) {

        if (productRepository.existsById(id)) {
            input.setId(id);
            Product updatedProduct = productRepository.save(input);
            return updatedProduct;
        }
        return null;
    }
}
