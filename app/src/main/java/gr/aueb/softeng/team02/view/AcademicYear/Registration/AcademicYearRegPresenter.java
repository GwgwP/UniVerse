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
        if(allWritten())
        {
            if (hasFormatOfAcademicYear(view.getAcademicYear()) && hasFormatOfDate(view.getStartDate()) && hasFormatOfDate(view.getEndDate()))
            {
                DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
                LocalDate start_date = LocalDate.parse(view.getStartDate(), formatter);
                LocalDate end_date = LocalDate.parse(view.getEndDate(), formatter);
                AcademicYear ac = new AcademicYear(view.getAcademicYear(), start_date, end_date);
                this.ac_years.save(ac);
                view.messageSave();

            }

        }
        else{
            //TODO HERE GOES THE "X"s
        }
    }

    private boolean hasFormatOfDate(String date_string)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        try {
            // Attempt to parse the string into a LocalDate object
            LocalDate.parse(date_string, formatter);
            return true; // Parsing succeeded, string has the expected format
        } catch (DateTimeParseException e) {
            return false; // Parsing failed, string does not have the expected format
        }
    }
    private boolean hasFormatOfAcademicYear(String ac)
    {
        //TODO IMPLEMENT CHECKER
        return true;
    }
    public boolean allWritten() {
        String acyear = view.getAcademicYear();
        String sd = view.getStartDate();
        String ed = view.getEndDate();
        return !acyear.equals("") && !sd.equals("") && !ed.equals("");
    }

    public void createAcademicYear()
    {

    }

}
