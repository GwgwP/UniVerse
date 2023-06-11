package gr.aueb.softeng.team02.model.view.Search.SearchFragment;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.team02.view.Search.SearchFragment.SearchView;
import gr.aueb.softeng.team02.view.Subject.SubjectFragment.SubjectView;

public class SeachFragmentViewStub implements SearchView {

    List<String> tittles;

    public void setTitle(String title) {
        this.title = title;
    }

    String title;

    @Override
    public void viewSub(List<String> sub) {
        tittles = sub;
    }

    public List<String> getTittles() {
        return tittles;
    }

    public int getK() {
        return k;
    }

    int k = 0;

    @Override
    public String getSubTitle() {
        return title;
    }


    @Override
    public void showInfo(String title) {
        k=1;
    }

    @Override
    public void errorTitle() {
        k=2;
    }
}
