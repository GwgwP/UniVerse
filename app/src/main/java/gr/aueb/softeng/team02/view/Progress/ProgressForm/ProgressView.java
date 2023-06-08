package gr.aueb.softeng.team02.view.Progress.ProgressForm;


import java.util.HashMap;

public interface ProgressView {

    /**
     * shows the average passed
     *
     * @param avg the average to be shown
     */
    void showAverage(double avg);


    /**
     * it shows th averages per semester.
     *
     * @param av_grades a hashmap containing semesters and average grades
     */
    void showAveragePerSemester(HashMap<Integer, Double> av_grades);

    /**
     * shows the number of passed subjects
     *
     * @param num the number of passed subjects
     */
    void showNumPassed(int num);

    /**
     * redirects the user to the detailed grades page.
     * Passes all the necessary arguments using bundle
     * to the detailed grades activity
     */
    void showDetailedGrades();

    /**
     * shows the ects
     *
     * @param num the number of ects to be shown
     */
    void showECTS(int num);
}