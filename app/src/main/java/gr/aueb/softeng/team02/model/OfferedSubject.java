import javax.security.auth.Subject;

public class OfferedSubject {

    private Subject sub; // maybe 
    private int semester;
    private String ac_year; 
    private ArrayList<Subject> offeredSub = new ArrayList<>();

    public OfferedSubject(int semester, String ac_year){
        this.semester = semester;
        this.ac_year = ac_year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getAc_year() {
        return ac_year;
    }

    public void setAc_year(String ac_year) {
        this.ac_year = ac_year;
    }

    public ArrayList<Subject> getOfferedSub() {
        return offeredSub;
    }

    public void addOfferedSub(Subject sub) {
        this.offeredSub.add(sub);
    }

    
}
