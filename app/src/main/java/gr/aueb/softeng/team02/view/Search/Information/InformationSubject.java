package gr.aueb.softeng.team02.view.Search.Information;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.memorydao.OfferedSubjectDAOMemory;
import gr.aueb.softeng.team02.model.OfferedSubject;

public class InformationSubject extends AppCompatActivity implements InformationView {

    private InformationPresenter presenter;

    TextView titleT;
    TextView id;
    TextView ects;
    TextView desc;
    TextView prof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_subject);

        // Retrieve the selected subject from the intent
        String title = getIntent().getStringExtra("subject");
        Log.e("DEBUG", title );


        presenter = new InformationPresenter(new OfferedSubjectDAOMemory());
        presenter.setView(this);

// TODO : different ids
        titleT = (TextView) findViewById(R.id.subjectTitleTextView);
        id = (TextView) findViewById(R.id.idTxt);
        ects = (TextView) findViewById(R.id.ectsTxt);
        desc = (TextView) findViewById(R.id.descTxt);
        prof = (TextView) findViewById(R.id.profNameTxt);


        presenter.setInfo(title);

    }


public void showInfo(OfferedSubject sub){
        //TODO : separate methods
    titleT.setText(sub.getTitle());
   id.setText(String.valueOf(sub.getSubject().getId()));
   ects.setText(String.valueOf(sub.getEcts()));
   desc.setText(sub.getDesc());
   prof.setText(sub.getProf());


}

}