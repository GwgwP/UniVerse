package gr.aueb.softeng.team02.view.Student;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.view.Progress.ProgressFragment;
import gr.aueb.softeng.team02.view.Search.SearchFragment;
import gr.aueb.softeng.team02.view.Submission.SubmissionFragment;

public class HomeStudentPresenter {
    public HomeStudentView view;

    public HomeStudentPresenter(HomeStudentView view) {
        this.view = view;
    }

    public void changeFragment(int id) {
        switch (id) {
            case R.id.secretaryHome:
                view.replaceFragment(new StudentHome());
                break;
            case R.id.submissionFragment:
                view.replaceFragment(new SubmissionFragment());
                break;
            case R.id.progressFragment:
                view.replaceFragment(new ProgressFragment());
                break;
            case R.id.searchFragment:
                view.replaceFragment(new SearchFragment());
                break;
        }
    }
}
