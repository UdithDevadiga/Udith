package com.evaluation2.patientmanagement.service;

import com.evaluation2.patientmanagement.model.Appointment;
import com.evaluation2.patientmanagement.model.MedFileDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    double docFees=1000;

    @Override
    public Boolean checkAppointment(Appointment appointment) {
        String query = "select * from appointment where patient_id = "+appointment.getPatientId()+" and doctor_id = "+appointment.getDoctorId();
        List<Appointment> appointments = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Appointment.class));
        if(appointments.size()!=0) {
            return true;
        }
        return false;
    }

    @Override
    public List<MedFileDetails> viewMedFileDetails(int patientId) {
        String query = "select medical_file.id,medical_record.id,medical_record.patient_id,patient.name,doctor.id,doctor.name,medical_record.status from medical_file inner join medical_record on medical_file.record_id = medical_record.id inner join patient on medical_record.patient_id=patient.id inner join doctor on doctor.id =medical_record.doctor_id where medical_record.patient_id="+patientId;
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(MedFileDetails.class));
    }

    @Override
    public Boolean attendPatient(Appointment appointment,String report) {
        if(checkAppointment(appointment)){
            int patientId = appointment.getPatientId();
            System.out.println("Attending Patient ");
            String query = "insert into medical_report(patient_id,doctor_id,report) values ("+appointment.getPatientId()+","+appointment.getDoctorId()+",'"+report+"')";
            jdbcTemplate.update(query);
            String delQuery = "delete from appointment where patient_id = "+appointment.getPatientId()+" and doctor_id = "+appointment.getDoctorId();
            jdbcTemplate.update(delQuery);
            HelpDeskServiceImpl helpDeskService = new HelpDeskServiceImpl();
            helpDeskService.docFees(patientId,docFees);
            return true;
        }
        return false;
    }

    @Override
    public Appointment transferPatient(int patientId, int originalDoctorId, int newDoctorId) {
        return null;
    }
}
