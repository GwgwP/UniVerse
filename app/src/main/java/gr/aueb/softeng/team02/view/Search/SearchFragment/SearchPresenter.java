package gr.aueb.softeng.team02.view.Search.SearchFragment;

import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;

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

    public void decide(String title){

        if(subjects.findByTitle(title)!=null){
           view.showInfo(title);
       }
       else{
            view.errorTitle();
       }
    }

    public String getTitle(){

        return view.getSubTitle();
    }

}
