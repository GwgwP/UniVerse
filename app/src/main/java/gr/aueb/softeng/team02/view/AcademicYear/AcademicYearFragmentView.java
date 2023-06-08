package gr.aueb.softeng.team02.view.AcademicYear;

import java.util.ArrayList;
import java.util.HashMap;

public interface AcademicYearFragmentView {



    public String getSelectedYear();
    public void createYearList(ArrayList<String> years);
    public void createSemesterList(ArrayList<String> semesters);

   public String getSelectedSemester();

    public void showAcYearsRegistration();
    public String getECTS();

}
