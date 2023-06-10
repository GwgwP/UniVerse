package gr.aueb.softeng.team02.model.view.Progress.DetailedGrades;

import java.util.HashMap;

import gr.aueb.softeng.team02.view.Progress.DetailedGrades.DetailedGradesView;

public class DetailedGradesViewStub implements DetailedGradesView {



    private int student_id;
    private int subjects_size;
    private int num_of_shown_subjs;

    public int getSubjects_size() {
        return subjects_size;
    }



    public int getNum_of_shown_subjs() {
        return num_of_shown_subjs;
    }



    public int getReceived_avgs() {
        return received_avgs;
    }



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



    @Override
    public void receiveAverages() {
        this.received_avgs++;
        this.sem1 = getSem1();
        this.sem2 = getSem2();
        this.sem3 = getSem3();
        this.sem4 = getSem4();
        this.sem5 = getSem5();
        this.sem6 = getSem6();
        this.sem7 = getSem7();
        this.sem8 = getSem8();
    }


    @Override
    public void viewSub(HashMap<Integer, HashMap<String, Integer>> subjects) {
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

    public void setGradings(HashMap<Integer, HashMap<String, Integer>> gradings) {
        this.gradings = gradings;
    }

    public double getSem1() {
        return sem1;
    }

    public void setSem1(double sem1) {
        this.sem1 = sem1;
    }

    public double getSem2() {
        return sem2;
    }

    public void setSem2(double sem2) {
        this.sem2 = sem2;
    }

    public double getSem3() {
        return sem3;
    }

    public void setSem3(double sem3) {
        this.sem3 = sem3;
    }

    public double getSem4() {
        return sem4;
    }

    public void setSem4(double sem4) {
        this.sem4 = sem4;
    }

    public double getSem5() {
        return sem5;
    }

    public void setSem5(double sem5) {
        this.sem5 = sem5;
    }

    public double getSem6() {
        return sem6;
    }

    public void setSem6(double sem6) {
        this.sem6 = sem6;
    }

    public double getSem7() {
        return sem7;
    }

    public void setSem7(double sem7) {
        this.sem7 = sem7;
    }

    public double getSem8() {
        return sem8;
    }

    public void setSem8(double sem8) {
        this.sem8 = sem8;
    }
}
