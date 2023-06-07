package gr.aueb.softeng.team02.view.Search;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.OfferedSubject;
import gr.aueb.softeng.team02.view.Search.Information.InformationSubject;


public class SearchFragment extends Fragment implements SearchView{
    private Initializer init;
    private LinearLayout subjectContainer;
    private View myView;


    private SearchPresenter presenter;

    EditText searchText;
    Button searchButton;

    //private SearchPresenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        myView = inflater.inflate(R.layout.fragment_search, container, false);

        subjectContainer = myView.findViewById(R.id.subjectContainer);
        searchText = (EditText) myView.findViewById(R.id.searchBar);
        searchButton = (Button) myView.findViewById(R.id.searchButton);

        //Bundle bundle = getArguments();
        //this.student_id = bundle.getInt("STUDENT_ID", 0);

        init = new MemoryInitializer();

        presenter = new SearchPresenter(init.getOfferedSubjectDAO());
        presenter.setView(this);
        presenter.initSubView();

        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String title = presenter.getTitle();
                presenter.decide(title);

            }
        });
        return myView;
    }

    public void viewSub(List<OfferedSubject> sub){
        // TODO : Not with offered subjects Lydia
        for( OfferedSubject k : sub){
            String title = k.getTitle();
            TextView subjectTextView = createSubjectTextView(title); // we make a new TextView that has the subject title
            subjectTextView.setTextSize(20);
            subjectContainer.addView(subjectTextView);

        }
    }

    public TextView createSubjectTextView(String title){

        TextView textView = new TextView(requireContext());
        textView.setText(title);
        textView.setTextSize(30);
        textView.setPadding(16, 16, 16, 16);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override

            //TODO the presenter does that;
            public void onClick(View v) {
                // Redirect to another activity based on the selected subject
                Intent intent = new Intent(requireContext(), InformationSubject.class);
                intent.putExtra("subject", title);
                startActivity(intent);
            }
        });

        View lineView = new View(requireContext());
        LinearLayout.LayoutParams lineLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);
        lineLayoutParams.setMargins(16, 0, 16, 0);
        lineView.setLayoutParams(lineLayoutParams);
        lineView.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.black));


        subjectContainer.addView(lineView);


        return textView;
    }

    public String getSubTitle(){

        return searchText.getText().toString().trim();
    }

    @Override
    public void showInfo(String title) {
        Intent intent = new Intent(requireContext(), InformationSubject.class);
        intent.putExtra("subject", title);
        startActivity(intent);
    }

    public void errorTitle(){
        searchText.setText(" ");
        Toast.makeText(getActivity(), " Subject not found! ", Toast.LENGTH_SHORT).show();



    }
}