// package gr.aueb.softeng.team02;
import java.util.*;

public class Subject {
    private int id;
    private String professor;
    private int ects;
    private String desc;
    private String title;
    private Set<Subject> prerequisities;

    public Subject(int id, String Professor, int ects, String desc, String title) {
        this.id = id;
        this.professor = professor;
        this.ects = ects;
        this.desc = desc;
        this.title = title;
        this.prerequisities = new HashSet<>();
    }
    
    public Set<Subject> getPrerequisities() {
        return this.prerequisities;
    }

    public void addPrerequisities(Subject sub) {
        this.prerequisities.add(sub);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfessor() {
        return this.professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getECTS() {
        return this.ects;
    }

    public void setECTS(int ects) {
        this.ects = ects;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean checkFields() {
        // TODO Check if there are others parameters to check for every variable
        // Eg : if ects >= 30 & ects < = limit
        if (this.title == null || this.desc == null || this.ects <= 0 || this.professor == null || this.id <= 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (this == other) {
            return true;
        }

        if (!(other instanceof Subject)) {
            return false;
        }
        // TODO Check if there are other parameters to check the equality between two objects
        Subject subject = (Subject) other;
        return this.id == subject.id;
    }
    @Override
    public int hashCode() {
        // TODO Check if it is needed and how
        return this.id;
    }
}
