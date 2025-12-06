package com.scaler.ecommerce.InheritanceinDB.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ta_table_per_class")
@Getter
@Setter
public class TA extends User {

    private int helpRequest;
}
