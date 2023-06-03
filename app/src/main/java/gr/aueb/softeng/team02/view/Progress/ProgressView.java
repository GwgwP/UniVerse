package gr.aueb.softeng.team02.view.Progress;

import java.util.ArrayList;
import java.util.HashMap;

public interface ProgressView
{
    public void getGrade();
    public void showAverage(double avg);
    public void showAveragePerSemester(HashMap<Integer, Double> av_grades);
    public void showNumPassed(int num);

    public void showDetailedGrades();
}