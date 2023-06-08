package gr.aueb.softeng.team02.view.Subject.SubjectFragment;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.team02.dao.SubjectDAO;
import gr.aueb.softeng.team02.model.Subject;

public class SubjectPresenter {

    private SubjectDAO subs;
    private SubjectView view;

    /**
     * Constructor that initializes the dao
     *
     * @param sub : SubjectDAO
     **/
    public SubjectPresenter(SubjectDAO sub) {
        this.subs = sub;
    }

    /**
     * Initializes the view
     *
     * @param view : SubjectView
     **/
    public void setView(SubjectView view) {
        this.view = view;
    }

    /**
     * Gets from the database all the saved subjects and shows them to the user
     **/
    public void showSub() {
        List<String> subjects = new ArrayList<>();

        for (Subject sub : subs.findAll()) {
            subjects.add(sub.getTitle());
        }
        view.viewSubs(subjects);
    }

    /**
     * Navigates to the next Activity
     **/
    public void addForm() {
        view.showForm();

    }


}
