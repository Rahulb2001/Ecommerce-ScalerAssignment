package com.scaler.ecommerce.InheritanceinDB.joinedclass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Entity(name= "user_joined_class")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class User {

    private String name;

    @Id
    private UUID uuid;
}
