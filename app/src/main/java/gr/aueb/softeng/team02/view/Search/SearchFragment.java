package gr.aueb.softeng.team02.view.Search;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.OfferedSubject;
import gr.aueb.softeng.team02.view.SubjectInfo;


public class SearchFragment extends Fragment implements SearchView{


        private Initializer init;
        private LinearLayout subjectContainer;
        private View myView;

        private int student_id;
        private static List<OfferedSubject> subList ;

        private SearchPresenter presenter;

//TODO presenter does the switch to another Activity
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        myView = inflater.inflate(R.layout.fragment_search, container, false);

        subjectContainer = myView.findViewById(R.id.subjectContainer);

        //Bundle bundle = getArguments();
        //this.student_id = bundle.getInt("STUDENT_ID", 0);

        init = new MemoryInitializer();


        presenter.initSubView();

        return myView;
    }

    public void viewSub(List<OfferedSubject> sub){

        for( OfferedSubject k : subList){
            String title = k.getTitle();
            TextView subjectTextView = createSubjectTextView(title); // we make a new TextView that has the subject title
            subjectContainer.addView(subjectTextView);

        }
    }

    public TextView createSubjectTextView(String title){
        TextView textView = new TextView(requireContext());
        textView.setText(title);
        textView.setPadding(16, 16, 16, 16);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override

            //TODO the presenter does that;
            public void onClick(View v) {
                // Redirect to another activity based on the selected subject
                Intent intent = new Intent(requireContext(), SubjectInfo.class);
                intent.putExtra("subject", title);
                startActivity(intent);
            }
        });
        return textView;
            }





}