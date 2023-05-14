package gr.aueb.softeng.team02;

import java.util.*;

public class Submission {

    private AcademicYear year;

    private Student student;
    private int semester;
    private Set<OfferedSubject> chosenSub;

    public Submission(AcademicYear year, int semester, Student student) {
        this.year = year;
        this.semester = semester;
        this.student = student;
        this.chosenSub = new HashSet<OfferedSubject>();
    }

    public AcademicYear getAcademicYear() {
        return this.year;
    }

    public void setAcademicYear(AcademicYear year) {
        this.year = year;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) throws Exception {
        if (semester > 8 || semester < 1)
            throw new Exception("Invalid value of semester");
        this.semester = semester;
    }

    public Set<OfferedSubject> getChosenSub() {
        return chosenSub;
    }

    public void setChosenSub(OfferedSubject sub) throws Exception {
        // If one subject is chosen, then it cannot be selected again. Implement it with UI
        if (this.chosenSub.contains(sub)) {
            throw new Exception();
        }
        this.chosenSub.add(sub);
    }

    private int calculateECTS() {
        int sum = 0;
        for (OfferedSubject sub : this.chosenSub) {
            sum += sub.getEcts();
        }
        return sum;
    }
}
