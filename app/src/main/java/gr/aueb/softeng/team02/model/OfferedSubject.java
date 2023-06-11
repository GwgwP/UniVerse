package gr.aueb.softeng.team02.model;

public class OfferedSubject {
    private Subject sub;
    private int semester;
    private AcademicYear year;

    /**
     * Constructor of the OfferedSubject
     *
     * @param semester the semester as an integer
     * @param subject  the subject as a Subject object
     * @param year     the year as an AcademicYear object
     */
    public OfferedSubject(int semester, Subject subject, AcademicYear year) {
        this.semester = semester;
        this.sub = subject;
        this.year = year;
    }

    /**
     * Constructor of the OfferedSubject
     *
     * @param semester the semester as an integer
     */
    public OfferedSubject(int semester) {
        this.semester = semester;
    }

    /**
     * Set the subject
     *
     * @param sub a Subject object
     */
    public void setSub(Subject sub) {
        this.sub = sub;
    }

    /**
     * Get the professor of the subject
     *
     * @return the professor as a string
     */
    public String getProf() {
        return this.sub.getProfessor();
    }

    /**
     * Get the Academic Year of the offered subject
     *
     * @return an AcademicYear object
     */
    public AcademicYear getYear() {
        return this.year;
    }

    /**
     * Get the time stamp of the academic year
     *
     * @return a time stamp as a string
     */
    public String getAcademicYearINString() {
        return this.year.getAc_year();
    }

    /**
     * Set the academic year of the offered subject
     *
     * @param year an AcademicYear object
     * @throws Exception in case the year is null
     */
    public void setYear(AcademicYear year) throws Exception {
        if (year.getAc_year() == null)
            throw new Exception("Year has not been initialized");
        this.year = year;
    }

    /**
     * Get the title of the subject
     *
     * @return the title as a string
     */
    public String getTitle() {
        return this.sub.getTitle();
    }

    /**
     * Get the description of the subject
     *
     * @return the description as a string
     */
    public String getDesc() {
        return this.sub.getDesc();
    }

    /**
     * Get the semester of the offered subject
     *
     * @return the semester as an integer
     */
    public int getSemester() {
        return semester;
    }

    /**
     * Get the semester of the offered subject
     *
     * @param semester the semester as a string
     * @throws Exception in case the semester is bigger than 8 or smaller than 1
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getEcts() {
        return this.sub.getECTS();
    }

    /**
     * Get the subject of the offered subject
     *
     * @return a Subject object
     */
    public Subject getSubject() {
        return this.sub;
    }

    /**
     * Compare the offered subject with a different object. If they have the same academic year and the same subjects,
     * then they are equal
     *
     * @param other A different object or maybe the same
     * @return true or false depending on the equality
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (this == other) {
            return true;
        }

        if (!(other instanceof OfferedSubject)) {
            return false;
        }

        OfferedSubject subject = (OfferedSubject) other;
        // check two conditions
        /*
         * Check two conditions for equality
         * 1. Academic Year
         * 2. Subject (title)
         * !!! Not semester because we want an offered subject only once in the academic year !!!*/
        return (this.year.getAc_year().equals(subject.getAcademicYearINString()) && this.sub.equals(subject.getSubject()));
    }
}
