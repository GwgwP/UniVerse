package gr.aueb.softeng.team02.view.Authentication;

import android.util.Log;

import gr.aueb.softeng.team02.dao.SecretaryDAO;
import gr.aueb.softeng.team02.dao.StudentDAO;
import gr.aueb.softeng.team02.model.Secretary;
import gr.aueb.softeng.team02.model.Student;

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

    public int findUser(String username, String password) {
        if (students == null) {
            Log.e("DEBUGGER", "WHAT");
        }
        Student student = students.findStudent(username, password);
        Secretary secretary = secretaries.findSecretary(username, password);

        if (student != null)
            return 1;
            //return student;
        if (secretary != null)
            return 2;
            // return secretary;
        return 0;
    }

    public void secretaryLogin() {
        view.secretaryLogin();
    }

    public void studentLogin() {
        view.studentLogin();
    }
}
