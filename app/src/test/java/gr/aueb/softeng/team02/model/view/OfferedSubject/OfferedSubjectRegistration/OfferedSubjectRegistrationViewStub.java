package gr.aueb.softeng.team02.model.view.OfferedSubject.OfferedSubjectRegistration;

import java.util.ArrayList;

import gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectForm.OfferedSubjectView;
import gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectRegistration.OfferedSubjectRegistrationView;

public class OfferedSubjectRegistrationViewStub implements OfferedSubjectRegistrationView {
    String year, semester, alertTitle, alertMessage, moveReminder, errorTitle, errorMsg;
    ArrayList<String> titles = new ArrayList<>();
    ArrayList<String> selectedSubjects;
    boolean checker = false;

    /**
     * Constructor and initialize the attributes
     */
    public OfferedSubjectRegistrationViewStub() {
        this.semester = "";
        this.year = "";
        this.alertTitle = "";
        this.alertMessage = "";
        this.moveReminder = "";
        this.errorTitle = "";
        this.errorMsg = "";
        this.titles = new ArrayList<>();
        this.selectedSubjects = new ArrayList<>();
    }

    /**
     * Add a selected title
     *
     * @param title a title as a string
     */
    public void addTitles(String title) {
        this.selectedSubjects.add(title);
    }

    /**
     * Get the error message  of the message box
     *
     * @return the message as a string
     */
    public String getErrorMsg() {
        return this.errorMsg;
    }

    /**
     * Get the error title of the message box
     *
     * @return the title as a string
     */
    public String getErrorTitle() {
        return this.errorTitle;
    }

    /**
     * Get the checker situation
     *
     * @return true or false
     */
    public boolean getChecker() {
        return this.checker;
    }

    /**
     * Get the message of the move reminder
     *
     * @return the message as a string
     */
    public String getMoveReminder() {
        return this.moveReminder;
    }

    /**
     * Get the selected year
     *
     * @return the year as a time stamp string
     */
    public String getYear() {
        return year;
    }

    /**
     * Get the preselected semester
     *
     * @return the semester as a string
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Get the message of the alert box
     *
     * @return the message as a string
     */
    public String getAlertMessage() {
        return this.alertMessage;
    }

    /**
     * Get the title of the alert box
     *
     * @return the title as a string
     */
    public String getAlertTitle() {
        return this.alertTitle;
    }

    /**
     * Get the titles of the subject
     *
     * @return the titles as a list of strings
     */
    public ArrayList<String> getTitles() {
        return titles;
    }

    /**
     * Set the titles of the subjects
     *
     * @param subjects an array list of title of the offered subjects
     */
    @Override
    public void createTable(ArrayList<String> subjects) {
        this.titles = subjects;
    }

    /**
     * Set the check box
     *
     * @param flag true or false
     */
    @Override
    public void setCheckBox(boolean flag) {
        this.checker = flag;
    }

    /**
     * Set the title and the message of the alert box
     *
     * @param title a title of the message as a string
     * @param msg   a message of the dialog box as a string
     */
    @Override
    public void alertBox(String title, String msg) {
        this.alertMessage = msg;
        this.alertTitle = title;
    }

    /**
     * Set the title and the message of the message box
     *
     * @param title a title of the error box as a string
     * @param msg   the content of the error
     */
    @Override
    public void errorBox(String title, String msg) {
        this.errorTitle = title;
        this.errorMsg = msg;
    }

    /**
     * Set the message of the message notification
     *
     * @param txt a notification message as a string
     */
    @Override
    public void moveReminder(String txt) {
        this.moveReminder = txt;
    }

    /**
     * When the user submits the form, return a list of titles
     *
     * @return the subject title as a string
     */
    @Override
    public ArrayList<String> submitClicked() {
        return selectedSubjects;
    }

    /**
     * Not implemented
     */
    @Override
    public void changeToHomeScreen() {
    }
}
