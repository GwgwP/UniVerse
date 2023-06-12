package gr.aueb.softeng.team02.view.Progress.ProgressForm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import gr.aueb.softeng.team02.dao.GradeDAO;
import gr.aueb.softeng.team02.model.Grade;


public class ProgressPresenter {
    private ProgressView view;
    private GradeDAO grades;



    /**
     * constructor
     */
    public ProgressPresenter() {}

    /**
     * setter for the view
     * @param v Progress Fragment view
     */
    public void setView(ProgressView v)
    {
        this.view = v;
    }


    /**
     * shows the average of a student
     * @param id the id of the student
     */
    public void getAverage(int id) {

        Set<Grade> studentGrades = grades.findByStudent(id);
        double average = studentGrades.stream()
                .filter(g -> g.getGrade() >= 5)
                .mapToDouble(Grade::getGrade)
                .average()
                .orElse(0);

        view.showAverage(average);

    }

    /**
     * shows the average per semester
     * of a student
     * @param id the id of the student
     */
    public void getAGperSem(int id) {
        HashMap<Integer, ArrayList<Integer>> grades_per_sem = new HashMap<>();
        for (Grade g : grades.findPassedSubjectsByStudent(id)) {
            if (!grades_per_sem.containsKey(g.getSemester()))
                grades_per_sem.put(g.getSemester(), new ArrayList<Integer>());

            grades_per_sem.get(g.getSemester()).add(g.getGrade());
        }
        HashMap<Integer, Double> map = new HashMap<>();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : grades_per_sem.entrySet()) {
            //calculating average per semester
            map.put(entry.getKey(), entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0.0));
        }
        view.showAveragePerSemester(map);
    }

    /**
     * triggers the presentation of the total ects of the student
     * @param student_id the id of the student
     */
    public void getECTS(int student_id)
    {
        int sum = 0;
        for(Grade g:grades.findPassedSubjectsByStudent(student_id))
        {
            sum += g.getSubject().getEcts();
        }
        view.showECTS(sum);
    }

    /**
     * triggers the presentation of the total number
     * of passed subjects for a student
     * @param id the id of the student
     */
    public void getNumOfSubs(int id) {
        int c = 0;
        for(Grade g:grades.findPassedSubjectsByStudent(id))
        {
            c++;
        }
        view.showNumPassed(c);
    }

    /**
     * triggers the transition to detailed grades activity
     */
    public void onSeeGrades() {
        view.showDetailedGrades();
    }

    /**
     * sets the grades
     * @param grades the GradeDAO instance
     */
    public void setGradesDao(GradeDAO grades) {
        this.grades = grades;
    }
}