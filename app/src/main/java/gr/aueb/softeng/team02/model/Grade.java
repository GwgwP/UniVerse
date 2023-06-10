package gr.aueb.softeng.team02.model;

public class Grade {
    private int grade;
    private Student stud;
    private OfferedSubject subject;

    /**
     * Default constructor for Grade
     */
    public Grade() {
    }

    /**
     * Constructor of the Grade
     *
     * @param st    student object
     * @param os    offeredSubject object
     * @param grade Grade as an integer from 0 to 10
     */
    public Grade(Student st, OfferedSubject os, int grade) {
        this.stud = st;
        this.subject = os;
        this.grade = grade;
    }

    /**
     * Copy Constructor for Grade
     *
     * @param g grade as an Grade object
     */
    public Grade(Grade g) {
        this.stud = g.stud;
        this.subject = g.subject;
        this.grade = g.grade;
    }

    /**
     * Get the grade of a student for an offered subject
     *
     * @return a grade as an integer
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Set the grade of an offered subject of a student
     *
     * @param grade the grade as an integer
     * @throws RuntimeException in case the grade is greater than 10 or smaller than 0
     */
    public void setGrade(int grade) throws RuntimeException {
        if (grade < 0 || grade > 10) {
            throw new RuntimeException("Invalid grade");
        }
        this.grade = grade;
    }

    /**
     * Set the student who gave this subject
     *
     * @param stud a student object
     */
    public void setStudent(Student stud) {
        this.stud = stud;
    }

    /**
     * Get the student id of the student who gave this subject
     *
     * @return a student id as an integer
     */
    public int getStudentId() {
        return this.stud.getId();
    }

    /**
     * Get the title of the offered subject
     *
     * @return the title as a string
     */
    public String getTitle() {
        return this.subject.getTitle();
    }

    /**
     * Get the academic year of the offered subject
     *
     * @return an AcademicYear object
     */
    public AcademicYear getAcademicYear() {
        return this.subject.getYear();
    }

    /**
     * Set the offered subject
     *
     * @param sub the offered subject as an OfferedSubject object
     */
    public void setSubject(OfferedSubject sub) {
        this.subject = sub;
    }

    /**
     * Get the offered subject
     *
     * @return the offered subject as an OfferedSubject object
     */
    public OfferedSubject getSubject() {
        return this.subject;
    }

    /**
     * Get the title of the offered subject
     *
     * @return the title as a string
     */
    public String getSubjectTitle() {
        return this.subject.getTitle();
    }

    /**
     * Get the Semester of the offered subject
     *
     * @return the semester as an integer
     */
    public int getSemester() {
        return this.subject.getSemester();
    }

    /**
     * Comparing the grade with another object
     * There is an equality if the student and the subject (not the offered subject)
     * is the same
     *
     * @param other an object that can be of every type
     * @return a boolean true or false
     */
    @Override
    public boolean equals(Object other) {
        // TODO CHECK IT LATER IF IT IS NEEDED
        if (other == null)
            return false;
        if (this == other)
            return true;
        if (!(other instanceof Grade))
            return false;
        Grade grade1 = (Grade) other;
        return (this.subject.getSubject().equals(grade1.getSubject().getSubject()) && this.stud.equals(grade1.stud));
    }
}
