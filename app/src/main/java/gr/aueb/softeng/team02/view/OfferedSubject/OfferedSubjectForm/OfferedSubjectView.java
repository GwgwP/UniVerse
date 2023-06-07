package gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectForm;

import java.util.ArrayList;

public interface OfferedSubjectView {
    public String getYear();
    public String getSemester();
    public void createYearList(ArrayList<String> years);

    public void createSemesterList(ArrayList<String> semesters);

    public void confirmBox(String title, String txt);

    public void popNotification(String msg);

    public void goToRegistration(String year, String semester);

    public void changeToHomeScreen();
}
