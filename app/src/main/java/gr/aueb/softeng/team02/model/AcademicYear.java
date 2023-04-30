public class AcademicYear {

    private String  ac_year;
    private HashMap<Integer, Circumscription> circList = new HashMap<>();
    
    public AcademicYear(String ac_year) {
        this.ac_year = ac_year;
    }
    
    public HashMap<Interger, Circumscription> getCircList() {
        return circList;
    }

    public void addCircumscription(Circumscription cic) {
        int sem = cic.getSemester();
        if (!this.circList.get(sem)) {
            this.circList.put(sem, cic);
        }
        //TODO : JU TESTING 

    }

    public void setAc_year(int ac_year) {
        this.ac_year = ac_year;
    }

    public int getAc_year() {
        return ac_year;
    } 
}
