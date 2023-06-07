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
    public OfferedSubjectRegistrationPresenter(OfferedSubjectRegistrationView view, OfferedSubjectDAO offeredSubjects, SubjectDAO subjects, AcademicYearDAO years) {
        this.view = view;
        this.offeredSubjects = offeredSubjects;
        this.subjects = subjects;
        this.years = years;
    }

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

    public void checkSubject(String title) {
        OfferedSubject sub = offeredSubjects.findByYearAndName(year, title);

        if (sub != null) {
            view.alertBox("Warning", "This subject is already on another semester! \n Do you want to move it to the " + semester + "semester ?");
            this.selectedSubject = sub;
        }
    }

    public void moveSubject(boolean flag) {
        if (flag) {
            this.offeredSubjects.delete(this.selectedSubject);
            view.setCheckBox(true);
            try {
                this.selectedSubject.setSemester(Integer.parseInt(semester));

                this.offeredSubjects.save(this.selectedSubject);
                view.moveReminder("The subject" + "\'" + this.selectedSubject.getTitle() + "\'" + " has it's semester moved");
            } catch (Exception e) {
                System.err.println("Wrong semester");
            }
        } else {
            view.moveReminder("No change");
            view.setCheckBox(false);
        }
    }

    public void register() {
        ArrayList<String> titles = view.submitClicked();
        for (String title : titles) {
            Subject subject = subjects.findSubject(title);
            AcademicYear year = years.find(this.year);
            offeredSubjects.save(new OfferedSubject(Integer.parseInt(semester), subject, year));
        }
        view.moveReminder("Your registration was a success !");
    }
}
