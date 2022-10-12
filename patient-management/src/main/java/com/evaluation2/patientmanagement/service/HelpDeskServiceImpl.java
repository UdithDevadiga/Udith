package com.evaluation2.patientmanagement.service;

import com.evaluation2.patientmanagement.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HelpDeskServiceImpl implements HelpDeskService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Boolean checkPatientExist(int id) {
        String query = "select id from patient where id="+id;
        try {
            int patientId = jdbcTemplate.queryForObject(query, Integer.class);
            if(id==patientId) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Data not found");
        }
        return false;
    }

    @Override
    public Boolean checkDoctorExist(int doctorId) {
        String query = "select id from doctor where id="+doctorId;
        try {
            int doctorId1 = jdbcTemplate.queryForObject(query, Integer.class);
            if(doctorId==doctorId1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Data not found");
        }
        return false;
    }

    @Override
    public Boolean checkInPatient(int patientId) {
        String query = "select patient_id from in_patient where patient_id = "+patientId;
        List<Integer> inPatients = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Integer.class));
        int inPatient = inPatients.get(0);
        if(inPatient==patientId) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean checkIfDoctorBusy(int docId) {
        String query = "select max_patient from doctor where id = "+docId;
        List<Integer> maxPatients = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Integer.class));
        int maxPatient = maxPatients.get(0);
        if(maxPatient==0) {
            return true;
        }
        return false;
    }

    @Override
    public Patient patientRegister(Patient patient) {
        String query = "insert into patient(name,age,gender,phone_number,type) values('"+patient.getName()+"',"+patient.getAge()+",'"+patient.getGender()+"',"+patient.getPhoneNumber()+",'"+patient.getType()+"')";
        try {
            jdbcTemplate.update(query);
            String returnQuery = "select * from patient where phone_number = " + patient.getPhoneNumber();
            List<Patient> patients = jdbcTemplate.query(returnQuery, new BeanPropertyRowMapper<>(Patient.class));
            Patient patient1 = patients.get(0);
            if(patient1.getType().equalsIgnoreCase("out")) {
                String outQuery =  "insert into out_patient values("+patient1.getId()+")";
                jdbcTemplate.update(outQuery);
            }
            return patient1;
        }
        catch (Exception e){
            System.out.println("Data already exist");
            return null;
        }

    }
    @Override
    public List<Patient> viewPatients() {
        String query = "select * from patient";
        return jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Patient.class));
    }

    @Override
    public Patient viewPatient(int id) {
        String query = "select * from patient where id = "+id;
        List<Patient> patients = jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Patient.class));
        int size = patients.size();
        if(size==0) {
            return null;
        }
        return patients.get(0);
    }

    @Override
    public Insurance enterInsuranceDetails(int patientId, Insurance insurance,int stayDuration) {
        String query = "select type from patient where id ="+patientId;
        String type = jdbcTemplate.queryForObject(query, String.class);
        if(type.equalsIgnoreCase("in")) {
            String insuranceQuery = "insert into insurance values('"+insurance.getInsuranceNumber()+"',"+insurance.getExpiryDate()+")";
            jdbcTemplate.update(insuranceQuery);
            String inPatientQuery = "insert into in_patient values("+patientId+","+stayDuration+","+insurance.getInsuranceNumber()+")";
            jdbcTemplate.update(inPatientQuery);
        }
        return null;
    }

    @Override
    public Boolean advancePayment(AdvancePayment payment) {
        if(checkInPatient(payment.getPatientId())) {
            String query = "insert into advance_payment values(" + payment.getPatientId() + "," + payment.getAdvancePayment() + ")";
            jdbcTemplate.update(query);
            return true;
        }
        return false;
    }

    @Override
    public DoctorLocation bookAppointment(Appointment appointment) {
        if(checkPatientExist(appointment.getPatientId())) {
            if (checkDoctorExist(appointment.getDoctorId())) {
                if (checkIfDoctorBusy(appointment.getDoctorId())) {
                    return null;
                }
                String query = "insert into appointment values(" + appointment.getPatientId() + "," + appointment.getDoctorId() + ")";
                jdbcTemplate.update(query);
                String docQuery = "update Doctor set max_patient = max_patient-1 where id = "+appointment.getDoctorId();
                jdbcTemplate.update(docQuery);
                String returnQuery = "select doctor.id,doctor.name,department.id,department.name,department.floor from doctor inner join department on doctor.dept_id == department.id where doctor.id = "+appointment.getDoctorId();
                List<DoctorLocation> doctorLocations = jdbcTemplate.query(returnQuery,new BeanPropertyRowMapper<>(DoctorLocation.class));
                return doctorLocations.get(0);
            }
            return null;
        }
        return null;
    }

    @Override
    public Boolean checkAdvancePayment(int patientId) {
        String query = "select patient_id from advance_payment where patient_id = "+patientId;
        List<Integer> patients = jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Integer.class));
        int patient = patients.get(0);
        if(patient==patientId) {
            return true;
        }
        return false;
    }

    @Override
    public Admit admitPatient(Admit admit) {
        if(checkAdvancePayment(admit.getPatientId())){
            String query = "insert into admit values("+admit.getAdmitId()+","+admit.getPatientId()+","+admit.getWardNumber()+","+admit.getAdmitDate()+")";
            jdbcTemplate.update(query);
            String returnQuery = "select * from admit where id = "+admit.getAdmitId();
            List<Admit> admits = jdbcTemplate.query(returnQuery,new BeanPropertyRowMapper<>(Admit.class));
            return admits.get(0);

        }
        return null;
    }

    public  void docFees(int patientId, double docFees) {
        String query = "delete from out_patient where patient_id = "+patientId;
        jdbcTemplate.update(query);
        System.out.println("Fee paid by patient with ID "+patientId+" is "+docFees);
        String feeQuery = "insert into fee_manager values("+patientId+","+docFees+")";
        jdbcTemplate.update(feeQuery);
    }
}
