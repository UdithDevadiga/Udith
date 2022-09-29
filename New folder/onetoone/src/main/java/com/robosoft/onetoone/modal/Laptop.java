package com.robosoft.onetoone.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Laptop {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Brand brand;
    private BigDecimal price;


}
