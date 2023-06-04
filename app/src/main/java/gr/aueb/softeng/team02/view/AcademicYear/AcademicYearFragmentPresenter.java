package gr.aueb.softeng.team02.view.AcademicYear;

import java.util.ArrayList;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.GradeDAO;
import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.dao.StudentDAO;
import gr.aueb.softeng.team02.dao.SubmissionDAO;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.view.Submission.SubmissionFragmentView;

public class AcademicYearFragmentPresenter {

    private AcademicYearFragmentView view;
    private AcademicYearDAO years;
    private String year;

    public AcademicYearFragmentPresenter(AcademicYearDAO years)
    {
        this.years = years;
    }

    public void setView(AcademicYearFragmentView view){this.view = view;}

    public ArrayList<String> get_academic_years() {
        ArrayList<String> ac_years = new ArrayList<>();
        for (AcademicYear year : this.years.findAll()) {
            ac_years.add(year.getAc_year());
        }
        return ac_years;
    }

    public void startProcess() {
        view.startSubmission();
    }
    public void set_years() {
        view.createYearList(get_academic_years());
    }

}
