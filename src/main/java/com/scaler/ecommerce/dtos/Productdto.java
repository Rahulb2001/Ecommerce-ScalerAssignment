package com.scaler.ecommerce.dtos;


import com.scaler.ecommerce.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Productdto {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private Categorydto category;

    private String categoryName;


}
