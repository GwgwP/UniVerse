package gr.aueb.softeng.team02.view.Subject.SubjectFragment;

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
import gr.aueb.softeng.team02.view.Subject.SubjectAdd.SubjectForm;


public class SubjectFragment extends Fragment implements SubjectView {

    private Initializer init;
    private LinearLayout subjectList;
    private View myView;

    private Button addButton;
    private SubjectPresenter presenter;

    /** Initializer and waits for the addButton to be pushed**/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        myView = inflater.inflate(R.layout.fragment_subject, container, false);

        subjectList = myView.findViewById(R.id.subjectContainerSec);

        addButton = myView.findViewById(R.id.addSubjectButton);
        init = new MemoryInitializer();
        presenter = new SubjectPresenter(init.getSubjectDAO());
        presenter.setView(this);
        presenter.showSub();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.addForm();
            }
        });
        return myView;
    }
    /** Navigates to the next activity that shows the form to create a new Subject **/
    @Override
    public void showForm() {
        Intent intent = new Intent(requireContext(), SubjectForm.class);
        startActivity(intent);


    }
    /**
     * Shows a list with all the subjects that exist
     * @param sub : the subject list
    * **/
    @Override
    public void viewSubs(List<String> sub) {
        for (String k : sub) {
            TextView subjectTextView = createSubjectTextView(k); // we make a new TextView that has the subject title
            subjectList.addView(subjectTextView);
        }
    }
    /**Creates for a TextView that shows the title of the subject
     * @param title the subject's' title
     * @return the finished TextView **/
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