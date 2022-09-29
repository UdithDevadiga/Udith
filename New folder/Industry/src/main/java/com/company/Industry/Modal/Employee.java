package com.company.Industry.Modal;

public class Employee {
    String name;
    int id;
    String department;
    String location;

    Employee(String name,int id,String department,String location){
        this.name=name;
        this.id=id;
        this.department=department;
        this.location=location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
