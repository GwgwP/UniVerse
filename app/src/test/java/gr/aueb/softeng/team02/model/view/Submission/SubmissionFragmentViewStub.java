package gr.aueb.softeng.team02.model.view.Submission;

import java.util.ArrayList;
import java.util.HashMap;

import gr.aueb.softeng.team02.view.Submission.SubmissionFragmentView;

public class SubmissionFragmentViewStub implements SubmissionFragmentView {
    boolean checker;
    String errorTitle, errormsg, passedMsg;
    HashMap<String, Integer> map;
    ArrayList<String> selectedTitles;
    public SubmissionFragmentViewStub() {
        this.errorTitle = this.errormsg = "";
        this.map = new HashMap<>();
        this.selectedTitles = new ArrayList<>();
    }

    public void clearTitles() {
        this.selectedTitles.clear();
    }

    public String getErrorTitle() {
        return this.errorTitle;
    }

    public void addSelectedTitle(String title) {
        this.selectedTitles.add(title);
    }

    public String getErrormsg() {
        return this.errormsg;
    }

    public HashMap<String, Integer> getMap() {
        return this.map;
    }
    @Override
    public void setForm(HashMap<String, Integer> subjects) {
        this.map = subjects;
    }

    @Override
    public void showErrorMessage(String title, String message) {
        this.errorTitle = title;
        this.errormsg = message;
    }

    @Override
    public ArrayList<String> submit() {
        return this.selectedTitles;
    }

    @Override
    public void showPassedMsg(String txt) {
        this.passedMsg = txt;
    }
    public boolean getChecker() {
        return this.checker;
    }

    public String getPassedMsg() {
        return this.passedMsg;
    }

    @Override
    public void setCheckBox(boolean flag) {
        this.checker = flag;
    }

    @Override
    public void changeToHomeScreen() {

    }
}
