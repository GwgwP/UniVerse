package gr.aueb.softeng.team02.model;

import java.util.*;

public class Subject {
    private int id;
    private String professor;
    private int ects;
    private String desc;
    private String title;
    private Set<Subject> prerequisities;

    /**
     * Constructor of Subject
     *
     * @param professor the professor of the subject as a string
     * @param ects      the ects of the subject as an integer
     * @param desc      the description of the subject as a string
     * @param title     the title of the subject as a string
     */
    public Subject(String professor, int ects, String desc, String title) {
        this.id = 0;
        this.professor = professor;
        this.ects = ects;
        this.desc = desc;
        this.title = title;
        this.prerequisities = new HashSet<>();
    }

    /**
     * Get a set of the prerequisites of the subject
     *
     * @return a set of the prerequisites of the subject
     */
    public Set<Subject> getPrerequisities() {
        return this.prerequisities;
    }

    /**
     * Add a subject as a prerequisite
     *
     * @param sub the prerequisite subject
     * @throws Exception if the prerequisite is already registered
     */
    public void addPrerequisities(Subject sub) throws Exception {
        if (!this.prerequisities.add(sub))
            throw new Exception("Already in the set");
    }

    /**
     * Get the id of the subject
     *
     * @return the id as an integer
     */
    public int getId() {
        return this.id;
    }

    /**
     * Set the id of the student
     *
     * @param id the id of the student as an integer
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the professor of the subject
     *
     * @return the professor as a string
     */
    public String getProfessor() {
        return this.professor;
    }

    /**
     * Set the professor of the subject
     *
     * @param professor the professor as a string
     */
    public void setProfessor(String professor) {
        this.professor = professor;
    }

    /**
     * Get the Ects of the subject
     *
     * @return the ects as an integer
     */
    public int getECTS() {
        return this.ects;
    }

    /**
     * Set the ects of the subject
     *
     * @param ects the ects of the subject as an integer
     */
    public void setECTS(int ects) {
        this.ects = ects;
    }

    /**
     * Get the description of the subject
     *
     * @return the description as a string
     */
    public String getDesc() {
        return this.desc;
    }

    /**
     * Set the description of the subject
     *
     * @param desc the description of the subject as a string
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Get the title of the subject
     *
     * @return the title as a string
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Set the title of the subject
     *
     * @param title the title a string
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Check if there is a null attribute or zero ects. If that's the case, return false, else true
     *
     * @return true or false based on the criteria
     */
    public boolean checkFields() {
        return this.title != null && this.desc != null && this.ects > 0 && this.professor != null;
    }

    /**
     * Compare a subject with another object. If they have the same title then they are equal
     *
     * @param other a different object
     * @return true or false based on the criteria
     */
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

    /**
     * Get the hash code of the subject based on the title of the subject
     *
     * @return the hash code of the subject as an integer
     */
    @Override
    public int hashCode() {
        return this.title.hashCode();
    }

}
