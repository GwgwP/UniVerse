package gr.aueb.softeng.team02.view.OfferedSubject;

import java.util.ArrayList;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.dao.SubjectDAO;
import gr.aueb.softeng.team02.model.AcademicYear;

public class OfferedSubjectPresenter {
    OfferedSubjectDAO offeredSubjects;
    SubjectDAO subjects;
    AcademicYearDAO years;
    OfferedSubjectView view;

    public OfferedSubjectPresenter(OfferedSubjectView view, SubjectDAO subjects, OfferedSubjectDAO offeredSubjects, AcademicYearDAO years) {
        this.subjects = subjects;
        this.offeredSubjects = offeredSubjects;
        this.years = years;
        this.view = view;
    }

    public ArrayList<String> getAcademicYears() {
        ArrayList<String> ac_years = new ArrayList<>();
        for (AcademicYear year : this.years.findAll()) {
            ac_years.add(year.getAc_year());
        }
        return ac_years;
    }

    public ArrayList<String> getSemesters() {
        ArrayList<String> semesters = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            semesters.add(String.valueOf(i));
        }
        return semesters;
    }

    public void initLists() {
        view.createYearList(getAcademicYears());
        view.createSemesterList(getSemesters());
    }
}
