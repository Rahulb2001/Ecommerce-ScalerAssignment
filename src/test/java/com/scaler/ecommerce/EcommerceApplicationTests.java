package com.scaler.ecommerce;

import com.scaler.ecommerce.repos.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EcommerceApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    @Transactional
    void test1(){
        System.out.println(productRepository.getmetheprodcutwhosepriceisgreaterorequal(100D));
    }


}
