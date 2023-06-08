package gr.aueb.softeng.team02.view.AcademicYear.Registration;

import android.view.View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.model.AcademicYear;

public class AcademicYearRegPresenter {

    private AcademicYearRegistration view;
    private AcademicYearDAO ac_years;

    public AcademicYearRegPresenter(AcademicYearRegistration view, AcademicYearDAO ac_years) {
        this.ac_years = ac_years;
        this.view = view;
    }

    public AcademicYearRegistration getView() {
        return view;
    }

    public void setView(AcademicYearRegistration view) {
        this.view = view;
    }

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
                if (!isODD(start_date.getMonthValue()) && isODD(end_date.getMonthValue())) {
                    AcademicYear ac = new AcademicYear(view.getAcademicYear(), start_date, end_date);
                    this.ac_years.save(ac);
                    view.messageSave();
                }
                else
                {
                    if(!isODD(start_date.getMonthValue()))
                        view.setVisibleSecondX();
                    else
                        view.setVisibleThirdX();
                }

            }

        } else {
            if (view.getAcademicYear().equals("") || !hasFormatOfDate(view.getStartDate()))
                view.setVisibleFirstX();
            if (view.getStartDate().equals("") || !hasFormatOfDate(view.getEndDate()))
                view.setVisibleSecondX();
            if (view.getEndDate().equals("") || !hasFormatOfAcademicYear(view.getAcademicYear()))
                view.setVisibleThirdX();
        }
    }

    private boolean isODD(int month) {
        return month % 2 != 0;
    }

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

    private boolean hasFormatOfAcademicYear(String ac) {
        //TODO IMPLEMENT CHECKER
        return true;
    }

    public boolean allWritten() {
        String acyear = view.getAcademicYear();
        String sd = view.getStartDate();
        String ed = view.getEndDate();
        return !acyear.equals("") && !sd.equals("") && !ed.equals("");
    }

    public void createAcademicYear() {

    }

}
