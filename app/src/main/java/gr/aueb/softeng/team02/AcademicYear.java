package gr.aueb.softeng.team02;

import java.util.*;

public class AcademicYear {
    private String ac_year;
    // lydia
    private Map<Integer, Circumscription> circList;

    public AcademicYear(String ac_year) {
        this.ac_year = ac_year;
        this.circList = new HashMap<Integer, Circumscription>();
    }

    public void setAc_year(String ac_year) {
        this.ac_year = ac_year;
    }

    public String getAc_year() {
        return ac_year;
    }

    public void addCircumscription(Circumscription c) throws IllegalAccessException {
        // TODO throw exception if there is a previous circumscription in the semester
        // Only one circumscription per semester
        if (c != null) {
            if (this.circList.get(c.getSemester()) != null) {
                throw new IllegalAccessException();
            } else {
                this.circList.put(c.getSemester(), c);
            }
        }
    }
    /**
     * get the circumscription depending on the semester.
     */
    public Circumscription getCircumscription(int semester) throws IllegalAccessException {
        // TODO Throw exception if there is no circumscription on the specific semester
        // Only one circumscription per semester
        if (this.circList.get(semester) == null) {
            throw new IllegalAccessException();
        } else  {
            return this.circList.get(semester);
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

        if (!(other instanceof AcademicYear)) {
            return false;
        }
        //TODO: Check if there are other parameters to check the equality between two objects
        AcademicYear year = (AcademicYear) other;
        return (this.ac_year.equals(year.ac_year));
    }

    @Override
    public int hashCode() {
        return this.ac_year.hashCode();
    }
}
