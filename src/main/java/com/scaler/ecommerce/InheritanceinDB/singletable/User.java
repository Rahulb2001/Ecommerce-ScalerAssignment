package com.scaler.ecommerce.InheritanceinDB.singletable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Entity(name= "user_single_table_per_class")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "user_type",
        discriminatorType = DiscriminatorType.STRING
)
@Getter
@Setter
public class User {

    private String name;

    @Id
    private UUID uuid;
}
