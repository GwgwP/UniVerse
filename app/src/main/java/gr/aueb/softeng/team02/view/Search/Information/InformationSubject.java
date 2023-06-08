package gr.aueb.softeng.team02.view.Search.Information;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.memorydao.OfferedSubjectDAOMemory;
import gr.aueb.softeng.team02.model.OfferedSubject;

public class InformationSubject extends AppCompatActivity implements InformationView {

    private InformationPresenter presenter;

    TextView titleT;
    TextView id;
    TextView ects;
    private LinearLayout desc;
    TextView prof;

    TextView prep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_subject);

        // Retrieve the selected subject from the intent
        String title = getIntent().getStringExtra("subject");
        Log.e("DEBUG", title);


        presenter = new InformationPresenter(new OfferedSubjectDAOMemory());
        presenter.setView(this);


        titleT = (TextView) findViewById(R.id.subjectTitleTextView);
        id = (TextView) findViewById(R.id.idTxt);
        ects = (TextView) findViewById(R.id.ectsTxt);
        desc = (LinearLayout) findViewById(R.id.descCon);
        prof = (TextView) findViewById(R.id.profNameTxt);
        prep =(TextView) findViewById(R.id.prereTxt);

        presenter.setInfo(title);

    }


    /**
     * Shows the information of a offered subject
     *
     * @param descrip   : the description of the offered subject
     * @param ects      : the ects of the offered subject
     * @param id        : the id of the offered subject
     * @param professor : the professor of the offered subject
     * @param title     : the title of the offered subject
     **/
    @Override
    public void showInfo(String title, String professor, int ects, int id, String descrip,ArrayList<String> prerequisites) {
        titleT.setText(title);
        this.id.setText(String.valueOf(id));
        this.ects.setText(String.valueOf(ects));
        TextView d = new TextView(this);
        d.setText(descrip);
        d.setTextSize(20);
        desc.addView(d);
        prof.setText(professor);

        String show="" ;
        for(String name : prerequisites){
            show+= name + " ,";

        }
        prep.setText(show);


    }


}