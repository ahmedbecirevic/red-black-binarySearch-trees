package binary_search_tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Student implements Comparable<Student> {
    private static final BinarySearchTree<Integer, Student> studentData = new BinarySearchTree<>();
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

    public static void storeFileToArray(String filePath) throws FileNotFoundException {
        int i = 0;

        File file = new File(filePath);
        Scanner readFile = new Scanner(file);

        while(readFile.hasNextLine()) {
            String[] line = readFile.nextLine().split(";");
            studentData.put(Integer.parseInt(line[0]),
                            new Student(Integer.parseInt(line[0]),
                                                         line[1],
                                                         line[2],
                                                         line[3],
                                                         line[4],
                                                         line[5],
                                                         Integer.parseInt(line[6])));
        }
        readFile.close();
    }



    @Override
    public int compareTo(Student student) {
        if (this.studentID > student.studentID) {
            return 1;
        } else if (this.studentID < student.studentID) {
            return -1;
        }
        return 0;
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
