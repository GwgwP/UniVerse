package gr.aueb.softeng.team02.view.AcademicYear;

import java.time.LocalDate;
import java.util.ArrayList;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.GradeDAO;
import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.dao.StudentDAO;
import gr.aueb.softeng.team02.dao.SubmissionDAO;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.Circumscription;
import gr.aueb.softeng.team02.view.Submission.SubmissionFragmentView;

public class AcademicYearFragmentPresenter {

    private AcademicYearFragmentView view;
    private AcademicYearDAO years;
    private String year;

    public AcademicYearFragmentPresenter(AcademicYearDAO years) {
        this.years = years;
    }

    public void setView(AcademicYearFragmentView view) {
        this.view = view;
    }

    public ArrayList<String> get_academic_years() {
        ArrayList<String> ac_years = new ArrayList<>();
        for (AcademicYear year : this.years.findAll()) {
            ac_years.add(year.getAc_year());
        }
        return ac_years;
    }
    public void addAcademicYear(String newYear){
        AcademicYear year = new AcademicYear(newYear);
        years.save(year);

    }


    public ArrayList<String> get_semesters() {
        ArrayList<String> semesters = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            semesters.add(String.valueOf(i));
        }
        return semesters;
    }


    public void startProcess() {



        view.startSubmission();
//        String ects = view.getECTS();
//        if (ects.equals(""))
//        {
//            view.initECTSX("Please enter ects number");
//        }

        //TODO view.showAlertMessage()
    }
    public int submitNewAcademicYear(String year, int sem, int ects)
    {
        //TODO INPUT FROM USER
        LocalDate date1 = null;
        LocalDate date2 = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
             date1 = LocalDate.of(2023, 4, 3);
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            date2 = LocalDate.of(2023, 5, 3);
        }

        Circumscription circumscription = new Circumscription(sem, ects,date1, date2);



        return 0;
    }


    public void initLists() {
        view.createYearList(get_academic_years());
        view.createSemesterList(get_semesters());
    }

}
