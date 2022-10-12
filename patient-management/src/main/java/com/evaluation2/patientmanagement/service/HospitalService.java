package com.evaluation2.patientmanagement.service;

import com.evaluation2.patientmanagement.model.*;

import java.util.List;

public interface HospitalService {
    public Boolean addHelpDesk(HelpDesk helpDesk);
    public Boolean addDepartment(Department department);
    public Doctor addDoctor(Doctor doctor);
    public List<HelpDesk> viewHelpDesks();
    public HelpDesk viewHelpDesk(int id);
    public List<Doctor> viewDoctors();
    public Doctor viewDoctor(int id);
    public List<Department> viewDepartments();
    public Department viewDepartment(int id);
    public List<MedicalFile> viewMedicalFiles();
    public MedicalFile viewMedicalFile(int fileId);
    public List<MedFileDetails> viewMedFileDetails(int fileId);
}
