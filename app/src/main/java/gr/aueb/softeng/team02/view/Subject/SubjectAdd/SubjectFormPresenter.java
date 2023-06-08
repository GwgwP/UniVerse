package gr.aueb.softeng.team02.view.Subject.SubjectAdd;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.team02.dao.SubjectDAO;
import gr.aueb.softeng.team02.model.Subject;

public class SubjectFormPresenter {

    private SubjectFormView view;
    private SubjectDAO sub;

    public SubjectFormPresenter(SubjectDAO sub) {
        this.sub = sub;
    }

    public void setView(SubjectFormView view) {
        this.view = view;
    }

    /**
     * checks to see if the form is valid. All the boxes are written , if there are numbers in the ects box , and it also checks if
     * there already is the same subject in the database
     **/
    public void valid() {
        ArrayList<String> titles = view.getPrereq();
        String title = view.getSubTitle();
        if (allWritten()) { // we first check if all the attributes are written
            if ((isNumber(view.getEcts()))) { // IF THE USER  WROTE NUMBERS
                if (this.sub.exists(title)) { // we check if we have another Subject with the same name
                    errorExist();

                } else {
                    int ects = Integer.parseInt(view.getEcts());
                    Subject a = new Subject(view.getProf(), ects, view.getDesc(), title);
                    for(String k : titles){ // we save every prerequisite
                        Subject ad= sub.findSubject(k.trim());
                        try {
                            a.addPrerequisities(ad);
                        }  catch (Exception e){
                            return;
                        }
                    }

                    this.sub.save(a);
                    view.messageSave();
                    goBack();
                }
            } else { // if the ects box was written with letters;
                view.invEcts();
                view.invTitle();
                view.invDesc();
                view.invProf();

                view.setexEcts();
                view.invalidInput();

            }
        } else { // not all the boxes where written
            errorNotWritten();
        }

    }

    /**
     * Shows an error when not all the boxes are written
     **/
    private void errorNotWritten() {

        // We make them invisible in the case they were some visible
        view.invTitle();
        view.invDesc();
        view.invProf();
        view.invEcts();


        String title = view.getSubTitle();
        String prof = view.getProf();
        String desc = view.getDesc();
        String ects = view.getEcts();


        if (title.equals("")) {
            view.setexTitle();
        }
        if (prof.equals("")) {
            view.setexProf();
        }
        if (desc.equals("")) {
            view.setexDesc();
        }
        if (ects.equals("")) {
            view.setexEcts();
        }
        view.printEr1();

    }

    /**
     * Shows a message when there is  already another subject with the same name
     **/
    public void errorExist() {
        view.sameSubject();

    }

    /**
     * Checks to see if all the boxes are written
     *
     * @return true or false
     **/
    public boolean allWritten() {
        String title = view.getSubTitle();
        String prof = view.getProf();
        String desc = view.getDesc();
        String ects = view.getEcts();
        ArrayList<String> titles = view.getPrereq();

        if (title.equals("") || prof.equals("") || desc.equals("") || ects.equals("")|| (titles.size()==0)) {
            return false;
        }
        return true;
    }

    /**
     * we save the newest version of the subjects information
     **/
    public void createSubject() {
        String title = view.getSubTitle();
        Subject k = this.sub.findSubject(title);

        k.setProfessor(view.getProf());
        k.setDesc(view.getDesc());

        k.setECTS(Integer.parseInt(view.getEcts()));
        view.messageSave();

    }

    /**
     * Navigates to the home screen
     **/
    public void goBack() {
        view.getBack();
    }

    /**
     * Checks to see if the input is a number
     *
     * @param k : the input
     * @return true or false
     **/
    public boolean isNumber(String k) {
        return k.matches("\\d+");

    }

    public ArrayList<String> getSubjects(){
        ArrayList<String> subs = new ArrayList<>();

        for(Subject k : sub.findAll()){
            subs.add(k.getTitle());
        }

        return subs;

    }

    public void makeForm(){
        view.setForm(getSubjects());
    }


}
