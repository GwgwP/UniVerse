package gr.aueb.softeng.team02.view.Subject.SubjectFragment;


import java.util.List;

public interface SubjectView {
    /**
     * Shows a list with all the subjects that exist
     *
     * @param sub : the subject list
     **/
    void viewSubs(List<String> sub);

    /**
     * Navigates to the next activity that shows the form to create a new Subject
     **/
    void showForm();


}
