package gr.aueb.softeng.team02.view.Progress.DetailedGrades;

import java.util.HashMap;
import gr.aueb.softeng.team02.dao.GradeDAO;
import gr.aueb.softeng.team02.model.Grade;

public class DetailedGradesPresenter {
    private DetailedGradesActivity view;
    private GradeDAO grades;
    private int student_id;

    public DetailedGradesPresenter(DetailedGradesActivity view, GradeDAO grades) {
        this.view = view;
        this.grades = grades;

    }

    public void setStudentId(int student_id) {
        this.student_id = student_id;
    }

    public void initSubView() {

        HashMap<Integer, HashMap<String, Integer>> gradings = new HashMap<>();
        for (int i = 1; i <= 8; i++) {

            HashMap<String, Integer> semesterSubjects = new HashMap<>();

            for (Grade g : grades.findBySemesterSubjects(student_id, i)) {
                semesterSubjects.put(g.getTitle(), g.getGrade());
            }

            gradings.put(i, semesterSubjects);
        }
        view.viewSub(gradings);

    }
}