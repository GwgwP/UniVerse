// package gr.aueb.softeng.team02;

import java.util.ArrayList;

public class Grade {

    private double grade;
    private int student_id;
    public Grade(double grade) {
        this.grade = grade;    
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getSubject_id() {
        return this.student_id;
    }

    public void setSubject_id(int subject_id) {
        this.student_id = subject_id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        // TODO Check exceptions cases and throws exception classes
        if (grade < 0 || grade > 10) {
            throw new RuntimeException("Invalid grade");
        }
        this.grade = grade;
    }

}
