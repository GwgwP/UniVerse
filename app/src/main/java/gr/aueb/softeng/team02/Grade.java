package gr.aueb.softeng.team02;

import java.util.ArrayList;

public class Grade {
    private int grade;

    public Grade() {
    }
    public Grade(Grade g) {
        this.grade = g.grade;
    }
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) throws RuntimeException {
        if (grade < 0 || grade > 10) {
            throw new RuntimeException("Invalid grade");
        }
        this.grade = grade;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (this == other)
            return true;
        if (!(other instanceof Grade))
            return false;
        Grade grade1 = (Grade) other;
        return (this.grade == grade1.grade);
    }
}
