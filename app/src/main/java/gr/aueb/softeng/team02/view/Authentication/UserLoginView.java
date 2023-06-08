package gr.aueb.softeng.team02.view.Authentication;

public interface UserLoginView {
    /**
     * Shows a pop up window with a customized message
     *
     * @param title: the title of the window
     * @param txt    : the text of the window
     **/
    void showAlertMessage(String title, String txt);

    /**
     * Gets the username and
     *
     * @return it
     **/
    String getUsername();

    /**
     * Gets the password and
     *
     * @return it
     **/
    String getPassword();

    /**
     * If the user who is trying to login is a student then we go to the Student Home
     *
     * @param id : the students id
     **/
    void studentLogin(int id);

    /**
     * If the user who is trying to login is a secretary then we go to the Secretary Home
     *
     * @param id : the secretary id
     **/
    void secretaryLogin(int id);

    /**
     * Gets the role of the user (0 = student , 1 = secretary)
     *
     * @return 0 or 1
     **/
    int getRole();

    /**
     * Makes the X image (for the username ) visible and prints a notification
     *
     * @param txt : the message we want to be displayed
     **/
    void initUsernameX(String txt);

    /**
     * Makes the X image (for the password ) visible and prints a notification
     *
     * @param txt : the message we want to be displayed
     **/
    void initPasswordX(String txt);

}
