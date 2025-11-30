package com.scaler.ecommerce.services;

import com.scaler.ecommerce.dtos.FakeStoreProductDto;
import com.scaler.ecommerce.model.Category;
import com.scaler.ecommerce.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class FakeStoreServices implements IProductService {

    @Autowired
    RestTemplate restTemplate;


    @Override
    public Product getProductById(Long id) {

       ResponseEntity<FakeStoreProductDto> response =
                requestForEntity("https://fakestoreapi.com/products/{id}",
                        null,
                        FakeStoreProductDto.class,
                        HttpMethod.GET
                        ,id);

       FakeStoreProductDto fakeStoreProductDto = response.getBody();
        System.out.println(fakeStoreProductDto);

        log.info("getProductById:{}", fakeStoreProductDto);
        return from(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
//
//        FakeStoreProductDto[] fakeStoreProductDtos =
//                restTemplate.getForObject("https://fakestoreapi.com/products/", FakeStoreProductDto[].class);

        ResponseEntity<FakeStoreProductDto[]> response=
                requestForEntity("https://fakestoreapi.com/products",
                        null,
                        FakeStoreProductDto[].class,
                        HttpMethod.GET
                        );

        FakeStoreProductDto[] dtoArray = response.getBody();

        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto1 : dtoArray) {
            products.add(from(fakeStoreProductDto1));
        }

        return products;

    }

    @Override
    public Product createProduct(Product product) {

//        restTemplate.postForLocation("https://fakestoreapi.com/products", product);

        FakeStoreProductDto fakeStoreProductDto = from(product);

        ResponseEntity<FakeStoreProductDto> response =
        requestForEntity("https://fakestoreapi.com/products",
                fakeStoreProductDto,
                FakeStoreProductDto.class,
                HttpMethod.POST);

        Product createdProduct = from(response.getBody());

        return createdProduct;
    }

    @Override
    public Product replaceProduct(Long id, Product input) {
        FakeStoreProductDto fakeStoreProductDtoInput = from(input);

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity =
                requestForEntity(
                        "https://fakestoreapi.com/products/{id}",
                        fakeStoreProductDtoInput,
                        FakeStoreProductDto.class,
                        HttpMethod.PUT,
                        id
                );

        return from(fakeStoreProductDtoResponseEntity.getBody());
    }

    @Override
    public Product deleteProduct(Long id) {

//        restTemplate.delete("\"https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class, id);

        ResponseEntity<FakeStoreProductDto> response=
                requestForEntity(
                        "https://fakestoreapi.com/products/{id}",
                        null,
                        FakeStoreProductDto.class,
                        HttpMethod.DELETE,
                        id
                );


        return from(response.getBody());
    }

    public Product from(FakeStoreProductDto  fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setName(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());

        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());

        product.setCategory(category);


        return product;


    }

    private FakeStoreProductDto from(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getName());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setImage(product.getImageUrl());
        if(product.getCategory() != null) {
            fakeStoreProductDto.setCategory(product.getCategory().getName());
        }
        return fakeStoreProductDto;
    }

    public <T> ResponseEntity<T> requestForEntity(
            String url,
            @Nullable Object request,
            Class<T> responseType,
            HttpMethod httpMethod,
            Object... uriVariables
    ) throws RestClientException {

        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor =
                restTemplate.responseEntityExtractor(responseType);

        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }



}
