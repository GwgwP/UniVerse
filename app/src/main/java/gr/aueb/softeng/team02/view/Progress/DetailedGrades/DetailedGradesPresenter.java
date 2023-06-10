package gr.aueb.softeng.team02.view.Progress.DetailedGrades;

import java.util.HashMap;
import gr.aueb.softeng.team02.dao.GradeDAO;
import gr.aueb.softeng.team02.model.Grade;

public class DetailedGradesPresenter {
    private DetailedGradesView view;
    private GradeDAO grades;
    private int student_id;

    /**
     * Constructor
     * @param view view instance
     * @param grades grades instance
     */
    public DetailedGradesPresenter(DetailedGradesView view, GradeDAO grades) {
        this.view = view;
        this.grades = grades;
    }

    /**
     * sets the student id
     * @param student_id id of the student
     */
    public void setStudentId(int student_id) {
        this.student_id = student_id;
    }

    /**
     * initializes a Hash Map  by retrieving grading information for a student
     * and passing it to the view for display.
     */
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