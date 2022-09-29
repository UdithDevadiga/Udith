import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Doctor {
    private int docId;
    private String docName;
    private int docAge;
    private String docGender;
    private String docPhoneNumber;
    private Department department;

    static HashMap<Patient,Doctor> patients = new HashMap<Patient, Doctor>();
    static List<Patient> patientList = new LinkedList<Patient>();

    public Doctor() {
    }

    public Doctor(int docId, String docName, int docAge, String docGender, String docPhoneNumber, Department department) {
        this.docId = docId;
        this.docName = docName;
        this.docAge=docAge;
        this.docGender = docGender;
        this.docPhoneNumber = docPhoneNumber;
        this.department = department;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public int getDocAge() {
        return docAge;
    }

    public void setDocAge(int docAge) {
        this.docAge = docAge;
    }

    public String getDocGender() {
        return docGender;
    }

    public void setDocGender(String docGender) {
        this.docGender = docGender;
    }

    public String getDocPhoneNumber() {
        return docPhoneNumber;
    }

    public void setDocPhoneNumber(String docPhoneNumber) {
        this.docPhoneNumber = docPhoneNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public static void getMedReport(MedicalReport medicalReport) {
        MedicalReport mrep = medicalReport;
    }

    public static List<Patient> viewPatients() {
        return patientList;
    }

    public static Boolean checkPatient(int id) {
        int size = patientList.size();
        for(int i=0;i<size;i++) {
            Patient temp = patientList.get(i);
            if(temp.getId()==id){
                return true;
            }
        }
        return false;
    }

    public static Patient getPatient(int id) {
        int size = patientList.size();
        for(int i=0;i<size;i++) {
            Patient temp = patientList.get(i);
            if(temp.getId()==id){
                return temp;
            }
        }
        return null;
    }
    public static double getDoctorCharge(){
        double docCharge =  2000;
        return docCharge;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "docId=" + docId +
                ", docName='" + docName + '\'' +
                ", docAge=" + docAge +
                ", docGender='" + docGender + '\'' +
                ", docPhoneNumber='" + docPhoneNumber + '\'' +
                ", department=" + department +
                '}';
    }
}
