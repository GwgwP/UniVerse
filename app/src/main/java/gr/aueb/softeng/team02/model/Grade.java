package gr.aueb.softeng.team02.model;

public class Grade {
    private int grade;
    private Student stud;
    private OfferedSubject subject;

    public Grade() {
    }

    public Grade(Grade g) {
        this.stud = g.stud;
        this.subject = g.subject;
        this.grade = g.grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) throws RuntimeException {
        if (grade < 0 || grade > 10) {
            throw new RuntimeException("Invalid grade");
        }
        this.grade = grade;
    }

    public void setStudent(Student stud) {
        this.stud = stud;
    }

    public int getStudentId() {
        return this.stud.getId();
    }

    public AcademicYear getAcademicYear() {
        return this.subject.getYear();
    }

    public void setSubject(OfferedSubject sub) {
        this.subject = sub;
    }

    public OfferedSubject getSubject() {
        return this.subject;
    }

    @Override
    public boolean equals(Object other) {
        // TODO CHECK IT LATER IF IT IS NEEDED
        if (other == null)
            return false;
        if (this == other)
            return true;
        if (!(other instanceof Grade))
            return false;
        Grade grade1 = (Grade) other;
        return (this.grade == grade1.grade);
    }
}
