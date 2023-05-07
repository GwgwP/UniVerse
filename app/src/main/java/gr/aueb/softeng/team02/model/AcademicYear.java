package gr.aueb.softeng.team02.model;

public class AcademicYear {

    private String  ac_year;
    // Key: No of Semester --> Value: Circumscription
    private Map<Integer, Circumscription> circList;
    private ArrayList<OfferedSubject> offeredSubjectList;
    // what we are going to do with the submission

    public AcademicYear(String ac_year) {
        this.ac_year = ac_year;
        this.ac_year = new HashMap<>();
        this.offeredSubjectList = new ArrayList<>();
    }
    
    public HashMap<Interger, Circumscription> getCircList() {
        return circList;
    }

    public ArrayList<OfferedSubject> getOfferedSubjectList() {
        return this.offeredSubjectList;
    }

    public void setAc_year(int ac_year) {
        this.ac_year = ac_year;
    }

    public void addOfferedSubject(OfferedSubject sub) {
        this.offeredSubjectList.add(sub);
    }

    public int getAc_year() {
        return ac_year;
    }

    public 

    public void addCircumscription(Circumscription cic) {
        int sem = cic.getSemester();
        if (!this.circList.get(sem)) {
            this.circList.put(sem, cic);
        }
        //TODO : JU TESTING 
    }
}
