package gr.aueb.softeng.team02.model;

import java.util.*;

public class Submission {
    private AcademicYear year;
    private Student student;
    private int semester;
    private Set<OfferedSubject> chosenSubjects;

    /**
     * Default Constructor
     */
    public Submission() {
        this.chosenSubjects = new HashSet<>();
    }

    /**
     * Constructor of Submission
     *
     * @param year     the year that the submission has been registered as an academic year object
     * @param semester the semester that the submission has been registered as an integer
     * @param student  the student that has registered the submission as a student object
     */
    public Submission(AcademicYear year, int semester, Student student) {
        this.year = year;
        this.semester = semester;
        this.student = student;
        this.chosenSubjects = new HashSet<OfferedSubject>();
    }

    /**
     * Get the academic year of the submission
     *
     * @return the year as an AcademicYear object
     */
    public AcademicYear getAcademicYear() {
        return this.year;
    }

    /**
     * Set the academic year of the submission
     *
     * @param year the year as an AcademicYear object
     */
    public void setAcademicYear(AcademicYear year) {
        this.year = year;
    }

    /**
     * Get the student id of the student
     *
     * @return the student id as an integer
     */
    public int getStudentId() {
        return this.student.getId();
    }

    /**
     * Get the student of the submission
     *
     * @return the student as a student object
     */
    public Student getStudent() {
        return this.student;
    }

    /**
     * Set the student of the submission
     *
     * @param student the student as a student object
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * Get the semester of the submission
     *
     * @return the semester as an integer
     */
    public int getSemester() {
        return semester;
    }

    /**
     * Set the semester of the submission
     *
     * @param semester the submission as an integer
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     * Get a set of the preselected subjects
     *
     * @return a set of offered subject objects
     */
    public Set<OfferedSubject> getChosenSub() {
        return chosenSubjects;
    }

    /**
     * Add a chosen subject in the list
     *
     * @param sub the selected subject as a subject object
     * @throws Exception in case the subject has been preselected
     */
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

    /**
     * Calculare the ects of the selected subjects
     *
     * @return the number of the ects as an integer
     */
    public int calculateECTS() {
        int sum = 0;
        for (OfferedSubject sub : this.chosenSubjects) {
            sum += sub.getEcts();
        }
        return sum;
    }

    /**
     * Compare a submission with another object. Two submissions are equal when they have been registered in the same academic year from the same student and in the same semester
     *
     * @param other a different object
     * @return true or false based on the criteria
     */
    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (this == other)
            return true;
        if (!(other instanceof Submission))
            return false;

        Submission sub = (Submission) other;
        return (this.year.equals(sub.getAcademicYear()) && this.student.getId() == sub.getStudentId() && this.semester == sub.semester);
    }
}
