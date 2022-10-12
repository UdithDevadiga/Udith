package com.evaluation2.patientmanagement.controller;

import com.evaluation2.patientmanagement.model.*;
import com.evaluation2.patientmanagement.service.HospitalService;
import com.evaluation2.patientmanagement.service.HospitalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("/Hospital")
public class HospitalController {
    @Autowired
    private HospitalServiceImpl hospitalService;
    @PostMapping("/AddHelpDesk")
    public ResponseEntity<String> addHelpDesk(@RequestBody HelpDesk helpDesk) {
        if(hospitalService.addHelpDesk(helpDesk)) {
            return ResponseEntity.status(HttpStatus.OK).body("HelpDesk Added Successfully");
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Task Failed");
    }
    @PostMapping("/AddDepartment")
    public ResponseEntity<String> addDepartment(@RequestBody Department department) {
        if(hospitalService.addDepartment(department)) {
            return ResponseEntity.status(HttpStatus.OK).body("Department Added Successfully");
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Task Failed");
    }
    @PostMapping("/AddDoctor")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.status(HttpStatus.OK).body(hospitalService.addDoctor(doctor));
    }
    @GetMapping("/ViewDoctor/{id}")
    public ResponseEntity<Doctor> viewDoctor(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(hospitalService.viewDoctor(id));
    }
    @GetMapping("/ViewHelpDesk/{id}")
    public ResponseEntity<HelpDesk> viewHelpDesk(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(hospitalService.viewHelpDesk(id));
    }
    @GetMapping("/ViewHelpDesks")
    public ResponseEntity<List<HelpDesk>> viewHelpDesks() {
        return ResponseEntity.status(HttpStatus.FOUND).body(hospitalService.viewHelpDesks());
    }
    @GetMapping("/ViewDepartment/{id}")
    public ResponseEntity<Department> viewDepartment(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(hospitalService.viewDepartment(id));
    }
    @GetMapping("/ViewDepartments")
    public ResponseEntity<List<Department>> viewDepartments() {
        return ResponseEntity.status(HttpStatus.FOUND).body(hospitalService.viewDepartments());
    }
    @GetMapping("/ViewMedicalFile/{id}")
    public ResponseEntity<MedicalFile> viewMedicalFile(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(hospitalService.viewMedicalFile(id));
    }
    @GetMapping("/ViewMedicalFiles")
    public ResponseEntity<List<MedicalFile>> viewMedicalFiles() {
        return ResponseEntity.status(HttpStatus.FOUND).body(hospitalService.viewMedicalFiles());
    }
    @GetMapping("/ViewMedFileDetails/{fileId}")
    public ResponseEntity<List<MedFileDetails>> viewMedFileDetails(@PathVariable int fileId) {
        return ResponseEntity.status(HttpStatus.FOUND).body(hospitalService.viewMedFileDetails(fileId));
    }
}
