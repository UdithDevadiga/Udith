package com.company.Industry.Controller;

import com.company.Industry.Modal.Employee;
import com.company.Industry.Service.EmployeeImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeImp employeeImp;

    @PostMapping("/saveEmployee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
        if(employeeImp.saveEmployee(emp)==true){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/findAllEmployee")
    public ResponseEntity<List<Employee>> findAllEmployee(){
        List<Employee> employeeList = employeeImp.findAllEmployee();
        int size = employeeList.size();
        if (size<=0)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.of(Optional.of(employeeList));
    }

    @GetMapping("/findEmployeeById/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable int id){
        Employee employee = employeeImp.findEmployeeById(id);
        if(employee==null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.of(Optional.of(employee));
    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable int id){
        if(employeeImp.deleteEmployeeById(id)==false){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("/deleteAllEmployee")
    public ResponseEntity<Void> deleteAllEmployee(){
        if(employeeImp.deleteAllEmployee()==false){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/updateEmployeeById/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable int id, @RequestBody Employee emp){
        Employee employee = employeeImp.updateEmployeebyId(id,emp);
        if(employee!=null){
            return ResponseEntity.of(Optional.of(employee));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
