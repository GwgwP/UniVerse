package gr.aueb.softeng.team02.model;

import java.util.*;

public class Subject {
    private int id;
    private String professor;
    private int ects;
    private String desc;
    private String title;
    private Set<Subject> prerequisities;

    public Subject(int id, String professor, int ects, String desc, String title) {
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

    public void addPrerequisities(Subject sub) throws Exception {
        if (!this.prerequisities.add(sub))
            throw new Exception("Already in the set");
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
        // Eg : if ects >= 30 & ects < = limit
        return this.title != null && this.desc != null && this.ects > 0 && this.professor != null && this.id > 0;
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

        Subject subject = (Subject) other;
        return title.equals(subject.title);
    }

    @Override
    public int hashCode() {
        return this.id;
    }

}
