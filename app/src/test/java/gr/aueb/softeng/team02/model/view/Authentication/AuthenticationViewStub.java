package gr.aueb.softeng.team02.model.view.Authentication;

import gr.aueb.softeng.team02.view.Authentication.UserLoginView;

public class AuthenticationViewStub implements UserLoginView {
    String username;
    String password;

    public void setRole(int role) {
        this.role = role;
    }

    int role;

    public void setUser(String username,String password,int role){
        this.role=role; // student -> 0 , secretary -> 1
        this.username = username;
        this.password = password;
    }
    int message = 0 ;
    @Override
    public void showAlertMessage(String title, String txt) {
        message++;

    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public int getStudent() {
        return student;
    }

    public int getSecretary() {
        return secretary;
    }

    int student=0;
    @Override
    public void studentLogin(int id) {
        student ++;
    }
    int secretary = 0 ;
    @Override
    public void secretaryLogin(int id) {
        secretary++;
    }

    @Override
    public int getRole() {
        return this.role;
    }

    public int getName() {
        return name;
    }

    int name =0;
    @Override
    public void initUsernameX(String txt) {
        name ++;

    }

    public int getPass() {
        return pass;
    }

    int pass =0;
    @Override
    public void initPasswordX(String txt) {
        pass++;
    }
}
