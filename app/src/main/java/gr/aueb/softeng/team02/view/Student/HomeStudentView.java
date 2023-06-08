package gr.aueb.softeng.team02.view.Student;

import androidx.fragment.app.Fragment;

public interface HomeStudentView {
    /**
     * Responsible for the transition from one fragment to another
     *
     * @param fragment : the destination fragment
     **/
    void replaceFragment(Fragment fragment);
}
