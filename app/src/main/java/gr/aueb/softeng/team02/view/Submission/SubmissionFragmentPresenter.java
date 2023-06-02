package gr.aueb.softeng.team02.view.Submission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.dao.StudentDAO;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.model.Circumscription;
import gr.aueb.softeng.team02.model.OfferedSubject;

public class SubmissionFragmentPresenter {
    private SubmissionFragmentView view;
    private AcademicYearDAO years;
    private OfferedSubjectDAO subjects;
    private StudentDAO students;
    private String year;

    public SubmissionFragmentPresenter(AcademicYearDAO years, OfferedSubjectDAO subjects, StudentDAO students) {
        this.students = students;
        this.years = years;
        this.subjects = subjects;
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

    public void setYear(String year) {
        this.year = year;
    }

    public HashMap<String, Integer> getOfferedSubjects(int student_id) {
        HashMap<String, Integer> list = new HashMap<>();

        // TODO Must check the subjects with even or odd number and from these subjects,

        int semester = students.findSemesterOfStudent(student_id);
        List<OfferedSubject> offeredSubjects;
        if (semester % 2 == 0) {
            offeredSubjects = subjects.findByModulo(0);
        }
        else {
            offeredSubjects = subjects.findByModulo(1);
        }
        // TODO must subtract all the subjects that the student has already passed
        for (OfferedSubject sub : offeredSubjects) {
            list.put(sub.getTitle(), sub.getSemester());
        }
        return list;
    }

    public void makeForm(int position, ArrayList<String> yearList, int student_id) {
        this.year = yearList.get(position);
        view.setForm(getOfferedSubjects(student_id));
    }

    public void checkValidity(ArrayList<String> subjects, int student_id) {
        AcademicYear academicYear = years.find(year);
        int semester = students.findSemesterOfStudent(student_id);

        try {
            Circumscription c = academicYear.getCircumscription(semester);
            List<OfferedSubject> offeredSubjects = this.subjects.findByYear(this.year, semester);
            int sum = 0;
            for (OfferedSubject sub : offeredSubjects) {
                sum += sub.getEcts();
            }
            if (sum > c.getEcts()) {
                view.showErrorMessage("Error", "Surpassed the limit of the ects");
            }
        } catch (AcademicYearException e) {
        }
    }
}
