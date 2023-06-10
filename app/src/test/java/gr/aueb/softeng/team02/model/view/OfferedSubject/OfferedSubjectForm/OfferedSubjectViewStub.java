package gr.aueb.softeng.team02.model.view.OfferedSubject.OfferedSubjectForm;

import java.util.ArrayList;

import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectForm.OfferedSubjectView;

public class OfferedSubjectViewStub implements OfferedSubjectView {

    String year, semester, errorTitle, errorMessage, popmsg, selectedYear, selectedSemester;
    ArrayList<String> yearList = new ArrayList<>();
    ArrayList<String> semesterList = new ArrayList<>();

    public OfferedSubjectViewStub() {
        year = semester = errorTitle = errorMessage = popmsg = selectedSemester = selectedYear = "";
    }
    public ArrayList<String> getYearList() {
        return this.yearList;
    }
    public ArrayList<String> getSemesterList() {
        return this.semesterList;
    }
    public String getSelectedYear() {
        return this.selectedYear;
    }
    public String getSelectedSemester() {
        return this.selectedSemester;
    }
    public String getPopmsg() {
        return this.popmsg;
    }

    public String getErrorTitle() {
        return this.errorTitle;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String getYear() {
        return this.year;
    }

    @Override
    public String getSemester() {
        return this.semester;
    }

    @Override
    public void createYearList(ArrayList<String> years) {
        this.yearList = years;
    }

    @Override
    public void createSemesterList(ArrayList<String> semesters) {
        this.semesterList = semesters;
    }

    @Override
    public void confirmBox(String title, String txt) {
        this.errorTitle = title;
        this.errorMessage = txt;
    }

    @Override
    public void popNotification(String msg) {
        popmsg = msg;
    }

    @Override
    public void goToRegistration(String year, String semester) {
        this.selectedSemester = semester;
        this.selectedYear = year;
    }

    @Override
    public void changeToHomeScreen() {}
}
