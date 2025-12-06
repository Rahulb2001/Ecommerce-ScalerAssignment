package com.scaler.ecommerce.InheritanceinDB.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "mentor_single_table_per_class")
@Getter
@Setter
@DiscriminatorValue(value = "st_mentor")
public class Mentor extends User {

    private Double ratings;
}
