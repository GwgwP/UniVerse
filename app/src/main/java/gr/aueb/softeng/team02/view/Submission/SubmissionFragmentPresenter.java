package gr.aueb.softeng.team02.view.Submission;

import java.util.ArrayList;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.model.AcademicYear;

public class SubmissionFragmentPresenter {
    private SubmissionFragmentView view;
    private AcademicYearDAO years;

    private String year;
    public SubmissionFragmentPresenter(SubmissionFragmentView view, AcademicYearDAO years) {
        this.view = view;
        this.years = years;
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
}
