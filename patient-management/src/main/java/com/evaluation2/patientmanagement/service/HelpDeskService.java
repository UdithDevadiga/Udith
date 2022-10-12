package com.evaluation2.patientmanagement.service;

import com.evaluation2.patientmanagement.model.*;

import java.util.List;

public interface HelpDeskService {
    public Boolean checkPatientExist(int patientId);
    public Boolean checkDoctorExist(int doctorId);
    public Boolean checkInPatient(int patientId);
    public Boolean checkIfDoctorBusy(int docId);
    public Patient patientRegister(Patient patient);
    public List<Patient> viewPatients();
    public Patient viewPatient(int id);
    public Insurance enterInsuranceDetails(int patientId, Insurance insurance,int stayDuration);
    public Boolean advancePayment(AdvancePayment payment);
    public DoctorLocation bookAppointment(Appointment appointment);
    public Boolean checkAdvancePayment(int patientId);
    public Admit admitPatient(Admit admit);

}
