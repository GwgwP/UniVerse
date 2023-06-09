package gr.aueb.softeng.team02.model.view.Search.SearchFragment;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.team02.view.Subject.SubjectFragment.SubjectView;

public class SeachFragmentViewStub implements SubjectView {

   List<String> names;
    @Override
    public void viewSubs(List<String> sub) {
        this.names = sub;
    }

    public int getNames(){
        return this.names.size();
    }

    int k = 0;
    @Override
    public void showForm() {
        k=1;
    }
}
