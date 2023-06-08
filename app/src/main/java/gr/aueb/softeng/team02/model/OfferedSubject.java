package gr.aueb.softeng.team02.model;

public class OfferedSubject {
    private Subject sub;
    private int semester;
    private AcademicYear year;

    public OfferedSubject(int semester, Subject subject, AcademicYear year) {
        this.semester = semester;
        this.sub = subject;
        this.year = year;
    }

    public OfferedSubject(int semester) {
        this.semester = semester;
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

    public String getAcademicYearINString() {return this.year.getAc_year();}

    public void setYear(AcademicYear year) throws Exception {
        if (year.getAc_year() == null)
            throw new Exception("Year has not been initialized");
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

    public void setSemester(int semester) throws Exception {
        if (semester > 8 || semester < 1) {
            throw new Exception("Invalid value of semester");
        }
        this.semester = semester;
    }

    public int getEcts() {
        return this.sub.getECTS();
    }

    public Subject getSubject() {
        return this.sub;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (this == other) {
            return true;
        }

        if (!(other instanceof OfferedSubject)) {
            return false;
        }

        OfferedSubject subject = (OfferedSubject) other;
        // check two conditions
        /*
        * Check two conditions for equality
        * 1. Academic Year
        * 2. Subject (title)
        * !!! Not semester because we want an offered subject only once in the academic year !!!*/
        return (this.year.getAc_year().equals(subject.getAcademicYearINString()) && this.sub.equals(subject.getSubject()));
    }
}
