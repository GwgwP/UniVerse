package gr.aueb.softeng.team02.view.Authentication;

import gr.aueb.softeng.team02.model.Secretary;
import gr.aueb.softeng.team02.model.Student;

public interface UserLoginView {

    /*
     * Takes the input (username)
     * @return username in String
     */
    public String getUsername();

    /*
     * Takes the input (password)
     * @return username in String
     */
    public String getPassword();

    public void showErrorMessage(String title, String message);

    public void studentLogin(int id);
    public void secretaryLogin(int id);

    public int getRole();

}
