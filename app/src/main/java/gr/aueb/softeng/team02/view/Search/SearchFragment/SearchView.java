package gr.aueb.softeng.team02.view.Search.SearchFragment;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.team02.model.OfferedSubject;

public interface SearchView {

    /**
     * We show all the offered subjects
     *
     * @param sub :  the filtered list of offered subjects
     **/
    void viewSub(List<String> sub);

    /**
     * Gets the selected offered subject's tittle and
     *
     * @return it
     **/
    String getSubTitle();

    /**
     * Directs the fragment to the next Activity that shows the subject's information
     *
     * @param title : the selected subject title
     **/
    void showInfo(String title);

    /**
     * Shows an error when the subject title that the user typed , was not found
     **/
    void errorTitle();
}
