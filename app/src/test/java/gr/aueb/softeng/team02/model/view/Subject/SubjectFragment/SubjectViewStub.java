package gr.aueb.softeng.team02.model.view.Subject.SubjectFragment;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.team02.view.Subject.SubjectFragment.SubjectView;

public class SubjectViewStub  implements SubjectView {
    List<String> subjectArray;
    @Override
    public void viewSubs(List<String> sub) {
        this.subjectArray=sub;
    }

    public int getSize(){
        return this.subjectArray.size();
    }
    int k = 0;
    @Override
    public void showForm() {
        k=1;
    }
}
