import java.util.Date;

public class MedicalReport {
    private Date date;
    private String report;
    private Patient patient;

    public MedicalReport(Date date, String report,Patient patient) {
        this.date = date;
        this.report = report;
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "MedicalReport{" +
                "date=" + date +
                ", report='" + report + '\'' +
                ", patient=" + patient +
                '}';
    }

}
