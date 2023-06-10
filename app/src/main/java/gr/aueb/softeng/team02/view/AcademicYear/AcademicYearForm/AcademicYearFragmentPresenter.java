package gr.aueb.softeng.team02.view.AcademicYear.AcademicYearForm;

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
    private final AcademicYearDAO years;


    /**
     *
     * @param years instance of years
     */
    public AcademicYearFragmentPresenter(AcademicYearDAO years) {
        this.years = years;
    }

    /**
     *
     * @param view instance of view
     */
    public void setView(AcademicYearFragmentView view) {
        this.view = view;
    }
    public void onSeeAcademicYear()
    {
        view.showAcYearsRegistration();
    }

    /**
     *
     * @return returns a list with academic years that are stored
     */
    private ArrayList<String> get_academic_years() {

        ArrayList<String> ac_years = new ArrayList<>();
        for (AcademicYear year : this.years.findAll()) {
            ac_years.add(year.getAc_year());
        }
        return ac_years;
    }

    /**
     * creates a list with semesters from 1-8
     * @return the list with the semesters
     */
    private ArrayList<String> get_semesters() {
        ArrayList<String> semesters = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            semesters.add(String.valueOf(i));
        }
        return semesters;
    }

    /**
     * checks if all fields are written by the user
     * @return boolean
     */
    private boolean allWritten()
    {
        return !view.getSelectedYear().equals("") && !view.getSelectedSemester().equals("") && !view.getECTS().equals("");
    }

    /**
     * checks if the circumscription form is valid
     * and makes visible the submit button.
     * triggers the correspiding "x" images in the
     * presenter for every field that is not valid
     */
    public void checkValid()
    {
        /*boolean allFieldsWritten = allWritten();
        boolean validECTS = checkECTS();
        boolean validStartDate = hasFormatOfDate(view.getDateStart());
        boolean validEndDate = hasFormatOfDate(view.getDateEnd());

        if (allFieldsWritten && validECTS && validStartDate && validEndDate) {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            int semester = Integer.parseInt(view.getSelectedSemester());
            LocalDate date1 = LocalDate.parse(view.getDateStart(), formatter);
            LocalDate date2 = LocalDate.parse(view.getDateEnd(), formatter);
            int ects = Integer.parseInt(view.getECTS());
            this.c = new Circumscription(semester, ects, date1, date2);
            if (this.c.checkValidity()) {
                view.setVisibleSubmit();
            }
            else {
                view.messageNotValidCirc();
            }
        } else {
            if (!validECTS) {
                view.setVisibleFirstX();
            }
            if (!validStartDate) {
                view.setVisibleSecondX();
            }
            if (!validEndDate) {
                view.setVisibleThirdX();
            }
        }*/
        if (allWritten() && isNumeric(view.getECTS()) && hasFormatOfDate(view.getDateStart()) && hasFormatOfDate(view.getDateEnd())) {
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
            else {
                //we already know that the semesters will be between 1-8 so the only
                // case for not valid circumscription is that the ects will be outof range.
                view.setVisibleFirstX();
                view.messageNotValidCirc();
            }

        }
        else {
            if(view.getECTS().equals("")||!isNumeric(view.getECTS()))
                view.setVisibleFirstX();
            if(view.getDateStart().equals("")|| !hasFormatOfDate(view.getDateStart()))
                view.setVisibleSecondX();
            if(view.getDateEnd().equals("")|| !hasFormatOfDate(view.getDateEnd()))
                view.setVisibleThirdX();
        }
    }

    /**
     * checks if the ects given from the user are in
     * valid format and between th accepted values
     * @return boolean
     */
    /*private boolean checkECTS()
    {
        if (isNumeric(view.getECTS()))
        {
            int ects = Integer.parseInt(view.getECTS());
            return ects >= 30 && ects <= 130;
        }
        return false;
    }
*/
    /**
     * decides if a date has the correct format
     * of Local Date.
     * @param date the date given
     * @return boolean
     */
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


    /**
     * checks if a string given is a number
     * @param str the string to be checked
     * @return boolean
     */
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

    /**
     * adds the circumscription created in the corresponding academic year.
     */
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
     * overrides the ects, start date and end date stored to the user's input
     * when there is already a circumscription stored for the
     * same year and semester
     */
    public void overrideCirc()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        LocalDate date1 = LocalDate.parse(view.getDateStart(), formatter);
        LocalDate date2 = LocalDate.parse(view.getDateEnd(), formatter);

        try {
            years.find(view.getSelectedYear()).getCircumscription(Integer.parseInt(view.getSelectedSemester())).setEcts(Integer.parseInt(view.getECTS()));
            years.find(view.getSelectedYear()).getCircumscription(Integer.parseInt(view.getSelectedSemester())).setStart(date1);
            years.find(view.getSelectedYear()).getCircumscription(Integer.parseInt(view.getSelectedSemester())).setEnd(date2);
            view.messageOverride();
        } catch (AcademicYearException e) {
            // We already know the circumscription exists so we do not care in this case
            return;
        }

    }

    /**
     * initializes the academic years and semesters lists
     */
    public void initLists() {
        view.createYearList(get_academic_years());
        view.createSemesterList(get_semesters());
    }

}
