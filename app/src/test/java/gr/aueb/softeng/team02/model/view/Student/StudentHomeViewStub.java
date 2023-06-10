package gr.aueb.softeng.team02.model.view.Student;

import androidx.fragment.app.Fragment;

import gr.aueb.softeng.team02.model.view.Secretary.SecretaryViewStub;
import gr.aueb.softeng.team02.view.AcademicYear.AcademicYearForm.AcademicYearFragment;
import gr.aueb.softeng.team02.view.HomeStudentFragment.StudentHome;
import gr.aueb.softeng.team02.view.Progress.ProgressForm.ProgressFragment;
import gr.aueb.softeng.team02.view.Search.SearchFragment.SearchFragment;
import gr.aueb.softeng.team02.view.Secretary.HomeSecretaryView;

import gr.aueb.softeng.team02.view.Student.HomeStudentView;
import gr.aueb.softeng.team02.view.Submission.SubmissionFragment;

public class StudentHomeViewStub implements HomeStudentView {
    static int k = 0;
    @Override
    public void replaceFragment(Fragment fragment) {
        if (fragment instanceof StudentHome) {
            StudentHomeViewStub.k = 1;
        } else if (fragment instanceof SubmissionFragment) {
            StudentHomeViewStub.k = 2;
        } else if (fragment instanceof ProgressFragment) {
            StudentHomeViewStub.k = 3;

        } else if (fragment instanceof SearchFragment) {
            StudentHomeViewStub.k = 4;
        }

    }

    public int getK() {
        return StudentHomeViewStub.k;
    }
}
