package gr.aueb.softeng.team02.view.Submission;

import java.util.ArrayList;
import java.util.HashMap;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.OfferedSubject;

public class SubmissionFragmentPresenter {
    private SubmissionFragmentView view;
    private AcademicYearDAO years;

    private OfferedSubjectDAO subjects;

    private String year;
    public SubmissionFragmentPresenter(SubmissionFragmentView view, AcademicYearDAO years, OfferedSubjectDAO subjects) {
        this.view = view;
        this.years = years;
        this.subjects = subjects;
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

    public HashMap<String, Integer> getOfferedSubjects() {
        HashMap<String, Integer> list = new HashMap<>();

        for (OfferedSubject sub : this.subjects.findByYear(year, 6)) {
            list.put(sub.getTitle(), sub.getSemester());
        }
        return list;
    }
}
