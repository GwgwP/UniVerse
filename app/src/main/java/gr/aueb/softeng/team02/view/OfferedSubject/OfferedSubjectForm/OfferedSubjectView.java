package gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectForm;

import java.util.ArrayList;

public interface OfferedSubjectView {
    /**
     * Get selected year from the spinner
     *
     * @return a string that represents the selected year
     */
    public String getYear();

    /**
     * Get the selected semester from the spinner
     *
     * @return a string that represents the selected semester
     */
    public String getSemester();

    /**
     * Creates the form of the available subjects
     *
     * @param years an arraylist with titles of subjects
     */
    public void createYearList(ArrayList<String> years);

    /**
     * Creates the form of all semesters
     *
     * @param semesters all the semester from 1 to 8
     */
    public void createSemesterList(ArrayList<String> semesters);

    /**
     * Shows the confirmation box in case the secretary wants
     * to keep the previous selected offered subjects for
     * the selected academic year and semester
     *
     * @param title a suitable title in the dialog message
     * @param txt   the content of the dialog message
     */
    public void confirmBox(String title, String txt);

    /**
     * A floating mini message
     *
     * @param msg a mini message to the user as a small notification
     */
    public void popNotification(String msg);

    /**
     * Change to a new activity after the secretary accepted to erase
     * the previous offered subject for the selected year and semester
     *
     * @param year     the selected year
     * @param semester the selected semester
     */
    public void goToRegistration(String year, String semester);

    /**
     * Changes the layout from the offered subject fragment
     * to home secretary activity
     */
    public void changeToHomeScreen();
}
