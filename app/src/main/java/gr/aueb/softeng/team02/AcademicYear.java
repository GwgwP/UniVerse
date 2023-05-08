// package gr.aueb.softeng.team02;
import java.util.*;
public class AcademicYear {
    private String ac_year;
    // private Set<Circumscription> circList;
    public AcademicYear(String ac_year) {
        this.ac_year = ac_year;
        // this.circList = new HashSet<Circumscription>();
    }
    public void setAc_year(String ac_year) {
        this.ac_year = ac_year;
    }

    public String getAc_year() {
        return ac_year;
    }

//    public void addCircumscription(Circumscription cic) {
//        int sem = cic.getSemester();
//        if (this.circList.get(sem) == null) {
//            this.circList.put(sem, cic);
//        }
//        //TODO : JU TESTING
//    }
}
