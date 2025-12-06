package com.scaler.ecommerce.repos;

import com.scaler.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findAllById(Long id);

    Product save(Product product);

    void deleteById(Long id);

    @Query("SELECT p.name FROM products p WHERE p.price = :price")
    String getmetheprodcutwhosepriceisgreaterorequal(Double price);







}
