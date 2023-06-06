package gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectRegistration;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.dao.SubjectDAO;
import gr.aueb.softeng.team02.model.OfferedSubject;
import gr.aueb.softeng.team02.model.Subject;
import gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectPresenter;
import gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectView;

public class OfferedSubjectRegistrationPresenter {

    OfferedSubjectRegistrationView view;
    OfferedSubjectDAO offeredSubjects;
    SubjectDAO subjects;
    public OfferedSubjectRegistrationPresenter(OfferedSubjectRegistrationView view, OfferedSubjectDAO offeredSubjects, SubjectDAO subjects) {
        this.view = view;
        this.offeredSubjects = offeredSubjects;
        this.subjects = subjects;
    }

    public void init(String year, String semester) {
        List<Subject> subj = subjects.findAll();
        ArrayList<String> subs = new ArrayList<>();
        for (Subject sub : subj) {
            subs.add(sub.getTitle());
        }
    }
}
