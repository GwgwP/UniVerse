package gr.aueb.softeng.team02.view.OfferedSubject;

import java.util.ArrayList;

public interface OfferedSubjectView {
    public String getYear();
    public int getSemester();
    public void createYearList(ArrayList<String> years);

    public void createSemesterList(ArrayList<String> semesters);
}
