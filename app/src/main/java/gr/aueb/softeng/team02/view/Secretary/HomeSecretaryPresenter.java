package gr.aueb.softeng.team02.view.Secretary;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.view.AcademicYear.AcademicYearFragment;
import gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectFragment;
import gr.aueb.softeng.team02.view.Subject.SubjectFragment;


public class HomeSecretaryPresenter {
    public HomeSecretaryView view;

    public HomeSecretaryPresenter(HomeSecretaryView view) {
        this.view = view;
    }

    public void changeFragment(int id) {
        switch (id) {
            case R.id.homeFragment:
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
}