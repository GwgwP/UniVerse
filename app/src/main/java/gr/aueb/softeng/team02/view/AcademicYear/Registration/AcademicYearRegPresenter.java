package gr.aueb.softeng.team02.view.AcademicYear.Registration;

import android.text.TextUtils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;
import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.model.AcademicYear;


/**
 * @author Georgia Petsa
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2022-2023
 *
 */

public class AcademicYearRegPresenter {

    private AcademicYearRegistration view;
    private final AcademicYearDAO ac_years;

    /**
     * Constructor
     * @param view view instance
     * @param ac_years academic year instance
     */
    public AcademicYearRegPresenter(AcademicYearRegistration view, AcademicYearDAO ac_years) {
        this.ac_years = ac_years;
        this.view = view;
    }


    /**
     *
     * @param view sets the view instance
     */
    public void setView(AcademicYearRegistration view) {
        this.view = view;
    }

    /**
     * Checks if all the attributes are valid in order to
     * add the new academic year and save it.
     * All the fields should be written, in the correct format.
     * The month of the start date should be even
     * and the month of the end date should be odd.
     * triggers the "x"s from the view
     * whenever the corresponding field is not valid
     */
    public void valid() {
        if (allWritten()) {
            if (hasFormatOfAcademicYear(view.getAcademicYear()) && hasFormatOfDate(view.getStartDate()) && hasFormatOfDate(view.getEndDate())) {

                DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
                LocalDate start_date = LocalDate.parse(view.getStartDate(), formatter);
                LocalDate end_date = LocalDate.parse(view.getEndDate(), formatter);

                //if there is already a year inside th datastore
                if(ac_years.find(view.getAcademicYear())!=null)
                {
                    view.messageDIDNTSave();
                    return;
                }
                if(isODD(start_date.getMonthValue()))
                    view.setVisibleSecondX();
                if(!isODD(end_date.getMonthValue()))
                    view.setVisibleThirdX();
                if (!isODD(start_date.getMonthValue()) && isODD(end_date.getMonthValue())) {
                    AcademicYear ac = new AcademicYear(view.getAcademicYear(), start_date, end_date);
                    this.ac_years.save(ac);
                    view.messageSave();
                }

            }
            if(!hasFormatOfAcademicYear(view.getAcademicYear()))
                view.setVisibleFirstX();

        } else {
            if (view.getAcademicYear().equals("") || !hasFormatOfDate(view.getStartDate()))
                view.setVisibleFirstX();
            if (view.getStartDate().equals("") || !hasFormatOfDate(view.getEndDate()))
                view.setVisibleSecondX();
            if (view.getEndDate().equals("") || !hasFormatOfAcademicYear(view.getAcademicYear()))
                view.setVisibleThirdX();
            if(!hasFormatOfAcademicYear(view.getAcademicYear()))
                view.setVisibleFirstX();
        }
    }

    /**
     * decides if a month is odd
     * @param month the month
     * @return returns if the month is odd.
     */
    private boolean isODD(int month) {
        return month % 2 != 0;
    }

    /**
     *
     * @param date_string string of date given
     * @return returns if the given string has the correct format of date
     * ex "2023-02-01" is valid.
     */
    private boolean hasFormatOfDate(String date_string) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        try {
            // Attempt to parse the string into a LocalDate object
            LocalDate.parse(date_string, formatter);
            return true; // Parsing succeeded, string has the expected format
        } catch (DateTimeParseException e) {
            return false; // Parsing failed, string does not have the expected format
        }
    }

    /**
     *
     * @param ac academic year
     * @return returns if the academic year has the correct format
     * in order to be able to be saved.
     * ex "2023-2024" is valid
     */
    private boolean hasFormatOfAcademicYear(String ac) {
        if (ac != null) {
            String regex = "\\d{4}-\\d{4}";
            return Pattern.matches(regex, ac);
        }
        return false;
    }

    /**
     *
     * @return returns if all the fields are written
     */
    public boolean allWritten() {
        String acYear = view.getAcademicYear();
        String startDate = view.getStartDate();
        String endDate = view.getEndDate();
        return !TextUtils.isEmpty(acYear) && !TextUtils.isEmpty(startDate) && !TextUtils.isEmpty(endDate);
    }

}
