package gr.aueb.softeng.team02.model;

import java.util.*;

public class Student extends User {
    private int semester;
    private double avg;
    private int numPassed;

    private int totalEcts;
    private Map<Integer, Double> avgPerSemester;

    public Student() {}

    public Student(int id, String username, String password, String name, String surname, int semester) {
        super(id, username, password, name, surname);
        this.semester = semester;
        this.avgPerSemester = new HashMap<>();
    }

    public void setAvgPerSemester(int semester, double avg) throws StudentException {
        if (semester > 8 || semester < 1)
            throw new StudentException("Invalid semester");
        this.avgPerSemester.put(semester, avg);
    }

    public Map<Integer, Double> getAvgPerSemester() {
        return this.avgPerSemester;
    }

    public Double getAvgBySpecificSemester(int semester) throws StudentException {
        if (this.getAvgPerSemester().get(semester) == null) {
            throw new StudentException("nullSemester");
        } else {
            return this.avgPerSemester.get(semester);
        }
    }

    public double getAvg() {
        return this.avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public int getNumPassed() {
        return this.numPassed;
    }

    public void setNumPassed(int numPassed) {
        this.numPassed = numPassed;
    }

    public int getTotalEcts() {
        return this.totalEcts;
    }

    public void setTotalEcts(int totalEcts) {
        this.totalEcts = totalEcts;
    }

    public void updateAvg(double score, int passed) {
        this.avg = (this.avg * this.numPassed + score) / (this.numPassed + passed);
        this.numPassed = this.numPassed + passed;
    }

    public void updateEcts(int Ects) {
        this.totalEcts += Ects;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (this == other) {
            return true;
        }

        if (!(other instanceof Student)) {
            return false;
        }

        Student newOne = (Student) other;
        return this.getId() == newOne.getId();
    }

    @Override
    public int hashCode() {
        return this.getId();
    }
}
