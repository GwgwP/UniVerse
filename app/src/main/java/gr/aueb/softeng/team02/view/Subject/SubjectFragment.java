package gr.aueb.softeng.team02.view.Subject;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.OfferedSubject;
import gr.aueb.softeng.team02.model.Subject;
import gr.aueb.softeng.team02.view.Search.Information.InformationSubject;
import gr.aueb.softeng.team02.view.Search.SearchPresenter;


public class SubjectFragment extends Fragment implements SubjectView {

    private Initializer init;
    private LinearLayout subjectList;
    private View myView;

    private Button addButton;
    private SubjectPresenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        myView = inflater.inflate(R.layout.fragment_subject, container, false);

        subjectList = myView.findViewById(R.id.subjectContainerSec);

        //addButton = myView.findViewWithTag(R.id.addSubjectButton);
        init = new MemoryInitializer();
        presenter = new SubjectPresenter(init.getSubjectDAO());
        presenter.setView(this);
        presenter.showSub();

       /* addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.addForm();
            }
        });*/


        return myView;
    }

    public void viewSubs(List<Subject> sub) {
        if (!sub.isEmpty()) {
            for (Subject k : sub) {
                String title = k.getTitle();
                TextView subjectTextView = createSubjectTextView(title); // we make a new TextView that has the subject title
                subjectList.addView(subjectTextView);

            }
        }
    }

    public TextView createSubjectTextView(String title) {

        TextView textView = new TextView(requireContext());
        textView.setText(title);
        textView.setTextSize(20);
        textView.setPadding(16, 16, 16, 16);

        View lineView = new View(requireContext());
        LinearLayout.LayoutParams lineLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);
        lineLayoutParams.setMargins(16, 0, 16, 0);
        lineView.setLayoutParams(lineLayoutParams);
        lineView.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.black));


        //subjectList.addView(lineView);


        return textView;
    }

}