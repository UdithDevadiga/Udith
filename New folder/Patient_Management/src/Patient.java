public class Patient {

    private int id;
    private String name;
    private int age;
    private String gender;
    private String phNumber;
    private String type;



    public Patient() {
    }

    public Patient(int id, String name, int age, String gender, String phNumber, String type) {
        this.id=id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phNumber = phNumber;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phNumber='" + phNumber + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
