package gr.aueb.softeng.team02.model.view.OfferedSubject.OfferedSubjectRegistration;

import java.util.ArrayList;

import gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectForm.OfferedSubjectView;
import gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectRegistration.OfferedSubjectRegistrationView;

public class OfferedSubjectRegistrationViewStub implements OfferedSubjectRegistrationView {
    String year, semester, alertTitle, alertMessage, moveReminder;
    ArrayList<String> titles;
    boolean checker = false;

    public OfferedSubjectRegistrationViewStub() {
        this.semester = "";
        this.year = "";
        this.alertTitle = "";
        this.alertMessage = "";
        this.moveReminder = "";
        this.titles = new ArrayList<>();
    }

    public boolean getChecker() {
        return this.checker;
    }

    public String getMoveReminder() {
        return this.moveReminder;
    }

    public String getYear() {
        return year;
    }

    public String getSemester() {
        return semester;
    }

    public String getAlertMessage() {
        return this.alertMessage;
    }

    public String getAlertTitle() {
        return this.alertTitle;
    }

    public ArrayList<String> getTitles() {
        return titles;
    }

    @Override
    public void createTable(ArrayList<String> subjects) {
        this.titles = subjects;
    }

    @Override
    public void setCheckBox(boolean flag) {
        this.checker = flag;
    }

    @Override
    public void alertBox(String title, String msg) {
        this.alertMessage = msg;
        this.alertTitle = title;
    }

    @Override
    public void errorBox(String title, String msg) {

    }

    @Override
    public void moveReminder(String txt) {
        this.moveReminder = txt;
    }

    @Override
    public ArrayList<String> submitClicked() {
        return null;
    }

    @Override
    public void changeToHomeScreen() {

    }
}
