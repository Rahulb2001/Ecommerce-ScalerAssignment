package com.scaler.ecommerce.InheritanceinDB.singletable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "TA_single_table_per_class")
@Getter
@Setter
@DiscriminatorValue(value = "ta_type")
public class TA extends User {

    private int helpRequest;
}
