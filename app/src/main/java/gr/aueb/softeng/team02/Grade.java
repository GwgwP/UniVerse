package gr.aueb.softeng.team02;

import java.util.ArrayList;

public class Grade {
    private float grade;

    public Grade(float grade) {
        this.grade = grade;
    }
    public double getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        // TODO Check exceptions cases and throws exception classes
        if (grade < 0 || grade > 10) {
            throw new RuntimeException("Invalid grade");
        }
        this.grade = grade;
    }
}
