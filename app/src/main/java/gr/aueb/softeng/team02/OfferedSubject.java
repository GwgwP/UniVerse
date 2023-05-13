package gr.aueb.softeng.team02;

public class OfferedSubject {
    private Subject sub;
    private int semester;
    private Grade grade;
    private AcademicYear year;

    public OfferedSubject(int semester) {
        this.semester = semester;
        this.grade = null;
    }

    public void setSub(Subject sub) {
        this.sub = sub;
    }

    public String getProf() {
        return this.sub.getProfessor();
    }

    public AcademicYear getYear() {
        return this.year;
    }

    public void setYear(AcademicYear year) {
        this.year = year;
    }

    public String getTitle() {
        return this.sub.getTitle();
    }

    public String getDesc() {
        return this.sub.getDesc();
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setGrade(int grade) {
        this.grade = new Grade(grade);
    }

    public Grade getGrade() {
        return this.grade;
    }

    public int getEcts() {
        return this.sub.getECTS();
    }

    @Override
    public String toString() {
        return this.sub.toString();
    }
}
