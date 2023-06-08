package gr.aueb.softeng.team02.model;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;

public class AcademicYear {
    private String ac_year;
    private Map<Integer, Circumscription> circList;

    private LocalDate gradeDateEven;
    private LocalDate gradeDateOdd;

    public AcademicYear() {
        this.circList = new HashMap<>();
    }
    public AcademicYear(String ac_year, LocalDate gradeDateEven, LocalDate gradeDateOdd) {
        this.ac_year = ac_year;
        this.circList = new HashMap<Integer, Circumscription>();
        this.gradeDateEven = gradeDateEven;
        this.gradeDateOdd = gradeDateOdd;
    }

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

    public String getAc_year() {
        return ac_year;
    }

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

    public Circumscription getCircumscription(int semester) throws AcademicYearException {
        if (this.circList.get(semester) != null)
            return this.circList.get(semester);
        else
            throw new AcademicYearException("No circumsciption for this year");
    }

    public int getEctsPerSemester(int semester) throws AcademicYearException {
        return this.getCircumscription(semester).getEcts();
    }

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

    @Override
    public int hashCode() {
        return this.ac_year.hashCode();
    }

    public LocalDate getGradeDateEven() {
        return gradeDateEven;
    }

    public LocalDate getGradeDateOdd() {
        return gradeDateOdd;
    }
}
