package gr.aueb.softeng.team02.view.AcademicYear;

import java.util.ArrayList;
import java.util.HashMap;

public interface AcademicYearFragmentView {
    public void setForm(HashMap<String, Integer> subjects);

   // public void showErrorMessage(String title, String message);

    public void submit();

    public void showPassedMsg(String txt);

    public String getSelectedYear(ArrayList<String> years);
    public void createYearList(ArrayList<String> years);

    public void startSubmission();
}
