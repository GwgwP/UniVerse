package gr.aueb.softeng.team02.model.view.Subject.SubjectAdd;


import java.util.ArrayList;

import gr.aueb.softeng.team02.view.Subject.SubjectAdd.SubjectFormView;

public class SubjectAddViewStub implements SubjectFormView {
    String title;
    String desc;
    String prof;
    String ects;

    ArrayList<String> prerequisites;
    int ectsNumber;
    boolean exTitle;
    boolean exProf;
    boolean exEcts;
    boolean exDesc;

    static int message;

    @Override
    public String getSubTitle() {
        return title;
    }

    @Override
    public String getProf() {
        return prof;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public String getEcts() {
        return ects;
    }

    @Override
    public void setexTitle() {
        this.exTitle = true;
    }

    @Override
    public void setexProf() {
        this.exProf = true;
    }

    @Override
    public void setexEcts() {
        this.exEcts = true;
    }

    @Override
    public void setexDesc() {
        this.exDesc = true;
    }

    @Override
    public void printEr1() {

    }

    @Override
    public void invTitle() {

    }

    @Override
    public void invDesc() {
        this.exDesc = false;
    }

    @Override
    public void invProf() {
        this.exProf = false;
    }

    @Override
    public void invEcts() {
        this.exEcts = false;
    }

    @Override
    public void sameSubject() {

    }

    @Override
    public void messageSave() {

    }

    @Override
    public void getBack() {

    }

    @Override
    public void invalidInput() {

    }

    @Override
    public ArrayList<String> getPrereq() {
        return prerequisites;
    }

    @Override
    public void setForm(ArrayList<String> titles) {
        this.prerequisites = titles;

    }

    public int getSizePrerequisties() {
        return prerequisites.size();
    }

    public void setMessage() {
        SubjectAddViewStub.message = 0;
    }

    public int getMessage() {
        return SubjectAddViewStub.message;
    }

    public void setSubject(String title, String desc, String ects, String prof) {
        this.title = title;
        this.prof = prof;
        this.ects = ects;
        this.desc = desc;
    }

    public boolean getExTitle() {
        return this.exTitle;
    }

    public boolean getExProf() {
        return this.exProf;
    }

    public boolean getExDesc() {
        return this.exDesc;
    }

    public boolean getExEcts() {
        return this.exEcts;
    }


}
