package gr.aueb.softeng.team02.view.AcademicYear.Registration;



public interface AcademicYearRegView {
    /**
     *
     * @return the academic year from the user input
     */
    String getAcademicYear();

    /**
     *
     * @return the start date from the user input
     */
    String getStartDate();

    /**
     *
     * @return the end date from the user input
     */
    String getEndDate();

    /**
     * a Toast
     * informs the user that the override of academic year's fields
     * was stored successfully
     */
    void messageDIDNTSave();

    /**
     * a Toast
     * informs the user that the academic year was stored successfully
     */
    void messageSave();
    /**
     * makes the "X" image for the academic year input
     * visible
     */
    void setVisibleFirstX();
    /**
     * makes the "X" image for the start date input
     * visible
     */
    void setVisibleSecondX();
    /**
     * makes the "X" image for the end date input
     * visible
     */
    void setVisibleThirdX();


}
