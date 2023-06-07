package gr.aueb.softeng.team02.view.Subject;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.view.View;

import gr.aueb.softeng.team02.dao.SubjectDAO;
import gr.aueb.softeng.team02.view.Search.Information.InformationSubject;
import gr.aueb.softeng.team02.view.Secretary.HomeSecretaryActivity;

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
