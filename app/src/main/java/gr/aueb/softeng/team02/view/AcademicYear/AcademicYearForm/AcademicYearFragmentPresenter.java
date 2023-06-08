package gr.aueb.softeng.team02.view.AcademicYear.AcademicYearForm;

import android.util.Log;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.model.Circumscription;

public class AcademicYearFragmentPresenter {

    private AcademicYearFragmentView view;
    Circumscription c;
    private AcademicYearDAO years;
    private String year;

    public AcademicYearFragmentPresenter(AcademicYearDAO years) {
        this.years = years;
    }

    public void setView(AcademicYearFragmentView view) {
        this.view = view;
    }
    public void onSeeAcademicYear()
    {
        view.showAcYearsRegistration();
    }

    public ArrayList<String> get_academic_years() {
        ArrayList<String> ac_years = new ArrayList<>();
        for (AcademicYear year : this.years.findAll()) {
            ac_years.add(year.getAc_year());
        }
        return ac_years;
    }
    public ArrayList<String> get_semesters() {
        ArrayList<String> semesters = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            semesters.add(String.valueOf(i));
        }
        return semesters;
    }

    private boolean allWritten()
    {
        return !view.getSelectedYear().equals("") && !view.getSelectedSemester().equals("") && !view.getECTS().equals("");
    }
    public void checkValidity()
    {
        if (allWritten() && checkECTS() && hasFormatOfDate(view.getDateStart()) && hasFormatOfDate(view.getDateStart())) {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            int semester = Integer.parseInt(view.getSelectedSemester());
            LocalDate date1 = LocalDate.parse(view.getDateStart(), formatter);
            LocalDate date2 = LocalDate.parse(view.getDateEnd(), formatter);
            int ects = Integer.parseInt(view.getECTS());
            this.c = new Circumscription(semester, ects, date1, date2);
            if (this.c.checkValidity())
            {
                view.setVisibleSubmit();
            }

        }
        else {
            if(view.getECTS().equals("")||checkECTS())
                view.setVisibleFirstX();
            if(view.getDateStart().equals("")||hasFormatOfDate(view.getDateStart()))
                view.setVisibleSecondX();
            if(view.getDateEnd().equals("")||hasFormatOfDate(view.getDateEnd()))
                view.setVisibleThirdX();
        }
    }

    private boolean checkECTS()
    {

        if (isNumeric(view.getECTS()))
        {
            int ects = Integer.parseInt(view.getECTS());
            return ects >= 30 && ects <= 130;
        }
        return false;
    }
    private boolean hasFormatOfDate(String date)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        try {
            // Attempt to parse the string into a LocalDate object
            LocalDate.parse(date, formatter);
            return true; // Parsing succeeded, string has the expected format
        } catch (DateTimeParseException e) {
            return false; // Parsing failed, string does not have the expected format
        }
    }

    private boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public void createAcademicYearCircumscription() {
        try{
            years.find(view.getSelectedYear()).addCircumscription(this.c);
            view.messageSave();
        }
        catch (AcademicYearException e)
        {
            view.alertMessage("Warning", "There is already a circumscription for the same year and semester.\n Do you want to override it?");
        }
    }

    /**
     *
     */
    public void overrideCirc()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        LocalDate date1 = LocalDate.parse(view.getDateStart(), formatter);
        LocalDate date2 = LocalDate.parse(view.getDateEnd(), formatter);

        //int y = years.find(view.getSelectedYear()).getCircumscription(Integer.parseInt(view.getSelectedSemester())).getEcts();

        //Log.e("DEBBUGER",String.valueOf(y));

        years.find(view.getSelectedYear()).getCircumscription(Integer.parseInt(view.getSelectedSemester())).setEcts(Integer.parseInt(view.getECTS()));
        years.find(view.getSelectedYear()).getCircumscription(Integer.parseInt(view.getSelectedSemester())).setStart(date1);
        years.find(view.getSelectedYear()).getCircumscription(Integer.parseInt(view.getSelectedSemester())).setEnd(date2);
        view.messageOverride();

     //   int x = years.find(view.getSelectedYear()).getCircumscription(Integer.parseInt(view.getSelectedSemester())).getEcts();
       // Log.e("DEBBUGER",String.valueOf(x));


    }

    public void initLists() {
        view.createYearList(get_academic_years());
        view.createSemesterList(get_semesters());
    }

}
