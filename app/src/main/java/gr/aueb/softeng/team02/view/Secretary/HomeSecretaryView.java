package gr.aueb.softeng.team02.view.Secretary;

import androidx.fragment.app.Fragment;

public interface HomeSecretaryView {
    /**
     * Responsible for the transition from one fragment to another
     *
     * @param fragment : the destination fragment
     **/
    void replaceFragment(Fragment fragment);

    /**
     * Shows the desired message
     *
     * @param txt : the message we want to show
     **/
    void showMessage(String txt);
}
