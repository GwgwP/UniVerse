package gr.aueb.softeng.team02.view.Subject.SubjectFragment;

import gr.aueb.softeng.team02.dao.SubjectDAO;

public class SubjectPresenter {

    private SubjectDAO subs;
    private SubjectView view;
    public SubjectPresenter(SubjectDAO sub){
        this.subs=sub;
    }

    public void setView(SubjectView view){
        this.view=view;
    }

    public void showSub(){
        view.viewSubs(subs.findAll());
    }

    public void addForm(){
        view.showForm();

    }



}
