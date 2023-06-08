package gr.aueb.softeng.team02.view.Secretary;

import java.time.LocalDate;
import java.time.Month;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.util.SystemDate;
import gr.aueb.softeng.team02.view.AcademicYear.AcademicYearForm.AcademicYearFragment;
import gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectForm.OfferedSubjectFragment;
import gr.aueb.softeng.team02.view.SecretaryHomeFragment.SecretaryHome;
import gr.aueb.softeng.team02.view.Subject.SubjectFragment.SubjectFragment;


public class HomeSecretaryPresenter {
    private HomeSecretaryView view;
    private AcademicYearDAO years;

    /**
     * Constructor that initializes the dao and the view
     *
     * @param view  : the desired HomeSecretaryView
     * @param years : AcademicYearDAO
     **/
    public HomeSecretaryPresenter(HomeSecretaryView view, AcademicYearDAO years) {
        this.view = view;
        this.years = years;
    }

    /**
     * Changes the view to the desired fragment
     *
     * @param id : represents which fragment to go to (first,second...)
     **/
    public void changeFragment(int id) {
        switch (id) {
            case R.id.secretaryHome:
                view.replaceFragment(new SecretaryHome());
                break;
            case R.id.academicYearFragment:
                view.replaceFragment(new AcademicYearFragment());
                break;
            case R.id.subjectFragment:
                view.replaceFragment(new SubjectFragment());
                break;
            case R.id.offeredSubjectFragment:
                view.replaceFragment(new OfferedSubjectFragment());
                break;
        }
    }

    /**
     * Checks if we can upload the grades and if yes , it uploads them , else it just shows a message
     **/
    public void updateGrades() {
        LocalDate gradeDay;
        if (SystemDate.now().getMonth().compareTo(Month.SEPTEMBER) >= 0 && SystemDate.now().getMonth().compareTo(Month.FEBRUARY) <= 0) {
            gradeDay = years.getCurrentAcadYear().getGradeDateOdd();
        } else {
            gradeDay = years.getCurrentAcadYear().getGradeDateEven();
        }

        if (SystemDate.now().isAfter(gradeDay)) {
            // TODO Initialize grades
            view.showMessage("The grades have registered in the local Database");
        } else {
            view.showMessage("Grade day upload has yet to come");
        }
    }
}