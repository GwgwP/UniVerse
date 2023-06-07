package gr.aueb.softeng.team02.view.Subject.SubjectFragment;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.team02.dao.SubjectDAO;
import gr.aueb.softeng.team02.model.Subject;

public class SubjectPresenter {

    private SubjectDAO subs;
    private SubjectView view;

    public SubjectPresenter(SubjectDAO sub) {
        this.subs = sub;
    }

    public void setView(SubjectView view) {
        this.view = view;
    }

    public void showSub() {
        List<String> subjects = new ArrayList<>();

        for (Subject sub : subs.findAll()) {
            subjects.add(sub.getTitle());
        }
        view.viewSubs(subjects);
    }

    public void addForm() {
        view.showForm();

    }


}
