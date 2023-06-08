package gr.aueb.softeng.team02.view.Progress.DetailedGrades;

import java.util.HashMap;
public interface DetailedGradesView {

    /**
     * receives the average grades per semester
     */
    void receiveAverages();
    /**
     * creates a List with the subjects of the student
     * per semester and their corresponding grade
     *
     * @param subjects HashMap containing
     *                 the semesters and a corresponding hashMap
     *                 contain subjects and grades
     */
    void viewSub(HashMap<Integer, HashMap<String, Integer>> subjects);

}
