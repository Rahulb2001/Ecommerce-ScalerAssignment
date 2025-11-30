package com.scaler.ecommerce.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product extends BaseModel {

    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private Category category;

}
