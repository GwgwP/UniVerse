package gr.aueb.softeng.team02.model.view.Progress.ProgressForm;

import java.util.HashMap;

import gr.aueb.softeng.team02.view.Progress.ProgressForm.ProgressView;

public class ProgressFormViewTest implements ProgressView {

    private double average, av1, av2, av3, av4, av5, av6, av7, av8;

    public double getAv1() {
        return av1;
    }

    public void setAv1(double av1) {
        this.av1 = av1;
    }

    public double getAv2() {
        return av2;
    }

    public void setAv2(double av2) {
        this.av2 = av2;
    }

    public double getAv3() {
        return av3;
    }

    public void setAv3(double av3) {
        this.av3 = av3;
    }

    public double getAv4() {
        return av4;
    }

    public void setAv4(double av4) {
        this.av4 = av4;
    }

    public double getAv5() {
        return av5;
    }

    public void setAv5(double av5) {
        this.av5 = av5;
    }

    public double getAv6() {
        return av6;
    }

    public void setAv6(double av6) {
        this.av6 = av6;
    }

    public double getAv7() {
        return av7;
    }

    public void setAv7(double av7) {
        this.av7 = av7;
    }

    public double getAv8() {
        return av8;
    }

    public void setAv8(double av8) {
        this.av8 = av8;
    }

    public int getNumber_of_passed_subjects() {
        return number_of_passed_subjects;
    }

    public void setNumber_of_passed_subjects(int number_of_passed_subjects) {
        this.number_of_passed_subjects = number_of_passed_subjects;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public HashMap<Integer, Double> getAv_grades() {
        return av_grades;
    }

    public void setAv_grades(HashMap<Integer, Double> av_grades) {
        this.av_grades = av_grades;
    }

    private int number_of_passed_subjects, ects, student_id;
    HashMap<Integer, Double> av_grades;

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }


    @Override
    public void showAverage(double avg) {
        this.average = avg;
    }

    @Override
    public void showAveragePerSemester(HashMap<Integer, Double> av_grades) {
        if (av_grades.containsKey(1)) {
            this.av1 = av_grades.get(1);
        }
        if (av_grades.containsKey(2)) {
            this.av2 = av_grades.get(2);
        }
        if (av_grades.containsKey(3)) {
            this.av3 = av_grades.get(3);
        }
        if (av_grades.containsKey(4)) {
            this.av4 = av_grades.get(4);
        }
        if (av_grades.containsKey(5)) {
            this.av5 = av_grades.get(5);
        }
        if (av_grades.containsKey(6)) {
            this.av6 = av_grades.get(6);
        }
        if (av_grades.containsKey(7)) {
            this.av7 = av_grades.get(7);
        }
        if (av_grades.containsKey(8)) {
            this.av8 = av_grades.get(8);
        }

    }

    @Override
    public void showNumPassed(int num) {
        this.number_of_passed_subjects = num;
    }

    @Override
    public void showDetailedGrades() {

    }

    @Override
    public void showECTS(int num) {
        this.ects = num;
    }
}
