package gr.aueb.softeng.team02.view.Student;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.view.HomeStudentFragment.StudentHome;
import gr.aueb.softeng.team02.view.Progress.ProgressForm.ProgressFragment;
import gr.aueb.softeng.team02.view.Search.SearchFragment.SearchFragment;
import gr.aueb.softeng.team02.view.Submission.SubmissionFragment;

public class HomeStudentPresenter {
    public HomeStudentView view;

    /**
     * Constructor that initializes the dao and the view
     *
     * @param view : the desired HomeStudentView
     **/
    public HomeStudentPresenter(HomeStudentView view) {
        this.view = view;
    }

    /**
     * Changes the view to the desired fragment
     *
     * @param id : represents which fragment to go to (first,second...)
     **/
    public void changeFragment(int id) {
        switch (id) {
            case R.id.homeFragment:
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
