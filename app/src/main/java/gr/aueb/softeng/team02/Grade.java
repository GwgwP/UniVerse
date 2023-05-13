package gr.aueb.softeng.team02;

import java.util.ArrayList;

public class Grade {
    private double grade;

    public Grade(double grade) {
        this.grade = grade;
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
