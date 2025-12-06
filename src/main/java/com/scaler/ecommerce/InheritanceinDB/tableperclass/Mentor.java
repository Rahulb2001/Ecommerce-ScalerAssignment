package com.scaler.ecommerce.InheritanceinDB.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "mentors_table_per_class")
@Getter
@Setter
public class Mentor extends User {

    private Double ratings;
}
