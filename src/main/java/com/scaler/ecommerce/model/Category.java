package com.scaler.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends  BaseModel {

    private String name;
    private String description;
    @OneToMany(mappedBy = "category")
    List<Product> products;

}
