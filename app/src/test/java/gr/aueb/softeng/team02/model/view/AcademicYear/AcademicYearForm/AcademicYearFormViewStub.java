package gr.aueb.softeng.team02.model.view.AcademicYear.AcademicYearForm;

import java.time.LocalDate;
import java.util.ArrayList;

import gr.aueb.softeng.team02.view.AcademicYear.AcademicYearForm.AcademicYearFragmentView;

public class AcademicYearFormViewStub implements AcademicYearFragmentView {

    private int ects;
    private LocalDate start_date, end_date;
    private String message_save, message_not_valid, message_alert, message_override, title, message;
    private ArrayList<String> year_list, semester_list;

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }


    @Override
    public String getSelectedYear() {
        return null;
    }

    @Override
    public void createYearList(ArrayList<String> years) {
        this.year_list = years;
    }

    @Override
    public void createSemesterList(ArrayList<String> semesters) {
        this.semester_list = semesters;
    }

    @Override
    public String getSelectedSemester() {
        return semester_list.get(0);
    }

    @Override
    public void showAcYearsRegistration() {

    }

    @Override
    public String getECTS() {
        return null;
    }

    @Override
    public String getDateStart() {
        return null;
    }

    @Override
    public String getDateEnd() {
        return null;
    }

    @Override
    public void messageSave() {

    }

    @Override
    public void setVisibleSubmit() {

    }

    @Override
    public void alertMessage(String title, String message) {
        this.title = title;
        this.message = message;
    }

    @Override
    public void messageOverride() {

    }

    @Override
    public void setVisibleFirstX() {

    }

    @Override
    public void setVisibleSecondX() {

    }

    @Override
    public void setVisibleThirdX() {

    }

    @Override
    public void messageNotValidCirc() {

    }
}
