package gr.aueb.softeng.team02.view.Subject.SubjectAdd;

import java.util.ArrayList;

public interface SubjectFormView {
    /**
     * Gets from the user the title he/she has written and
     *
     * @return it
     **/
    String getSubTitle();

    /**
     * Gets from the user the professors name he/she has written and
     *
     * @return it
     **/
    String getProf();

    /**
     * Gets from the user the description he/she has written and
     *
     * @return it
     **/
    String getDesc();

    /**
     * Gets from the user the ects he/she has written and
     *
     * @return it
     **/
    String getEcts();

    /**
     * Sets the X image for the Title  visible
     **/
    void setexTitle();

    /**
     * Sets the X image for the Professor visible
     **/
    void setexProf();

    /**
     * Sets the X image for Ects visible
     **/
    void setexEcts();

    /**
     * Sets the X image for Description visible
     **/
    void setexDesc();

    /**
     * Prints an error message when not all the attributes are written by the user
     **/
    void printEr1();

    /**
     * Sets the X image for Title invisible
     **/
    void invTitle();

    /**
     * Sets the X image for description invisible
     **/
    void invDesc();

    /**
     * Sets the X image for professor invisible
     **/
    void invProf();

    /**
     * Sets the X image for ects invisible
     **/
    void invEcts();

    /**
     * Shows a pop-up window when there is already is a subject with the same name , and asks the user which version he would like to keep.
     **/
    void sameSubject();

    /**
     * Show a message that the subject was saved successfully
     **/
    void messageSave();

    /**
     * Navigates to the home screen
     **/
    void getBack();

    /**
     * Show a message that the the user wrote at least one letter in the ects attribute
     **/
    void invalidInput();

    ArrayList<String> getPrereq();

    void setForm(ArrayList<String> titles);

}
