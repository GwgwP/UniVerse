package gr.aueb.softeng.team02.view.Authentication;

import android.annotation.SuppressLint;

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

    public User findUser(String username, String password) {
        Student student = students.findStudent(username, password);
        Secretary secretary = secretaries.findSecretary(username, password);

        if (student != null)
            return student;
        if (secretary != null)
            return secretary;
        return null;
    }
}
