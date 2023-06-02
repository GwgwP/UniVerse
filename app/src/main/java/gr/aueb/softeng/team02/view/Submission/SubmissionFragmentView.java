package gr.aueb.softeng.team02.view.Submission;

import java.util.HashMap;

public interface SubmissionFragmentView {

    public void setForm(HashMap<String, Integer> subjects);

    /**
     * Το μήνυμα που εμφανίζεται σε
     * περίπτωση error.
     * @param title O τίτλος του μηνύματος
     * @param message Το περιεχόμενο του μηνύματος
     */
    void showErrorMessage(String title, String message);

    void submit();

    void showPassedMsg();
}
