package gr.aueb.softeng.team02.model;

import javax.security.auth.Subject;

public class OfferedSubject {

    private Subject sub;
    private int semester;
    private Grade grade;

    public OfferedSubject(int semester) {
        this.semester = semester;
        this.grade = null;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setGrade(int grade) {
        this.grade = new Grade(grade);
    }

    public Grade getGrade() {
        return this.grade;
    }

    @Override
    public String toString() {
        return this.sub.toString();
    }

}
