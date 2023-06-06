package gr.aueb.softeng.team02.view.OfferedSubject;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.dao.SubjectDAO;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.OfferedSubject;

public class OfferedSubjectPresenter {
    OfferedSubjectDAO offeredSubjects;
    SubjectDAO subjects;
    AcademicYearDAO years;
    OfferedSubjectView view;
    String semester;
    String year;

    public OfferedSubjectPresenter(OfferedSubjectView view, SubjectDAO subjects, OfferedSubjectDAO offeredSubjects, AcademicYearDAO years) {
        this.subjects = subjects;
        this.offeredSubjects = offeredSubjects;
        this.years = years;
        this.view = view;
    }

    public ArrayList<String> getAcademicYears() {
        ArrayList<String> ac_years = new ArrayList<>();
        for (AcademicYear year : this.years.findAll()) {
            ac_years.add(year.getAc_year());
        }
        return ac_years;
    }

    public ArrayList<String> getSemesters() {
        ArrayList<String> semesters = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            semesters.add(String.valueOf(i));
        }
        return semesters;
    }

    public void initLists() {
        view.createYearList(getAcademicYears());
        view.createSemesterList(getSemesters());
    }

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

    public void onRegistration(boolean answer) {
        String year = view.getYear();
        String semester = view.getSemester();

        List<OfferedSubject> subjects = offeredSubjects.findAllSubjectsByYearAndBySemester(year, Integer.parseInt(semester));

        if (!answer) {
            // TODO : delete the old elements
            for (OfferedSubject sub : subjects) {
                offeredSubjects.delete(sub);
            }
            view.popNotification("Deletion completed");
            view.goToRegistration(year, semester);
        }
    }
}
