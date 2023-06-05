package gr.aueb.softeng.team02.view.OfferedSubject;

import java.util.ArrayList;

public interface OfferedSubjectView {
    public String getYear();
    public String getSemester();
    public void createYearList(ArrayList<String> years);

    public void createSemesterList(ArrayList<String> semesters);

    public boolean[] confirmBox(String title, String txt);

    public void popNotification(String msg);
}
