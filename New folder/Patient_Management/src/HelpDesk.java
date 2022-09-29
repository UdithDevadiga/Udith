import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HelpDesk {
    public static void main(String[] args) throws InvalidWardException {
        Scanner s= new Scanner(System.in);
        Scanner c= new Scanner(System.in);

        Department department1 = new Department(1,"surgical department","Ground Floor");
        Department department2 = new Department(2,"neurological department","First Floor");
        Doctor doc1 = new Doctor(1,"srinivas",27,"Male","986775443",department1);
        Doctor doc2 = new Doctor(2,"govind",45,"Male","876775431",department2);
        Doctor doc3 = new Doctor(3,"Mary",31,"Female","766775492",department2);
        Hospital.doctorList.add(doc1);
        Hospital.doctorList.add(doc2);
        Hospital.doctorList.add(doc3);


        while(true){
            System.out.println("The choices are : \n1. Patient Registration\t2. Doctor\t3. Patient Bill Payment\t4. Exit ");
            int choice = c.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter Patient id : ");
                    int id = c.nextInt();
                    System.out.println("Enter Patient name : ");
                    String name = s.next();
                    System.out.println("Enter Patient age : ");
                    int age = c.nextInt();
                    System.out.println("Enter Patient gender : ");
                    String gender = s.next();
                    System.out.println("Enter Patient phone number : ");
                    String phNumber = s.next();
                    System.out.println("Enter Patient type OPD or NonOPD: ");
                    String patientType = s.next();
                    Patient patient = new Patient(id, name, age, gender, phNumber, patientType);
                    System.out.println("Please submit previous medical report :");
                    Date date;
                    try {
                        System.out.println("Enter date in yyyy/mm/dd format as in the report : ");
                        String sdate = s.next();
                        date = new SimpleDateFormat("yyyy/MM/dd").parse(sdate);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Enter report given by doctor : ");
                    String report = s.next();
                    MedicalReport medicalReport = new MedicalReport(date, report, patient);
                    Hospital.medicalReportList.add(medicalReport);
                    Doctor doc = null;
                    System.out.println("Enter the doctor name");
                    String dname = s.next();
                    if (patientType.equalsIgnoreCase("opd")) {
                        Department dept = Hospital.checkDoctor(dname.toLowerCase());
                        if (dept != null) {
                            if (Doctor.patientList.size() > 10) {
                                System.out.println("Sorry Dr. " + dname + " is busy today.");
                            } else {
                                Doctor doct = Hospital.getDoctor(dname);
                                Doctor.patientList.add(patient);
                                Doctor.patients.put(patient, doct);
                                System.out.println("Appointment has been booked");
                                System.out.println("Please Go To " + dept.getDeptLocation());
                                Doctor.getMedReport(medicalReport);
                            }
                        } else {
                            System.out.println("There is no doctor/department with " + dname);
                        }
                    } else {
                        Doctor.patientList.add(patient);
                        System.out.println("Enter the ward number : ");
                        int wardNumber = c.nextInt();
                        try {
                            if (wardNumber > 10) {
                                throw new InvalidWardException("No ward named 10");
                            }
                        } catch (InvalidWardException e) {
                            e.printStackTrace();
                        }
                        Date admitDate;
                        try {
                            System.out.println("Enter date of admit in yyyy/mm/dd");
                            String strDate = s.next();
                            admitDate = new SimpleDateFormat("yyyy/MM/dd").parse(strDate);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Enter the days of stay ");
                        int days = c.nextInt();
                        doc = Hospital.getDoctor(dname);
                        if (Hospital.checkWard(wardNumber) == false) {
                            System.out.println("Sorry this ward is full");
                            break;
                        } else {
                            Hospital hospital = new Hospital(patient, doc, wardNumber, admitDate, days);
                            Hospital.hospitalList.add(hospital);
                            Doctor.getMedReport(medicalReport);
                            System.out.println("Do you have medical insurance ? Reply with Yes or No");
                            String insurance = s.next();
                            if (insurance.equalsIgnoreCase("yes")) {
                                System.out.println("You can make payment when getting discharged");
                            } else {
                                System.out.println("Please make an advance payment via Cash\nEnter the amount : ");
                                double advancePayment = c.nextDouble();
                                Hospital.advancePayments.put(patient, advancePayment);
                            }

                        }
                    }
                }
                case 2 -> {
                    System.out.println("Choices are 1. View Patients\t2. Transfer Patient\t3. Billing\t4. Medical Report");
                    System.out.println("Enter your choice : ");
                    int ch = c.nextInt();
                    System.out.println("Enter your Id : ");
                    int myDocId = c.nextInt();
                    if (Hospital.checkDoctor(myDocId)) {
                        switch (ch) {
                            case 1:
                                System.out.println(Doctor.viewPatients());
                                break;

                            case 2:


                                Doctor doctor = Hospital.getDoctor(myDocId);
                                System.out.println("Enter the patient id you want to transfer : ");
                                try {
                                    int pId = c.nextInt();
                                    if (Doctor.checkPatient(pId) == true) {
                                        System.out.println("Enter the doctor id whom you want to transfer this patient : ");
                                        try {
                                            int docId = c.nextInt();
                                            if (Hospital.checkDoctor(docId)) {
                                                System.out.println("Patient with id " + pId + " is transferred to doctor with id " + docId);
                                                Patient pt = Doctor.getPatient(pId);
                                                Doctor dr = Hospital.getDoctor(docId);
                                                Doctor.patients.put(pt, dr);
                                                Doctor.patients.remove(pt, doctor);
                                            } else {
                                                throw new Exception("Invalid doctor Id");
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    } else {
                                        throw new Exception("Invalid patient Id");
                                    }
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                            case 3:
                                System.out.println("Enter patient id : ");
                                int patId = c.nextInt();
                                if(Doctor.checkPatient(patId)){
                                    double docCharge = Doctor.getDoctorCharge();
                                    if(Hospital.checkAdmitPatient(patId)){
                                        double totalBill = Hospital.totalBill(docCharge);
                                        System.out.println("Total Bill is : "+totalBill);
                                        Payment pay = new Payment(patId,totalBill);
                                        Hospital.billList.add(pay);
                                    }
                                    else {
                                        System.out.println("Total Bill is : "+docCharge);
                                        Payment pay = new Payment(patId,docCharge);
                                        Hospital.billList.add(pay);
                                    }
                                }
                                else {
                                    System.out.println("Sorry. There is no patient with Id "+patId);
                                    break;
                                }
                                break;

                            case 4:
                                System.out.println("Enter Patient id : ");
                                int paId = c.nextInt();
                                if(Hospital.checkPatient(paId)) {
                                    Patient patient = Doctor.getPatient(paId);
                                    Date date;
                                    try {
                                        System.out.println("Enter the Date  in yyyy/MM/dd : ");
                                        String stringDate = s.next();
                                        date = new SimpleDateFormat("yyyy/MM/dd").parse(stringDate);
                                    } catch (ParseException e) {
                                        throw new RuntimeException(e);
                                    }
                                    System.out.println("Enter the observed report : ");
                                    String report = s.next();
                                    MedicalReport medicalReport = new MedicalReport(date, report, patient);
                                    Hospital.medicalReportList.add(medicalReport);
                                }
                                break;
                        }
                    }
                    else {
                        System.out.println("Wrong Id");
                    }
                }
                case 3 -> {
                    System.out.println("Enter your patient id : ");
                    int patId = c.nextInt();
                    if(Doctor.checkPatient(patId)){
                        double bill = Hospital.getBill(patId);
                        System.out.println("Your total Bill is "+bill);
                        System.out.println("Please pay the amount shown above : ");
                        double pay = c.nextDouble();
                        System.out.println("Thank you :)");
                        System.out.println("Would you like to take your medical report! Reply with Yes or No: ");
                        Patient patient = Doctor.getPatient(patId);
                        Doctor.patientList.remove(patient);
                        String reply = s.next();
                        if(reply.equalsIgnoreCase("yes")) {
                            MedicalReport medicalReport = Hospital.getMedicalReport(patId);
                            System.out.println("Thank you for collecting your medical report. Thank you");
                        }
                        else {
                            System.out.println("If you wish to collect your medical report come again. Thank you.");
                        }
                    }
                    else {
                        System.out.println("Invalid Id");
                    }
                }
                case 4 -> {
                    System.out.println("Exited ...");
                    System.exit(0);
                }
            }
        }
    }

}
