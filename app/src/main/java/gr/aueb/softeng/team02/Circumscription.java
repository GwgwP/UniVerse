// package gr.aueb.softeng.team02;

public class Circumscription {
    private int ects;
    private int semester;

    public Circumscription() {}
    public Circumscription(int semester, int Ects) {
        this.ects = Ects;
        this.semester = semester;
    }

    public void setEcts(int Ects) {
        this.ects = Ects;
    }

    public int getEcts() {
        return this.ects;
    }

    public void setSemester(int Semester) {
        this.semester = semester;
    }

    public int getSemester() {
        return this.semester;
    }

    public boolean checkValidity() {
        if (this.ects < 30 || this.ects > 130 || this.semester == 0) {
            return false;
        }
        return true;
    }
}
