package gr.aueb.softeng.team02.view.HomeStudentFragment;

public class StudentHomePresenter {

    private StudentHomeView view;

    public StudentHomePresenter() {
    }

    public void setView(StudentHomeView view) {
        this.view = view;
    }

    /**
     * Navigates the fragment to the Authentication Activity
     **/
    public void press() {
        view.logout();
    }
}
