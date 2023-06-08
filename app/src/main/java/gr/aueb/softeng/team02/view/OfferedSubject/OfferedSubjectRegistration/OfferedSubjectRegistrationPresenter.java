package gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectRegistration;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.dao.SubjectDAO;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.OfferedSubject;
import gr.aueb.softeng.team02.model.Subject;

public class OfferedSubjectRegistrationPresenter {
    String semester;
    String year;
    OfferedSubjectRegistrationView view;
    OfferedSubjectDAO offeredSubjects;
    OfferedSubject selectedSubject;
    AcademicYearDAO years;
    SubjectDAO subjects;

    /**
     * Constructor that initializes the view and the daos
     *
     * @param view            OfferedSubjectRegistrationView
     * @param offeredSubjects OfferedSubjectDAO
     * @param subjects        SubjectDAO
     * @param years           AcademicYearDAO
     */
    public OfferedSubjectRegistrationPresenter(OfferedSubjectRegistrationView view, OfferedSubjectDAO offeredSubjects, SubjectDAO subjects, AcademicYearDAO years) {
        this.view = view;
        this.offeredSubjects = offeredSubjects;
        this.subjects = subjects;
        this.years = years;
    }

    /**
     * Initialized the table of the offered subjects shown in
     * the secretary
     *
     * @param year     selected year
     * @param semester selected semester
     */
    public void init(String year, String semester) {
        this.semester = semester;
        this.year = year;
        List<Subject> subj = subjects.findAll();
        ArrayList<String> subs = new ArrayList<>();
        for (Subject sub : subj) {
            subs.add(sub.getTitle());
        }
        view.createTable(subs);
    }

    /**
     * Called when the secretary selects a subject
     *
     * @param title
     */
    public void checkSubject(String title) {
        OfferedSubject sub = offeredSubjects.findByYearAndName(year, title);

        if (sub != null) {
            view.alertBox("Warning", "This subject is already on another semester! \n Do you want to move it to the " + semester + "semester ?");
            this.selectedSubject = sub;
        }
    }

    /**
     * It is called when the secretary wants to change the semester of
     * pre-selected offered subject in another semester
     */
    public void moveSubject() {
        this.offeredSubjects.delete(this.selectedSubject);
        view.setCheckBox(true);
        try {
            this.selectedSubject.setSemester(Integer.parseInt(semester));

            this.offeredSubjects.save(this.selectedSubject);
            view.moveReminder("The subject " + "\'" + this.selectedSubject.getTitle() + "\'" + " has it's semester moved");
        } catch (Exception e) {
            System.err.println("Wrong semester");
        }
    }

    /**
     * It is called when the secretary doesn't want to change the semester of
     * pre-selected offered subject in another semester
     */
    public void remainSubject() {
        view.moveReminder("No change");
        view.setCheckBox(false);
    }

    /**
     * After the submit button is clicked, creates offered subject objects and save them
     * in the dao
     */
    public void register() {
        ArrayList<String> titles = view.submitClicked();

        if (titles.size() == 0) {
            view.errorBox("Error", "Select at least one subject");
            return;
        }

        for (String title : titles) {
            Subject subject = subjects.findSubject(title);
            AcademicYear year = years.find(this.year);
            offeredSubjects.save(new OfferedSubject(Integer.parseInt(semester), subject, year));
        }

        view.moveReminder("Your registration was a success !");
        view.changeToHomeScreen();
    }
}
