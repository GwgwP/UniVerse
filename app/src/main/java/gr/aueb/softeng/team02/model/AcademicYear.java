package gr.aueb.softeng.team02.model;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;

public class AcademicYear {
    private String ac_year;
    private final Map<Integer, Circumscription> circList;

    private LocalDate gradeDateEven;
    private LocalDate gradeDateOdd;

    /**
     * Default constructor
     */
    public AcademicYear() {
        this.circList = new HashMap<>();
    }

    /**
     * Constructor with parameters : ac_year, gradeDateEven, gradeDateOdd
     *
     * @param ac_year       the time stamp of the academic year
     * @param gradeDateEven the day of the grade upload for the spring semester
     * @param gradeDateOdd  the day of the grade upload for the winter semeter
     */
    public AcademicYear(String ac_year, LocalDate gradeDateEven, LocalDate gradeDateOdd) {
        this.ac_year = ac_year;
        this.circList = new HashMap<>();//Integer, Circumscription>();
        this.gradeDateEven = gradeDateEven;
        this.gradeDateOdd = gradeDateOdd;
    }

    /**
     * A setter for the academic year time stamp
     *
     * @param ac_year the time stamp of the academic year
     * @throws AcademicYearException in case it is not in the right format
     */
    public void setAc_year(String ac_year) throws AcademicYearException {
        if (ac_year != null) {
            String regex = "\\d{4}-\\d{4}";
            if (Pattern.matches(regex, ac_year)) {
                this.ac_year = ac_year;
                return;
            }
        }
        throw new AcademicYearException("Invalid year");
    }

    /**
     * Get the time stamp of the academic year
     *
     * @return
     */
    public String getAc_year() {
        return ac_year;
    }

    /**
     * Adds a circumscription if it not contains in the circumscription hash map for a specific semester
     *
     * @param c a given circumscription
     * @throws AcademicYearException in case of : the new circumscription is not valid
     */
    public void addCircumscription(Circumscription c) throws AcademicYearException {
        if (c != null) {
            if (this.circList.get(c.getSemester()) != null)
                throw new AcademicYearException("There is already a circumscription for this semester");
            else if (c.checkValidity())
                this.circList.put(c.getSemester(), c);
            else
                throw new AcademicYearException("Invalid circumscription");
        } else
            throw new AcademicYearException("Invalid circumscription");
    }

    /**
     * Get the circumscription of thw academic year based on a semester
     *
     * @param semester the semester as a string
     * @return a circumscription object or null
     * @throws AcademicYearException if the circumscription doesn't exist in the academic year
     */
    public Circumscription getCircumscription(int semester) throws AcademicYearException {
        if (this.circList.get(semester) != null)
            return this.circList.get(semester);
        else
            throw new AcademicYearException("No circumsciption for this year");
    }

    public int getEctsPerSemester(int semester) throws AcademicYearException {
        return this.getCircumscription(semester).getEcts();
    }

    /**
     * Compares two objects based in the time stamp of the academic year
     *
     * @param other the other object
     * @return true or false
     */
    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (this == other)
            return true;
        if (!(other instanceof AcademicYear))
            return false;
        if (this.ac_year == null)
            return false;
        AcademicYear year = (AcademicYear) other;
        return (this.ac_year.equals(year.ac_year));
    }

    /**
     * A hash code based on the time stamp
     *
     * @return an integer
     */
    @Override
    public int hashCode() {
        return this.ac_year.hashCode();
    }

    /**
     * Get the grade upload day for the spring semester
     *
     * @return a local date object
     */
    public LocalDate getGradeDateEven() {
        return gradeDateEven;
    }

    /**
     * Get the grade upload day for the winter semester
     *
     * @return a local date object
     */
    public LocalDate getGradeDateOdd() {
        return gradeDateOdd;
    }
}
