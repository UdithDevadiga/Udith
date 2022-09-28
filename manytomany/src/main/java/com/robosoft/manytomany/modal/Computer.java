package com.robosoft.manytomany.modal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Computer {
    @Id
    @GeneratedValue
    private int compId;
    private String compName;
    private String ram;
    @ManyToMany(targetEntity = User.class,cascade = CascadeType.ALL,mappedBy = "computers")
    private List<User> users;
}
