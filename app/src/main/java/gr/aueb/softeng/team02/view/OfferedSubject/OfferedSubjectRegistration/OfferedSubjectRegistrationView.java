package gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectRegistration;

import java.util.ArrayList;

public interface OfferedSubjectRegistrationView {

    /**
     * Creates the table of the offered subject titles
     *
     * @param subjects an array list of title of the offered subjects
     */
    public void createTable(ArrayList<String> subjects);

    /**
     * Sets the checkbox 'checked' or 'unchecked', depending if the secretary
     * wants to move the selected offered subject to another semester
     *
     * @param flag true or false
     */
    public void setCheckBox(boolean flag);

    /**
     * Prints an alert dialog box with selection buttons 'Yes' or 'No'
     *
     * @param title a title of the message as a string
     * @param msg   a message of the dialog box as a string
     */
    public void alertBox(String title, String msg);

    /**
     * An error box in case there is no selected subject
     *
     * @param title a title of the error box as a string
     * @param msg   the content of the error
     */
    public void errorBox(String title, String msg);

    /**
     * A mini floating text that reminds the transportation
     * of the selected subject to the selected semester
     *
     * @param txt a notification message as a string
     */
    public void moveReminder(String txt);

    /**
     * Called when the submit button is clicked
     *
     * @return An array list of the selected titles
     */
    public ArrayList<String> submitClicked();

    /**
     * Changes layout to Home Secretary Activity
     */
    public void changeToHomeScreen();
}
