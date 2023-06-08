package gr.aueb.softeng.team02.view.AcademicYear.AcademicYearForm;

import java.util.ArrayList;

public interface AcademicYearFragmentView {


    /**
     *
     * @return returns the selected academic year from the spinner
     * from the user's input
     */
    String getSelectedYear();

    /**
     *
     * creates a list of years for the spinner.
     * @param years list of years that could be selected
     */
    void createYearList(ArrayList<String> years);

    /**
     * creates a list with semesters for the spinner
     * @param semesters list of semesters that could be selected
     */
    void createSemesterList(ArrayList<String> semesters);


    /**
     *
     * @return returns the selected semester from the spinner
     * from the user's input
     */
    String getSelectedSemester();

    /**
     * redirects the user to the
     * page for registering a new academic year.
     */
    void showAcYearsRegistration();

    /**
     *
     * @return  returns the number of ects from the user's input
     */
    String getECTS();

    /**
     *
     * @return returns the start date from the user's input
     */
    String getDateStart();

    /**
     *
     * @return returns the end sate from the user's input
     */
    String getDateEnd();

    /**
     * A Toast
     * triggered when the circumscription
     * is stored successfully
     */
    void messageSave();

    /**
     * makes the submit button visible
     * for the user.
     */
    void setVisibleSubmit();

    /**
     * Shows an alert message to user.
     * @param title the title of the message
     * @param message the message being shown
     */
    void alertMessage(String title, String message);


    /**
     * A Toast
     * triggered when the override
     * of the circumscription was stored successfully
     */
    void messageOverride();

    /**
     * makes visible the "x" image
     * for the ects input
     */
    void setVisibleFirstX();

    /**
     * makes visible the "x" image
     * for the start date input
     */
    void setVisibleSecondX();

    /**
     * makes visible the "x" image
     * for the end date input
     */
    void setVisibleThirdX();

}
