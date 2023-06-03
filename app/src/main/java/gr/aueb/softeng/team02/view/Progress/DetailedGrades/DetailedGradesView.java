package gr.aueb.softeng.team02.view.Progress.DetailedGrades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import gr.aueb.softeng.team02.model.Grade;
import gr.aueb.softeng.team02.model.OfferedSubject;

public interface DetailedGradesView {

    public void receiveAverages();
    public void viewSub(HashMap<Integer, HashMap<String, Integer>> subjects);

}
