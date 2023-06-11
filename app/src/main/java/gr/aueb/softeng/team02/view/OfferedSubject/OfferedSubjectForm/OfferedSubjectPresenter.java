package gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectForm;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.dao.SubjectDAO;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.OfferedSubject;

public class OfferedSubjectPresenter {
    OfferedSubjectDAO offeredSubjects;
    AcademicYearDAO years;
    OfferedSubjectView view;

    /**
     * Contructor that initializes all the daos
     *
     * @param view            OfferedSubjectView view
     * @param offeredSubjects OfferedSubjectDAO
     * @param years           AcademicYearDAO
     */
    public OfferedSubjectPresenter(OfferedSubjectView view, OfferedSubjectDAO offeredSubjects, AcademicYearDAO years) {
        this.offeredSubjects = offeredSubjects;
        this.years = years;
        this.view = view;
    }

    /**
     * All registered academic year in a String list
     *
     * @return a list of years of the academic year dao
     */
    public ArrayList<String> getAcademicYears() {
        ArrayList<String> ac_years = new ArrayList<>();
        for (AcademicYear year : this.years.findAll()) {
            ac_years.add(year.getAc_year());
        }
        return ac_years;
    }

    /**
     * All semesters in a String list
     *
     * @return a list of years of all semesters
     */
    public ArrayList<String> getSemesters() {
        ArrayList<String> semesters = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            semesters.add(String.valueOf(i));
        }
        return semesters;
    }

    /**
     * Initializes the year and semester list
     */
    public void initLists() {
        view.createYearList(getAcademicYears());
        view.createSemesterList(getSemesters());
    }

    /**
     * Check for the selected year and semester if it does exist at least one offered subject
     */
    public void checkSelected() {
        String year = view.getYear();
        String semester = view.getSemester();

        List<OfferedSubject> subjects = offeredSubjects.findAllSubjectsByYearAndBySemester(year, Integer.parseInt(semester));

        boolean answer = false;
        if (subjects.size() != 0)
            view.confirmBox("Notification", "You have already registered offered subjects for this year.Do you want to keep them ?");
        else
            view.goToRegistration(year, semester);
    }

    /**
     * Called when the secretary erases all the previous offered subjects.
     * Gives the command to transfer the user to the Offered Subject Registration Activity
     */
    public void onRegistration() {
        String year = view.getYear();
        String semester = view.getSemester();

        List<OfferedSubject> subjects = offeredSubjects.findAllSubjectsByYearAndBySemester(year, Integer.parseInt(semester));

        for (OfferedSubject sub : subjects) {
            offeredSubjects.delete(sub);
        }
        view.popNotification("Deletion completed");
        view.goToRegistration(year, semester);
    }

    /**
     * Transfers the secretary to the home screen
     */
    public void changeLayout() {
        view.changeToHomeScreen();
    }
}
