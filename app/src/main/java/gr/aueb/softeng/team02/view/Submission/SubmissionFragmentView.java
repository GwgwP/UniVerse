package gr.aueb.softeng.team02.view.Submission;

import java.util.ArrayList;
import java.util.HashMap;

public interface SubmissionFragmentView {
    /**
     * Create the list of subjects
     *
     * @param subjects a hash map with key the title and value the semester of the subject
     */
    public void setForm(HashMap<String, Integer> subjects);

    /**
     * Το μήνυμα που εμφανίζεται σε
     * περίπτωση error.
     *
     * @param title   O τίτλος του μηνύματος
     * @param message Το περιεχόμενο του μηνύματος
     */
    public void showErrorMessage(String title, String message);

    /**
     * Call presenter on submit button clicked
     *
     * @return a array list of string objects with the selected titles
     */
    public ArrayList<String> submit();

    /**
     * Show message in case of successful store
     *
     * @param txt the content of the message in a string
     */
    public void showPassedMsg(String txt);

    /**
     * Set the check box 'Checked' or 'Unchecked'
     *
     * @param flag true or false depending if the subject can be selected from the user
     */
    public void setCheckBox(boolean flag);

    /**
     * Changes the layout from the Submission Fragment -> HomeStudentActivity
     */
    public void changeToHomeScreen();
}
