package gr.aueb.softeng.team02.model;

import java.util.*;

public class Submission {
    private AcademicYear year;
    private Student student;
    private int semester;
    private Set<OfferedSubject> chosenSubjects;

    public Submission() {
        this.chosenSubjects = new HashSet<>();
    }

    public Submission(AcademicYear year, int semester, Student student) {
        this.year = year;
        this.semester = semester;
        this.student = student;
        this.chosenSubjects = new HashSet<OfferedSubject>();
    }

    public AcademicYear getAcademicYear() {
        return this.year;
    }

    public void setAcademicYear(AcademicYear year) {
        this.year = year;
    }

    public int getStudentId() {
        return this.student.getId();
    }
    public Student getStudent(){return this.student;}

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Set<OfferedSubject> getChosenSub() {
        return chosenSubjects;
    }

    public void addChosenSub(OfferedSubject sub) throws Exception {
        // If one subject is chosen, then it cannot be selected again. Implement it with UI
        if (this.chosenSubjects.contains(sub) || sub == null) {
            throw new Exception();
        }
        // calculate Ects
        int sum = this.calculateECTS() + sub.getEcts();
        int maxEcts = this.year.getEctsPerSemester(this.semester);

        if (sum <= maxEcts)
            this.chosenSubjects.add(sub);
        else
            throw new Exception("Number of ects exceeded the maximum");
    }

    public int calculateECTS() {
        int sum = 0;
        for (OfferedSubject sub : this.chosenSubjects) {
            sum += sub.getEcts();
        }
        return sum;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (this == other)
            return true;
        if (!(other instanceof Submission))
            return false;

        Submission sub = (Submission) other;
        return (this.year.equals(((Submission) other).getAcademicYear()) && this.student.getId() == ((Submission) other).getStudentId() && this.semester == sub.semester);
    }
}
