package binary_search_tree;

public class Student {
    private int studentID;
    private String studentName;
    private String dateOfBirth;
    private String uniName;
    private String departmentCode;
    private String departmentName;
    private int yearOfEnrollment;

    public Student(int studentID, String studentName, String dateOfBirth, String uniName, String departmentCode, String departmentName, int yearOfEnrollment) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.uniName = uniName;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.yearOfEnrollment = yearOfEnrollment;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getYearOfEnrollment() {
        return yearOfEnrollment;
    }

    public void setYearOfEnrollment(int yearOfEnrollment) {
        this.yearOfEnrollment = yearOfEnrollment;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
}
