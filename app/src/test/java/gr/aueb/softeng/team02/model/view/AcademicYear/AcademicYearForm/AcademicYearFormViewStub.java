package gr.aueb.softeng.team02.model.view.AcademicYear.AcademicYearForm;


import java.util.ArrayList;

import gr.aueb.softeng.team02.view.AcademicYear.AcademicYearForm.AcademicYearFragmentView;

public class AcademicYearFormViewStub implements AcademicYearFragmentView {
    private int fx;
    private int sx;
    private int tx;
    private int submit_visible;
    private int intent_to_reg;
    private int message_save;
    private int message_not_valid;
    private int message_alert;
    private int message_override;
    private int position_sem;
    private int position_year;
    private String start_date, end_date, academic_year, title, message, ects, semester, year;
    private ArrayList<String> year_list, semester_list;

    public int getIntent_to_reg() {
        return intent_to_reg;
    }

    public int getSubmit_visible() {
        return submit_visible;
    }

    public int getMessage_save() {
        return message_save;
    }

    public int getMessage_not_valid() {
        return message_not_valid;
    }

    public int getMessage_alert() {
        return message_alert;
    }

    public int getMessage_override() {
        return message_override;
    }

    public int getPosition_sem() {
        return position_sem;
    }

    public void setPosition_sem(int position_sem) {
        this.position_sem = position_sem;
    }

    public int getPosition_year() {
        return position_year;
    }

    public void setPosition_year(int position_year) {
        this.position_year = position_year;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }


    public String getTitle() {
        return title;
    }


    public String getMessage() {
        return message;
    }


    public void setYear(String year) {
        this.year = year;
    }


    public ArrayList<String> getSemester_list() {
        return semester_list;
    }


    @Override
    public String getSelectedYear() {
        return year_list.get(position_year);
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
        return semester_list.get(position_sem);
    }

    @Override
    public void showAcYearsRegistration() {
        this.intent_to_reg++;
    }

    @Override
    public String getECTS() {
        return ects;
    }

    public void setEcts(String ects) {
        this.ects = ects;
    }


    @Override
    public String getDateStart() {
        return start_date;
    }

    @Override
    public String getDateEnd() {
        return end_date;
    }

    @Override
    public void messageSave() {
        this.message_save++;
    }

    @Override
    public void setVisibleSubmit() {
        this.submit_visible++;
    }

    @Override
    public void alertMessage(String title, String message) {
        this.title = title;
        this.message = message;
        this.message_alert++;
    }

    @Override
    public void messageOverride() {
        this.message_override++;
    }

    @Override
    public void setVisibleFirstX() {
        this.fx++;
    }

    @Override
    public void setVisibleSecondX() {
        this.sx++;
    }

    @Override
    public void setVisibleThirdX() {
        this.tx++;
    }

    @Override
    public void messageNotValidCirc() {
        this.message_not_valid++;
    }

    public int getFx() {
        return fx;
    }

    public int getSx() {
        return sx;
    }

    public int getTx() {
        return tx;
    }
}
