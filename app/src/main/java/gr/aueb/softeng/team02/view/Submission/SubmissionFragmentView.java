package gr.aueb.softeng.team02.view.Submission;

import java.util.ArrayList;
import java.util.HashMap;

public interface SubmissionFragmentView {

    public void setForm(HashMap<String, Integer> subjects);

    /**
     * Το μήνυμα που εμφανίζεται σε
     * περίπτωση error.
     * @param title O τίτλος του μηνύματος
     * @param message Το περιεχόμενο του μηνύματος
     */
    public void showErrorMessage(String title, String message);

    public void submit();

    public void showPassedMsg(String txt);

    public String getSelectedYear(ArrayList<String> years);
    public void createYearList(ArrayList<String> years);
}
