package gr.aueb.softeng.team02.model;

import java.time.LocalDate;
import java.util.Date;

public class Circumscription {
    private int ects;
    private int semester;
    private LocalDate start;
    private LocalDate end;

    /**
     * Constructor of Circumscription
     *
     * @param semester the semester of the circumscription as an integer
     * @param ects     the ects of the circumscription as an integer
     * @param start    the start date of the submission upload day
     * @param end      the end date of the submission upload day
     */
    public Circumscription(int semester, int ects, LocalDate start, LocalDate end) {
        this.ects = ects;
        this.semester = semester;
        this.start = start;
        this.end = end;
    }

    /**
     * Set the ects of the circumscription
     *
     * @param ects the ects as an integer
     */
    public void setEcts(int ects) {
        this.ects = ects;
    }

    /**
     * Get the ects of the circumscription
     *
     * @return ects as an integer
     */
    public int getEcts() {
        return this.ects;
    }

    /**
     * Get the semester of the circumscription
     *
     * @param semester the semester as an integer
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     * Get the semester of the circumscription
     * @return the semester as an integer
     */
    public int getSemester() {
        return this.semester;
    }

    /**
     * Get the start date of the submission upload
     * @return a local date object
     */
    public LocalDate getStart() {
        return start;
    }

    /**
     * Set the start date of the submission upload
     * @param start a local date object
     */
    public void setStart(LocalDate start) {
        this.start = start;
    }

    /**
     * Get the end date of the submission upload
     * @return a local date object
     */
    public LocalDate getEnd() {
        return end;
    }

    /**
     * Set the end date for the submission upload
     * @param end a local date object
     */
    public void setEnd(LocalDate end) {
        this.end = end;
    }

    /**
     * Check the validity of the circumscription, if the ects are between 30 & 130 and also the semester is a valid integer
     * @return true or false
     */
    public boolean checkValidity() {
        return this.ects >= 30 && this.ects <= 130 && this.semester >= 1 && this.semester <= 8;
    }
}
