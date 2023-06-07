package gr.aueb.softeng.team02.view.Search.Information;

import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.model.OfferedSubject;

public class InformationPresenter {

    private OfferedSubjectDAO subjects;
    private InformationView view;

    public InformationPresenter(OfferedSubjectDAO subs) {
        this.subjects = subs;
    }

    public void setView(InformationView view) {
        this.view = view;
    }

    public void setInfo(String title) {

        OfferedSubject sub = subjects.findByTitle(title);
        view.showInfo(sub.getTitle(), sub.getProf(), sub.getEcts(), sub.getSubject().getId(), sub.getDesc());


    }
}
