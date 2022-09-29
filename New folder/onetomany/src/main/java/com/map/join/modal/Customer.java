package com.map.join.modal;





import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private int age;

    @OneToMany(targetEntity = Product.class , cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_fk" , referencedColumnName = "id")
    private List<Product> products;
}
