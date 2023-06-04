package gr.aueb.softeng.team02.view.Search.Information;

import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;

public class InformationPresenter {

    private OfferedSubjectDAO subjects;
    private InformationView view;

    public InformationPresenter(OfferedSubjectDAO subs){this.subjects=subs;}

    public void setView(InformationView view) {
        this.view = view;
    }

    public void setInfo(String title){

        view.showInfo(subjects.findByTitle(title));
    }
}
