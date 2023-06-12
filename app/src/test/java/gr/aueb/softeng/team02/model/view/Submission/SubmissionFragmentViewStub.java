package gr.aueb.softeng.team02.model.view.Submission;

import java.util.ArrayList;
import java.util.HashMap;

import gr.aueb.softeng.team02.view.Submission.SubmissionFragmentView;

public class SubmissionFragmentViewStub implements SubmissionFragmentView {
    boolean checker;
    String errorTitle, errormsg, passedMsg;
    HashMap<String, Integer> map;
    ArrayList<String> selectedTitles;

    public SubmissionFragmentViewStub() {
        this.errorTitle = this.errormsg = "";
        this.map = new HashMap<>();
        this.selectedTitles = new ArrayList<>();
    }

    /**
     * Clear the selected titles of the subjects, when we make a new submission
     */
    public void clearTitles() {
        this.selectedTitles.clear();
    }

    /**
     * Get the error title of the message box
     *
     * @return the error title as a string
     */
    public String getErrorTitle() {
        return this.errorTitle;
    }

    /**
     * When selecting new titles, add the newest title on the list
     *
     * @param title the title as a string
     */
    public void addSelectedTitle(String title) {
        this.selectedTitles.add(title);
    }

    /**
     * Get the error message of the message box
     *
     * @return the message as a string
     */
    public String getErrormsg() {
        return this.errormsg;
    }

    /**
     * Get a hashmap with the key : title of subject and value : semester of subject
     *
     * @return the hashmap of the shown titles and their semesters
     */
    public HashMap<String, Integer> getMap() {
        return this.map;
    }

    /**
     * Set the form based on the map
     *
     * @param subjects a hash map with key the title and value the semester of the subject
     */
    @Override
    public void setForm(HashMap<String, Integer> subjects) {
        this.map = subjects;
    }

    /**
     * Show the error message to the user
     *
     * @param title   O τίτλος του μηνύματος
     * @param message Το περιεχόμενο του μηνύματος
     */
    @Override
    public void showErrorMessage(String title, String message) {
        this.errorTitle = title;
        this.errormsg = message;
    }

    /**
     * After clicking the submission, returns the selected subject titles
     *
     * @return an arraylist of titles
     */
    @Override
    public ArrayList<String> submit() {
        return this.selectedTitles;
    }

    /**
     * Set the passed message of the message floating notification
     *
     * @param txt the content of the message in a string
     */
    @Override
    public void showPassedMsg(String txt) {
        this.passedMsg = txt;
    }

    /**
     * Get the situation of the check box
     *
     * @return true or false
     */
    public boolean getChecker() {
        return this.checker;
    }

    /**
     * Get the passed message of the notification box
     *
     * @return the message as a string
     */
    public String getPassedMsg() {
        return this.passedMsg;
    }

    /**
     * Set the check box
     *
     * @param flag true or false depending if the subject can be selected from the user
     */
    @Override
    public void setCheckBox(boolean flag) {
        this.checker = flag;
    }

    /**
     * This method originally changes the screen
     */
    @Override
    public void changeToHomeScreen() {

    }
}
