package com.robosoft.manytomany.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String gender;
    @ManyToMany(targetEntity = Computer.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "uc_fk",referencedColumnName = "id")
    private List<Computer> computers;
}
