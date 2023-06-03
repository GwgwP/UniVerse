package gr.aueb.softeng.team02.view.Search;

import java.util.ArrayList;

import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.view.Submission.SubmissionFragmentView;

public class SearchPresenter {


    private OfferedSubjectDAO subjects;



    private SearchView view;


    public SearchPresenter(OfferedSubjectDAO subs){
        this.subjects=subs;
    }

    public void setView(SearchView view) {
        this.view = view;
    }


    public void initSubView(){
        view.viewSub(subjects.findAll());

    }

}
