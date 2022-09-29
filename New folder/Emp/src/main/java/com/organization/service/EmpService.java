package com.organization.service;

import com.organization.modal.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
public interface EmpService {
    ArrayList<Employee> findAllEmployee();
    Employee findAllEmployeeByID(long id);
    void addEmployee();
    void deleteAllData();


}
