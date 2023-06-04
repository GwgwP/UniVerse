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

    /*
        @params view
        @params students
     */
    public UserLoginPresenter(UserLoginView view, StudentDAO students, SecretaryDAO secretaries) {
        this.view = view;
        this.students = students;
        this.secretaries = secretaries;
    }

    public Map.Entry<Integer, User> findUser(String username, String password) {
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
        // TODO Error message --> wrong user login
        return new AbstractMap.SimpleEntry<Integer, User>(-1, null);

    }

    public void secretaryLogin(int id) {
        view.secretaryLogin(id);
    }

    public void studentLogin(int id) {
        view.studentLogin(id);
    }

    public void showErrorMsg() {
        view.showAlertMessage("Error", "Invalid User");
    }
}
