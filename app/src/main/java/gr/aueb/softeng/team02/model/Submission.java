public class Submission {

    private static int Gid = 0;
    private int id;
    private int semester;
    private ArrayList<OfferedSubject> chosenSub = new ArrayList<>();
    private String ac_year;

    public Submission(int semester, String ac_year) {
        this.id = Submission.Gid++;
        this.semester = semester;
        this.ac_year = ac_year;
    }

    public String getAc_year() {
        return ac_year;
    }

    public void setAc_year(String ac_year) {
        this.ac_year = ac_year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public ArrayList<Subject> getChosenSub() {
        return chosenSub;
    }

    public void addChosenSub(Subject sub) {
        this.chosenSub.add(sub);
    }

}
