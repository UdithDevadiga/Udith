package com.evaluation2.patientmanagement.service;

import com.evaluation2.patientmanagement.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Boolean addHelpDesk(HelpDesk helpDesk) {
        try {
            String query = "insert into helpdesk values(" + helpDesk.getId() + ",'" + helpDesk.getFloor() + "'," + helpDesk.getHospitalId() + ")";
            jdbcTemplate.update(query);
            return true;
        } catch (DataAccessException e) {
            System.out.println("SQL Exception");
        }
        return false;
    }

    @Override
    public Boolean addDepartment(Department department) {
        try {
            String query = "insert into department values(" + department.getId() + ",'" + department.getName() + "','" + department.getFloor() + "')";
            jdbcTemplate.update(query);
            return true;
        } catch (DataAccessException e) {
            System.out.println("SQL Exception");
        }
        return false;
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {
        String query = "insert into doctor values("+doctor.getId()+",'"+doctor.getName()+"',"+doctor.getAge()+",'"+doctor.getGender()+"',"+doctor.getDeptId()+","+doctor.getMaxPatient()+")";
        jdbcTemplate.update(query);
        return viewDoctor(doctor.getId());
    }

    @Override
    public List<HelpDesk> viewHelpDesks() {
        String query = "select * from helpdesk";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(HelpDesk.class));
    }

    @Override
    public HelpDesk viewHelpDesk(int id) {
        String query = "select * from helpdesk where id = "+id;
        List<HelpDesk> helpdesk = jdbcTemplate.query(query,new BeanPropertyRowMapper<>(HelpDesk.class));
        return helpdesk.get(0);
    }

    @Override
    public List<Doctor> viewDoctors() {
        String query = "select * from doctor";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Doctor.class));
    }

    @Override
    public Doctor viewDoctor(int id) {
        String query = "select * from doctor where id = "+id;
        List<Doctor> doctors = jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Doctor.class));
        return doctors.get(0);

    }

    @Override
    public List<Department> viewDepartments() {
        String query = "select * from department";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Department.class));
    }

    @Override
    public Department viewDepartment(int id) {
        String query = "select * from department where id = "+id;
        List<Department> departments = jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Department.class));
        return departments.get(0);
    }

    @Override
    public List<MedicalFile> viewMedicalFiles() {
        String query = "select * from medical_file";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(MedicalFile.class));
    }

    @Override
    public MedicalFile viewMedicalFile(int fileId) {
        String query = "select * from medical_file where id = "+fileId;
        List<MedicalFile> medicalFiles = jdbcTemplate.query(query,new BeanPropertyRowMapper<>(MedicalFile.class));
        return medicalFiles.get(0);
    }

    @Override
    public List<MedFileDetails> viewMedFileDetails(int fileId) {
        String query = "select medical_file.id,medical_record.id,medical_record.patient_id,patient.name,doctor.id,doctor.name,medical_record.status from medical_file inner join medical_record on medical_file.record_id = medical_record.id inner join patient on medical_record.patient_id=patient.id inner join doctor on doctor.id =medical_record.doctor_id where medical_file.id="+fileId;
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(MedFileDetails.class));
    }
}
