package com.hibernate.demo.hiber;

import javax.persistence.*;

@Entity
@Table(name="StudentOs")
public class Studentos {
    @Id
    private int id;
    @Column(name="Student_Name")
    private Name name;
//    @Transient
    private String city;

    public Studentos() {
    }

    public Studentos(int id, Name name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Studentos{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

