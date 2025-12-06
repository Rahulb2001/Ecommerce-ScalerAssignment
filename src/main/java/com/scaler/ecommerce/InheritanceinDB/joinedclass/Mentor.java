package com.scaler.ecommerce.InheritanceinDB.joinedclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "mentor_joined_class")
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "user_id_")
public class Mentor extends User {

    private Double ratings;
}
