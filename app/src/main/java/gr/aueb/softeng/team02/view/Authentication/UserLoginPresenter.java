package gr.aueb.softeng.team02.view.Authentication;

import android.util.Log;

import java.util.AbstractMap;
import java.util.Map;

import gr.aueb.softeng.team02.dao.SecretaryDAO;
import gr.aueb.softeng.team02.dao.StudentDAO;
import gr.aueb.softeng.team02.model.Secretary;
import gr.aueb.softeng.team02.model.Student;
import gr.aueb.softeng.team02.model.User;

public class UserLoginPresenter {

    private UserLoginView view;
    private StudentDAO students;
    private SecretaryDAO secretaries;

    /**
     * Constructor that initializes the daos and the view
     *
     * @param secretaries : SecretaryDAO
     * @param students    : StudentDAO
     * @param view        : our desired view
     **/

    public UserLoginPresenter(UserLoginView view, StudentDAO students, SecretaryDAO secretaries) {
        this.view = view;
        this.students = students;
        this.secretaries = secretaries;
    }

    /**
     * Checks if the combination username-password-role is correct and them navigates the app in the suitable home screen
     **/
    public void startProcess() {
        String username = view.getUsername();
        String password = view.getPassword();

        if (username.equals("")) {
            view.initUsernameX("Please write your username");
        }

        if (password.equals("")) {
            view.initPasswordX("Please write your password");
        }

        if (!(password.equals("") || username.equals(""))) {
            Map.Entry<Integer, User> user = findUser(username, password);

            switch (user.getKey()) {
                case 1:
                    view.studentLogin(user.getValue().getId());
                    break;
                case 2:
                    view.secretaryLogin(user.getValue().getId());
                    break;
                case -1:
                    view.showAlertMessage("Error", "Invalid User");
                    break;
            }
        }
    }

    /**
     * Finds if the user exists
     *
     * @param password : the password the user inputs
     * @param username : the username the user inputs
     * @return a Map with the role number and the suitable User
     **/
    private Map.Entry<Integer, User> findUser(String username, String password) {
        Student student = students.findStudentByUsernameAndPassword(username, password);
        Secretary secretary = secretaries.findSecretary(username, password);

        if (student != null) {
            if (view.getRole() == 0) {
                return new AbstractMap.SimpleEntry<Integer, User>(1, student);
            }
        } else if (secretary != null) {
            if (view.getRole() == 1) {
                return new AbstractMap.SimpleEntry<Integer, User>(2, secretary);
            }
        }
        return new AbstractMap.SimpleEntry<Integer, User>(-1, null);
    }
}

