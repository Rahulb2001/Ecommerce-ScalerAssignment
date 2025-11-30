package com.scaler.ecommerce.dtos;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakeStoreProductDto {

    private Long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private Double price;
}
