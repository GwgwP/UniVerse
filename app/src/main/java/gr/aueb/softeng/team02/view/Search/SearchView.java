package gr.aueb.softeng.team02.view.Search;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.team02.model.OfferedSubject;

public interface SearchView {

    public void viewSub(List<OfferedSubject> sub);

    public TextView createSubjectTextView(String title);

    public String getSubTitle();

    public void showInfo(String title);

    public void errorTitle();
}
