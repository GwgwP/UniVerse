package gr.aueb.softeng.team02.model.view.Progress.ProgressForm;

import java.util.HashMap;

import gr.aueb.softeng.team02.view.Progress.ProgressForm.ProgressView;

public class ProgressFormViewStub implements ProgressView {

    private double average, av1, av2, av3, av4, av5, av6, av7, av8;

    private int number_of_passed_subjects;
    private int ects, num_ects_shown;
    private int student_id;
    private int times_shown_avgs;
    private int shown_passed_subjs;
    private int shown_avg;


    private int onseegrades;
    HashMap<Integer, Double> av_grades;
    public double getAv1() {
        return av1;
    }

    public void setAv1(double av1) {
        this.av1 = av1;
    }

    public int getEctsShown()
    {
        return this.num_ects_shown;
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


    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }


    @Override
    public void showAverage(double avg) {
       // this.average = avg;
        this.shown_avg++;
    }


    public int getSizeOfAveragesPerSem()
    {
        return av_grades.size();
    }
    @Override
    public void showAveragePerSemester(HashMap<Integer, Double> av_grades) {
        this.times_shown_avgs++;
    }
    public int getOnseegrades() {
        return onseegrades;
    }


    @Override
    public void showNumPassed(int num) {
        this.shown_passed_subjs ++;
        //this.number_of_passed_subjects = num;
    }

    @Override
    public void showDetailedGrades() {
        this.onseegrades++;
    }

    @Override
    public void showECTS(int num) {
        this.num_ects_shown++;
    }

    public int getTimes_shown_avgs() {
        return times_shown_avgs;
    }

    public void setTimes_shown_avgs(int times_shown_avgs) {
        this.times_shown_avgs = times_shown_avgs;
    }

    public int getShown_passed_subjs() {
        return shown_passed_subjs;
    }

    public void setShown_passed_subjs(int shown_passed_subjs) {
        this.shown_passed_subjs = shown_passed_subjs;
    }

    public int getShown_avg() {
        return shown_avg;
    }

    public void setShown_avg(int shown_avg) {
        this.shown_avg = shown_avg;
    }
}
