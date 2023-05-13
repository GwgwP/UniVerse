package gr.aueb.softeng.team02;

import java.util.*;

public class Student extends User {
    private int semester;

    public Student(int id, String username, String password, String name, String surname, int semester) {
        super(id, username, password, name, surname);
        this.semester = semester;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
