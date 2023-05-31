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

        if (student != null)
            return new AbstractMap.SimpleEntry<Integer, User>(1, student);
            //return student;
        if (secretary != null)
            return new AbstractMap.SimpleEntry<Integer, User>(1, secretary);
        // return secretary;
        return new AbstractMap.SimpleEntry<Integer, User>(-1, null);

    }

    public void secretaryLogin(int id) {
        view.secretaryLogin(id);
    }

    public void studentLogin(int id) {
        view.studentLogin(id);
    }
}
