package gr.aueb.softeng.team02.model.view.Progress.ProgressForm;

import java.util.HashMap;
import gr.aueb.softeng.team02.view.Progress.ProgressForm.ProgressView;

public class ProgressFormViewStub implements ProgressView {

    private double average;

    private int number_of_passed_subjects;
    private int ects, num_ects_shown;
    private int student_id;
    private int times_shown_avgs;
    private int shown_passed_subjs;
    private int shown_avg;


    private int onseegrades;
    HashMap<Integer, Double> av_grades;


    public int getEctsShown()
    {
        return this.num_ects_shown;
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
        this.average = avg;
        this.shown_avg++;
    }


    public int getSizeOfAveragesPerSem()
    {
        return av_grades.size();
    }
    @Override
    public void showAveragePerSemester(HashMap<Integer, Double> av_grades) {
        this.av_grades = av_grades;
        this.times_shown_avgs++;
    }
    public int getOnseegrades() {
        return onseegrades;
    }


    @Override
    public void showNumPassed(int num) {
        this.shown_passed_subjs ++;
        this.number_of_passed_subjects = num;
    }

    @Override
    public void showDetailedGrades() {
        this.onseegrades++;
    }

    @Override
    public void showECTS(int num) {
        this.ects = num;
        this.num_ects_shown++;
    }

    public int getTimes_shown_avgs() {
        return times_shown_avgs;
    }


    public int getShown_passed_subjs() {
        return shown_passed_subjs;
    }


    public int getShown_avg() {
        return shown_avg;
    }

}
