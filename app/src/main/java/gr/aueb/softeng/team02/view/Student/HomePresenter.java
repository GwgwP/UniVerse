package gr.aueb.softeng.team02.view.Student;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.view.HomeFragment;
import gr.aueb.softeng.team02.view.Progress.ProgressFragment;
import gr.aueb.softeng.team02.view.Search.SearchFragment;
import gr.aueb.softeng.team02.view.Submission.SubmissionFragment;

public class HomePresenter {
    public HomeView view;

    public HomePresenter(HomeView view) {
        this.view = view;
    }

    public void changeFragment(int id) {
        switch (id) {
            case R.id.homeFragment:
                view.replaceFragment(new HomeFragment());
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
