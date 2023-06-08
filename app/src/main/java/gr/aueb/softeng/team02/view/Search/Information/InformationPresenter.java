package gr.aueb.softeng.team02.view.Search.Information;

import java.util.ArrayList;
import java.util.Set;

import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.model.OfferedSubject;
import gr.aueb.softeng.team02.model.Subject;

public class InformationPresenter {

    private OfferedSubjectDAO subjects;
    private InformationView view;

    public InformationPresenter(OfferedSubjectDAO subs) {
        this.subjects = subs;
    }

    public void setView(InformationView view) {
        this.view = view;
    }

    /**
     * Gets the information os a specific offered subject from the database and show them
     *
     * @param title : the selected offered subject
     **/
    public void setInfo(String title) {
        ArrayList<String> prerequisites = new ArrayList<>();
        OfferedSubject sub = subjects.findByTitle(title);
        Set<Subject> getprer = sub.getSubject().getPrerequisities();

        for(Subject name : getprer){
            prerequisites.add(name.getTitle());

        }

        view.showInfo(sub.getTitle(), sub.getProf(), sub.getEcts(), sub.getSubject().getId(), sub.getDesc(),prerequisites);


    }
}
