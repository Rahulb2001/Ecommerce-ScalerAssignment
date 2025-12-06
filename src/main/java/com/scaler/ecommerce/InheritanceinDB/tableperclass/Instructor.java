package com.scaler.ecommerce.InheritanceinDB.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "instructor_table_per_class")
@Getter
@Setter
public class Instructor extends User {

    private String company;
}
