package web.service;

import java.util.List;

public class StudentProfile {

    private String studentId;
    private String studentName;
    private List<String> enrolledUnits;
    private String status;

    public StudentProfile(String studentId, String studentName, 
                         List<String> enrolledUnits, String status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.enrolledUnits = enrolledUnits;
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<String> getEnrolledUnits() {
        return enrolledUnits;
    }

    public String getStatus() {
        return status;
    }
}