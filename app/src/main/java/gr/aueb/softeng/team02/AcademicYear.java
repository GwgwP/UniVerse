package gr.aueb.softeng.team02;
import java.util.*;
public class AcademicYear {
    private String ac_year;
    private Set<Circumscription> circList;
    public AcademicYear(String ac_year) {
        this.ac_year = ac_year;
        this.circList = new HashSet<Circumscription>();
    }
    public void setAc_year(String ac_year) {
        this.ac_year = ac_year;
    }

    public String getAc_year() {
        return ac_year;
    }

    public void addCircumscription(Circumscription c)
    {
//        for (Circumscription circ : this.circList) {
//            if (circ.equals(c)) {
//                this.circList.remove(circ);
//            }
//        }
        this.circList.removeIf(circ -> circ.equals(c));
        this.circList.add(c);
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


}
