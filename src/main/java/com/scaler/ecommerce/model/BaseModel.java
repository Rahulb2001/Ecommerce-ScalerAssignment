package com.scaler.ecommerce.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {

    @Id
    private Long id;
    private Date createdAt;
    private Date updatedAt;
    private State state;

    public BaseModel() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.state = State.ACTIVE;
    }
}
