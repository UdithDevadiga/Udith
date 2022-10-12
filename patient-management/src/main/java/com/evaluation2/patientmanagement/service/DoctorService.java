package com.evaluation2.patientmanagement.service;

import com.evaluation2.patientmanagement.model.Appointment;
import com.evaluation2.patientmanagement.model.MedFileDetails;

import java.util.List;

public interface DoctorService {
    public Boolean checkAppointment(Appointment appointment);
    public List<MedFileDetails> viewMedFileDetails(int fileId);
    public Boolean attendPatient(Appointment appointment,String report);

    public Appointment transferPatient(int patientId,int originalDoctorId,int newDoctorId);
}
