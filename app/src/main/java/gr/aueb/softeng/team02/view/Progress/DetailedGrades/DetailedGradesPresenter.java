package gr.aueb.softeng.team02.view.Progress.DetailedGrades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import gr.aueb.softeng.team02.dao.GradeDAO;
import gr.aueb.softeng.team02.model.Grade;
import gr.aueb.softeng.team02.view.Progress.ProgressFragment;

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


}
