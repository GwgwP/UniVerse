package gr.aueb.softeng.team02.view.Progress;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import gr.aueb.softeng.team02.dao.GradeDAO;
import gr.aueb.softeng.team02.model.Grade;


public class ProgressPresenter {
    private ProgressFragment view;
    private GradeDAO grades;

    public ProgressPresenter(ProgressFragment view, GradeDAO grades) {
        this.view = view;
        this.grades = grades;

    }

    public ProgressPresenter() {

    }

    public ProgressFragment getView() {
        return view;
    }

    public void setView(ProgressFragment view) {
        this.view = view;
    }


    public void getAverage(int id) {

        Set<Grade> studentGrades = grades.findByStudent(id);
        double average = studentGrades.stream()
                .filter(g -> g.getGrade() >= 5)
                .mapToDouble(Grade::getGrade)
                .average()
                .orElse(0);

        view.showAverage(average);


        /*double sum = 0;
        double counter = 0;

        for (Grade g : grades.findByStudent(id)) {
            if (g.getGrade() >= 5) {
                sum += g.getGrade();
                counter++;
            }
        }
        if (counter != 0)
            view.showAverage(sum / counter);
        else
            view.showAverage(0);*/
    }

    public void getAGperSem(int id) {
        HashMap<Integer, ArrayList<Integer>> grades_per_sem = new HashMap<>();
        for (Grade g : grades.findByStudent(id)) {
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

    public void getECTS(int student_id)
    {
        int sum = 0;
        for(Grade g:grades.findPassedSubjectsByStudent(student_id))
        {
            sum += g.getSubject().getEcts();
        }
        view.showECTS(sum);
    }

    public void getNumOfSubs(int id) {
        int counter = 0;
        for (Grade g : grades.findByStudent(id)) {
            if (g.getGrade() >= 5) {
                counter++;
            }
        }
        view.showNumPassed(counter);
    }

    void onSeeGrades() {
        view.showDetailedGrades();
    }



    public void setGradesDao(GradeDAO grades) {
        this.grades = grades;
    }
}