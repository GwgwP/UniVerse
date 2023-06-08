package gr.aueb.softeng.team02.view.AcademicYear.AcademicYearForm;

import java.util.ArrayList;
import java.util.HashMap;

public interface AcademicYearFragmentView {



    public String getSelectedYear();
    public void createYearList(ArrayList<String> years);
    public void createSemesterList(ArrayList<String> semesters);

   public String getSelectedSemester();

    public void showAcYearsRegistration();

    public String getECTS();

    public String getDateStart();
    public String getDateEnd();
    public void messageSave();
    public void setVisibleSubmit();
    public void alertMessage(String title, String message);
    public void messageOverride();

    public void setVisibleFirstX();
    public void setVisibleSecondX();
    public void setVisibleThirdX();

}
