package gr.aueb.softeng.team02;

import java.util.Date;

public class Circumscription {
    private int ects;
    private int semester;
    private Date start;
    private Date end;

    public Circumscription() {
    }

    public Circumscription(int semester, int ects) {
        this.ects = ects;
        this.semester = semester;
    }

    public void setEcts(int ects) {
        this.ects = ects;
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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public boolean checkValidity() {
        return this.ects >= 30 && this.ects <= 130 && this.semester > 0 && this.semester <= 8;
    }

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
//        if (!(other instanceof Circumscription)) {
//            return false;
//        }
//
//        return this.semester == ((Circumscription) other).semester;
//    }
}
