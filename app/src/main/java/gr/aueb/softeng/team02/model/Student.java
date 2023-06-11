package gr.aueb.softeng.team02.model;

import java.util.*;

public class Student extends User {
    private int semester;
    /**
     * Default constructor
     */
    public Student() {
    }

    /**
     * Constructor of the Student
     *
     * @param id       the student id as an integer
     * @param username the username of the student as a string
     * @param password the password of the student as a string
     * @param name     the name of the student as a string
     * @param surname  the surname of the student as a string
     * @param semester the current semester of the student as an integer
     */
    public Student(int id, String username, String password, String name, String surname, int semester) {
        super(id, username, password, name, surname);
        this.semester = semester;
    }

    /**
     * Get the current semester of the student
     *
     * @return the semester as an integer
     */
    public int getSemester() {
        return semester;
    }

    /**
     * Set the current semester
     *
     * @param semester the semester as an integer
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     * Compare a student with another object. If they have the same id as student objects, they are the same
     *
     * @param other another object
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

        if (!(other instanceof Student)) {
            return false;
        }

        Student newOne = (Student) other;
        return this.getId() == newOne.getId();
    }

    /**
     * Get the hash code based in the id of the student
     *
     * @return the id of the student
     */
    @Override
    public int hashCode() {
        return this.getId();
    }
}
