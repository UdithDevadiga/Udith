package com.robosoft.jpa.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
public class Product {
    @GeneratedValue
    @Id
    private int id;
    private String name;
    private int quantity;
    private double price;
}
