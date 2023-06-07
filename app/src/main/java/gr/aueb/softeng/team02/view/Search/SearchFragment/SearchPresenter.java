package gr.aueb.softeng.team02.view.Search.SearchFragment;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.model.OfferedSubject;

public class SearchPresenter {


    private OfferedSubjectDAO subjects;

    private AcademicYearDAO years;


    private SearchView view;


    public SearchPresenter(OfferedSubjectDAO subs, AcademicYearDAO years) {

        this.subjects = subs;
        this.years = years;
    }

    public void setView(SearchView view) {
        this.view = view;
    }


    public void initSubView() {
        ArrayList<String> titles = new ArrayList<>();
        List<OfferedSubject> offeredSubjects = subjects.findByYear(years.getCurrentAcadYear().getAc_year());
        for (OfferedSubject k : offeredSubjects) {
            titles.add(k.getTitle());
        }
        view.viewSub(titles);
    }

    public void decide(String title) {

        if (subjects.findByTitle(title) != null) {
            view.showInfo(title);
        } else {
            view.errorTitle();
        }
    }

    public String getTitle() {

        return view.getSubTitle();
    }

}
