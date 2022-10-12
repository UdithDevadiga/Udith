package com.evaluation2.patientmanagement.controller;

import com.evaluation2.patientmanagement.model.Insurance;
import com.evaluation2.patientmanagement.model.Patient;
import com.evaluation2.patientmanagement.service.HelpDeskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/HelpDesk")
public class HelpDeskController {
    @Autowired
    private HelpDeskServiceImpl helpDeskService;
    @GetMapping("/PatientExist/{id}")
    public ResponseEntity<String> checkPatientExist(@PathVariable int id) {
        if(helpDeskService.checkPatientExist(id)) {
            return ResponseEntity.status(HttpStatus.FOUND).body("ID Found :)");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID Not Found :(");
    }
    @PostMapping("/Register")
    public ResponseEntity<Patient> patientRegister(@RequestBody Patient patient) {
        Patient patient1 = helpDeskService.patientRegister(patient);
        if(patient1!=null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(patient1);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
    @GetMapping("/viewPatients")
    public ResponseEntity<List<Patient>> viewAllPatients() {
        List<Patient> patients = helpDeskService.viewPatients();
        int size = patients.size();
        if (size != 0) {
            return ResponseEntity.status(HttpStatus.FOUND).body(patients);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(patients);
    }
    @GetMapping("/viewPatient/{id}")
    public ResponseEntity<Patient> viewPatient(@PathVariable int id) {
        Patient patient = helpDeskService.viewPatient(id);
        if(patient==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(patient);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(patient);
    }
    @PostMapping("/Insurance/{id}/{stayDuration}")
    public ResponseEntity<Insurance> enterInsurance(@RequestBody Insurance insurance, @PathVariable int id, @PathVariable int stayDuration) {
        Insurance insurance1 = helpDeskService.enterInsuranceDetails(id,insurance,stayDuration);
        if(insurance1 == null) {
            System.out.println("Either Patient is of Type OPD or Invalid Details");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(insurance1);
    }
}
