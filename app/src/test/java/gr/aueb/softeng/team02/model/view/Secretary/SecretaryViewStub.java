package gr.aueb.softeng.team02.model.view.Secretary;

import androidx.fragment.app.Fragment;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.view.AcademicYear.AcademicYearForm.AcademicYearFragment;
import gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectForm.OfferedSubjectFragment;
import gr.aueb.softeng.team02.view.Secretary.HomeSecretaryView;
import gr.aueb.softeng.team02.view.SecretaryHomeFragment.SecretaryHome;
import gr.aueb.softeng.team02.view.Subject.SubjectFragment.SubjectFragment;

public class SecretaryViewStub implements HomeSecretaryView {

    static int k = 0;

    @Override
    public void replaceFragment(Fragment fragment) {
        if (fragment instanceof SecretaryHome) {
            SecretaryViewStub.k = 1;
        } else if (fragment instanceof AcademicYearFragment) {
            SecretaryViewStub.k = 2;
        } else if (fragment instanceof SubjectFragment) {
            SecretaryViewStub.k = 3;

        } else if (fragment instanceof OfferedSubjectFragment) {
            SecretaryViewStub.k = 4;
        }

    }

    public int getK() {
        return SecretaryViewStub.k;
    }

    @Override
    public void showMessage(String txt) {
        SecretaryViewStub.k = 5;
    }
}
