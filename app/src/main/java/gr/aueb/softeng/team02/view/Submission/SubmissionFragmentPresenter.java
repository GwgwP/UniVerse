package gr.aueb.softeng.team02.view.Submission;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.GradeDAO;
import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.dao.StudentDAO;
import gr.aueb.softeng.team02.dao.SubmissionDAO;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.model.Circumscription;
import gr.aueb.softeng.team02.model.Grade;
import gr.aueb.softeng.team02.model.OfferedSubject;
import gr.aueb.softeng.team02.model.Submission;

public class SubmissionFragmentPresenter {
    private SubmissionFragmentView view;
    private final AcademicYearDAO years;
    private final OfferedSubjectDAO subjects;
    private final StudentDAO students;
    private final GradeDAO grades;
    private final SubmissionDAO submissions;
    private String year;
    private int studentId;

    public SubmissionFragmentPresenter(AcademicYearDAO years, OfferedSubjectDAO subjects, StudentDAO students, GradeDAO grades, SubmissionDAO submissions) {
        this.students = students;
        this.years = years;
        this.subjects = subjects;
        this.grades = grades;
        this.submissions = submissions;
    }

    public void setStudentId(int id) {
        this.studentId = id;
    }

    public void startProcess() {
        view.startSubmission();
    }

    public void setView(SubmissionFragmentView view) {
        this.view = view;
    }

    public ArrayList<String> getAcademicYears() {
        ArrayList<String> ac_years = new ArrayList<>();
        for (AcademicYear year : this.years.findAll()) {
            ac_years.add(year.getAc_year());
        }
        return ac_years;
    }

    public HashMap<String, Integer> getOfferedSubjects(int student_id, String year) {
        HashMap<String, Integer> list = new HashMap<>();

        int semester = students.findSemesterOfStudent(student_id);
        List<OfferedSubject> offeredSubjects;
        if (semester % 2 == 0) {
            offeredSubjects = subjects.findByModulo(0, year);
        } else {
            offeredSubjects = subjects.findByModulo(1, year);
        }
        for (Grade g : grades.findPassedSubjectsByStudent(student_id)) {
            offeredSubjects.remove(g.getSubject());
        }

        for (OfferedSubject sub : offeredSubjects) {
            list.put(sub.getTitle(), sub.getSemester());
        }
        return list;
    }

    //show the offered students based on the selected year .
    public void makeForm() {
        this.year = view.getSelectedYear();
        view.setForm(getOfferedSubjects(this.studentId, year));
    }

    public void submitClicked() {
        ArrayList<String> titles = view.submit();
        AcademicYear academicYear = years.find(year);
        int semester = students.findSemesterOfStudent(this.studentId);

        Circumscription c = academicYear.getCircumscription(semester);
        List<OfferedSubject> offeredSubjects = this.subjects.findByYear(this.year, semester);
        Submission sub = new Submission();
        sub.setSemester(students.findSemesterOfStudent(this.studentId));
        sub.setAcademicYear(years.find(this.year));
        sub.setStudent(students.findStudentById(this.studentId));

        boolean flag = false;
        for (String s : titles) {
            try {
                sub.addChosenSub(this.subjects.findByYearAndName(this.year, s));
            } catch (Exception e) {
                flag = true;
            }
        }

        if (!flag) {
            submissions.save(sub);
            view.showPassedMsg("Succesfully stored");
        } else
            view.showErrorMessage("Error", "Surpassed the limit of ECTS for this semester");
    }

    public void setYears() {
        view.createYearList(getAcademicYears());
    }
}
