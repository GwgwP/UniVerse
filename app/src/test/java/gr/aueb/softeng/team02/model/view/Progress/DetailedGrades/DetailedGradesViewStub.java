package gr.aueb.softeng.team02.model.view.Progress.DetailedGrades;

import java.util.HashMap;

import gr.aueb.softeng.team02.view.Progress.DetailedGrades.DetailedGradesView;

public class DetailedGradesViewStub implements DetailedGradesView {



    private int student_id;
    private int subjects_size;
    private int num_of_shown_subjs;

    private int received_avgs;
    private double sem1;
    private double sem2;
    private double sem3;
    private double sem4;
    private double sem5;
    private double sem6;
    private double sem7;
    private double sem8;
    private HashMap<Integer, HashMap<String, Integer>> gradings;


    public int getReceived_avgs() {
        return received_avgs;
    }


    @Override
    public void receiveAverages() {
        this.received_avgs++;
    }


    @Override
    public void viewSub(HashMap<Integer, HashMap<String, Integer>> subjects) {
        this.gradings = subjects;
        this.subjects_size = subjects.size();
        this.num_of_shown_subjs++;
    }
    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public HashMap<Integer, HashMap<String, Integer>> getGradings() {
        return gradings;
    }



}
