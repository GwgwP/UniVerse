package gr.aueb.softeng.team02;

public class OfferedSubject {
    private Subject sub;
    private int semester;
    private Grade grade;

    private AcademicYear ac_year;

    public OfferedSubject(int semester, AcademicYear year) {
        this.semester = semester;
        this.ac_year = year;
        this.grade = null;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public AcademicYear getAc_year() {
        return ac_year;
    }

    public void setAc_year(AcademicYear ac_year) {
        this.ac_year = ac_year;
    }

    public void setGrade(int grade) {
        this.grade = new Grade(grade);
    }

    public Grade getGrade() {
        return this.grade;
    }

    public int getSubjectId() {
        return this.sub.getId();
    }

    public int getEcts() {
        return this.sub.getECTS();
    }


//   /* MAYBE THIS IS DAO's JOB
//    *
//    * Use: to check if there is a duplicate offered subject registration from the secretary.
//    * check if two OfferedSubject objects have the same semester, year and subject.
//    *
//    *
//    *                                                                                       */
//    @Override
//    public boolean equals(Object other) {
//        if (other == null) {
//            return false;
//        }
//
//        if (this == other) {
//            return true;
//        }
//
//        if (!(other instanceof OfferedSubject)) {
//            return false;
//        }
//        //TODO: Check if there are other parameters to check the equality between two objects
//        OfferedSubject subject = (OfferedSubject) other;
//        return (this.semester == subject.semester && this.ac_year == subject.ac_year && this.sub == subject.sub);
//    }
    /*
     * UC4: 8a
     * */
    public boolean checkSameAcYear(OfferedSubject subject)
    {
       return(this.sub.equals(subject.sub) && this.ac_year.equals(subject.getAc_year()));
    }

    @Override
    public String toString() {
        return this.sub.toString();
    }
}
