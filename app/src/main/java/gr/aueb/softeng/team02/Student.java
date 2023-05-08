// package gr.aueb.softeng.team02;

import java.util.*;

public class Student extends User {
    private int semester;
    private Set<Submission> submissions;
    public Student(int id, String username, String password, String name, String surname, int semester, int am) {
        super(id, username, password, name, surname);
        this.semester = semester;
        this.submissions = new HashSet<>();
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setSubmission(Submission sub) {
        this.submissions.add(sub);
    }
}
