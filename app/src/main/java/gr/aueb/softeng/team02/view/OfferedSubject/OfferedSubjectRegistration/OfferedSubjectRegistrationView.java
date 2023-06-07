package gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectRegistration;

import java.util.ArrayList;

public interface OfferedSubjectRegistrationView {

    public void createTable(ArrayList<String> subjects);
    public void setCheckBox(boolean flag);

    public void alertBox(String title, String msg);

    public void errorBox(String title, String msg);

    public void moveReminder(String txt);

    public ArrayList<String> submitClicked();

    public void changeToHomeScreen();
}
