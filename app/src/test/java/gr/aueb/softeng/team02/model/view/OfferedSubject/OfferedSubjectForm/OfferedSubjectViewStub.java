package gr.aueb.softeng.team02.model.view.OfferedSubject.OfferedSubjectForm;

import java.util.ArrayList;

import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectForm.OfferedSubjectView;

public class OfferedSubjectViewStub implements OfferedSubjectView {

    String year, semester, errorTitle, errorMessage, popmsg, selectedYear, selectedSemester;
    ArrayList<String> yearList = new ArrayList<>();
    ArrayList<String> semesterList = new ArrayList<>();

    /**
     * Initialize the view variables
     */
    public OfferedSubjectViewStub() {
        year = semester = errorTitle = errorMessage = popmsg = selectedSemester = selectedYear = "";
    }

    /**
     * Get the year list of all registered years
     *
     * @return an array list of year time stamps of strings
     */
    public ArrayList<String> getYearList() {
        return this.yearList;
    }

    /**
     * Get the semester list from 1,2,3,4,5,6,7,8
     *
     * @return
     */
    public ArrayList<String> getSemesterList() {
        return this.semesterList;
    }

    /**
     * Get the selected year when the user changes from one layout to another
     *
     * @return the selected year as a string
     */
    public String getSelectedYear() {
        return this.selectedYear;
    }

    /**
     * Get the selected semester when the user changes from one layout to another
     *
     * @return the selected semester as a string
     */
    public String getSelectedSemester() {
        return this.selectedSemester;
    }

    /**
     * Get the pop message (notification)
     *
     * @return the notification of the string
     */
    public String getPopmsg() {
        return this.popmsg;
    }

    /**
     * Get the error title of the message box
     *
     * @return the title as string
     */
    public String getErrorTitle() {
        return this.errorTitle;
    }

    /**
     * Get the message of the message notification
     *
     * @return the message as a string
     */
    public String getErrorMessage() {
        return this.errorMessage;
    }

    /**
     * Set the preselected year of the user
     *
     * @param year the year time stamp as a string
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * Set the preselected semester of the user
     *
     * @param semester the semester as a string
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Get the preselected year of the user
     *
     * @return the year as a string
     */
    @Override
    public String getYear() {
        return this.year;
    }

    /**
     * Get the preselected semester of the user
     *
     * @return the semester as an integer
     */
    @Override
    public String getSemester() {
        return this.semester;
    }

    /**
     * Set the year list of the registered years
     *
     * @param years an arraylist with titles of subjects
     */
    @Override
    public void createYearList(ArrayList<String> years) {
        this.yearList = years;
    }

    /**
     * Set the semester list for the view
     *
     * @param semesters all the semester from 1 to 8
     */
    @Override
    public void createSemesterList(ArrayList<String> semesters) {
        this.semesterList = semesters;
    }

    /**
     * Set the error title and the txt
     *
     * @param title a suitable title in the dialog message
     * @param txt   the content of the dialog message
     */
    @Override
    public void confirmBox(String title, String txt) {
        this.errorTitle = title;
        this.errorMessage = txt;
    }

    /**
     * Set the notification message
     *
     * @param msg a mini message to the user as a small notification
     */
    @Override
    public void popNotification(String msg) {
        popmsg = msg;
    }

    /**
     * Set the selected year and semester for the transition to the new screen
     *
     * @param year     the selected year as a string
     * @param semester the selected semester as a string
     */
    @Override
    public void goToRegistration(String year, String semester) {
        this.selectedSemester = semester;
        this.selectedYear = year;
    }

    /**
     * Change the layout to the home screen, in the test it is nothing special, an empty function
     */
    @Override
    public void changeToHomeScreen() {
    }
}
