package gr.aueb.softeng.team02.model;

import java.time.LocalDate;
import java.util.Date;

public class Circumscription {
    private int ects;
    private int semester;
    private LocalDate start;
    private LocalDate end;

    public Circumscription(int semester, int ects, LocalDate start, LocalDate end) {
        this.ects = ects;
        this.semester = semester;
        this.start = start;
        this.end = end;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public int getEcts() {
        return this.ects;
    }

    public void setSemester(int semester) throws Exception {
        this.semester = semester;
    }

    public int getSemester() {
        return this.semester;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public boolean checkValidity() {
        return this.ects >= 30 && this.ects <= 130 && this.semester >= 1 && this.semester <= 8;
    }
}
