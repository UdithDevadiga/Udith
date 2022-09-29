package com.company.Industry.Service;

import com.company.Industry.Modal.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeImp {
    List<Employee> empList = new LinkedList<Employee>();

    public List<Employee> findAllEmployee() {
        return empList;
    }

    public Employee findEmployeeById(int id) {
        int size = empList.size();
        for (int i = 0; i < size; i++)
        {
            Employee temp = empList.get(i);
            if (id == temp.getId())
            {
                System.out.println("Yo");
                return temp;
            }
        }
        return null;
    }
    public Boolean deleteEmployeeById(int id1){
        int size = empList.size();
            for (int i = 0; i < size; i++) {
                Employee temp = empList.get(i);
                if (id1 == temp.getId()) {
                    empList.remove(temp);
                    return true;
                }
            }
            return false;
        }
    public Boolean deleteAllEmployee(){
        try {
            empList.clear();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
        public Boolean saveEmployee (Employee emp){
            try {
                empList.add(emp);
                return true;
            }
            catch (Exception e){
                e.getStackTrace();
                return false;
            }

        }

        public Employee updateEmployeebyId ( int id, Employee emp){
            int size = empList.size();
            for (int i = 0; i < size; i++) {
                Employee temp = empList.get(i);
                if (id == temp.getId()) {
                    if (emp.getId() != 0) {
                        temp.setId(emp.getId());
                    }
                    if (emp.getName() != null) {
                        temp.setName(emp.getName());
                    }
                    if (emp.getDepartment() != null) {
                        temp.setDepartment(emp.getDepartment());
                    }
                    if (emp.getLocation() != null) {
                        temp.setLocation(emp.getLocation());
                    }
                    return temp;
                }
            }
            return null;
        }
    }

