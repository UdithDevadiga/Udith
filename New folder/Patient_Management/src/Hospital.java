import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Hospital {
    Patient patient;
    Doctor doctor;
    private int wardNumber;
    private Date joinDate;
    private int daysOfStay;

    static List<Patient> patientList = new LinkedList<Patient>();
    static List<Doctor> doctorList = new LinkedList<Doctor>();
    static List<Hospital> hospitalList = new LinkedList<Hospital>();
    static List<MedicalReport> medicalReportList = new LinkedList<MedicalReport>();
    static HashMap<Patient,Double> advancePayments=new HashMap<Patient,Double>();
    static List<Payment> billList = new LinkedList<>();

    public Hospital() {
    }
    public Hospital(Patient patient, Doctor doctor, int wardNumber, Date joinDate, int daysOfStay) {
        this.patient = patient;
        this.doctor = doctor;
        this.wardNumber = wardNumber;
        this.joinDate = joinDate;
        this.daysOfStay = daysOfStay;
    }

    public static boolean checkWard(int wardNumber) {
        int size = hospitalList.size();
        for(int i=0;i<size;i++) {
            Hospital temp = hospitalList.get(i);
            if(temp.wardNumber==wardNumber) {
                return false;
            }
        }
        return true;
    }

    public int getWardNumber() {
        return wardNumber;
    }

    public void setWardNumber(int wardNumber) {
        this.wardNumber = wardNumber;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void addDoctor(Doctor doctor) {
        doctorList.add(doctor);

    }

    public static Doctor getDoctor(String name){
        int size = doctorList.size();
        for(int i=0;i<size;i++){
            Doctor temp = doctorList.get(i);
            if(temp.getDocName().equals(name)){
                return temp;
            }
        }
        return null;
    }

    public static Doctor getDoctor(int id){
        int size = doctorList.size();
        for(int i=0;i<size;i++){
            Doctor temp = doctorList.get(i);
            if(temp.getDocId()==id){
                return temp;
            }
        }
        return null;
    }

    public static Department checkDoctor(String name){
        int size = doctorList.size();
        for(int i=0;i<size;i++){
            Doctor temp = doctorList.get(i);
            if(temp.getDocName().equals(name)){
                return temp.getDepartment();
            }
        }
        return null;
    }

    public static Boolean checkDoctor(int id){
        int size = doctorList.size();
        for(int i=0;i<size;i++){
            Doctor temp = doctorList.get(i);
            if(temp.getDocId()==id){
                return true;
            }
        }
        return false;
    }

    public static Boolean checkAdmitPatient(int id){
        int size = hospitalList.size();
        for(int i=0;i<size;i++) {
            Hospital temp = hospitalList.get(i);
            if(temp.getPatient().getId()==id) {
                return true;
            }
        }
        return false;
    }

    public static Boolean checkPatient(int id){
        int size = patientList.size();
        for(int i=0;i<size;i++) {
            Patient temp = patientList.get(i);
            if(temp.getId()==id) {
                return true;
            }
        }
        return false;
    }

    public static double totalBill(double fee){
        double wardCharge = 15000;
        double total = fee + wardCharge;
        return total;
    }

    public static double getBill(int id){
        int size = billList.size();
        for(int i=0;i<size;i++) {
            Payment temp = billList.get(i);
            if(temp.getId()==id){
                return temp.getAmount();
            }
        }
        return 0;
    }

    public static MedicalReport getMedicalReport(int id){
        int size = medicalReportList.size();
        for(int i=0;i<size;i++) {
            MedicalReport temp = medicalReportList.get(i);
            if(temp.getPatient().getId()==id) {
                return temp;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "patient=" + patient +
                ", doctor=" + doctor +
                ", wardNumber=" + wardNumber +
                ", joinDate=" + joinDate +
                ", daysOfStay=" + daysOfStay +
                '}';
    }
}
