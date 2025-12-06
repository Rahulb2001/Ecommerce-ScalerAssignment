package com.scaler.ecommerce.InheritanceinDB.tableperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Entity(name= "table_per_class_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public class User {

    private String name;

    @Id
    private UUID uuid;
}
