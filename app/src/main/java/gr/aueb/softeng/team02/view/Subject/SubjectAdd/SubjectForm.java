package gr.aueb.softeng.team02.view.Subject.SubjectAdd;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.memorydao.SubjectDAOMemory;

public class SubjectForm extends Activity implements SubjectFormView{

    private EditText title;
    private EditText ects;
    private EditText prof;
    private EditText id;
    private EditText desc;
    private Button send;

    private ImageView xTitle;
    private ImageView xProf;
    private ImageView xId;
    private ImageView xEcts;
    private ImageView xDesc;




    private SubjectFormPresenter presenter;
    private SubjectFormView myView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_form);

        title=(EditText) findViewById(R.id.subjectTitle);
        ects=(EditText) findViewById(R.id.subjectEcts);
        prof=(EditText) findViewById(R.id.subjectpProfessor);
        id=(EditText) findViewById(R.id.subjectId);
        desc= (EditText) findViewById(R.id.subjectDesc);
        send= (Button) findViewById(R.id.saveSubjectBut);

        xTitle = (ImageView) findViewById(R.id.exTitle);
        xProf = (ImageView) findViewById(R.id.exProf);
        xId = (ImageView) findViewById(R.id.exId);
        xEcts = (ImageView) findViewById(R.id.exEcts);
        xDesc = (ImageView) findViewById(R.id.exDesc);


        presenter = new SubjectFormPresenter(new SubjectDAOMemory());

        presenter.setView(this);



    }
    @Override
    public void onStart() {

        super.onStart();
        xTitle.setVisibility(View.GONE);
        xProf.setVisibility(View.GONE);
        xId.setVisibility(View.GONE);
        xEcts.setVisibility(View.GONE);
        xDesc.setVisibility(View.GONE);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("DEBUGGER",ects.getText().toString().trim());
                presenter.valid();

            }
        });

    }

    public String getSubTitle(){
        return title.getText().toString().trim();
    }

    public String getProf(){
        return prof.getText().toString().trim();
    }
    public String getEcts(){
        return ects.getText().toString().trim();
    }
    public String getId(){
        return id.getText().toString().trim();
    }
    public String getDesc(){
        return desc.getText().toString().trim();
    }

    public void setexTitle(){ xTitle.setVisibility(View.VISIBLE);}
    public void setexProf(){ xProf.setVisibility(View.VISIBLE);}
    public void setexId(){ xId.setVisibility(View.VISIBLE);}
    public void setexEcts(){ xEcts.setVisibility(View.VISIBLE);}
    public void setexDesc(){ xDesc.setVisibility(View.VISIBLE);}

    public void invTitle(){
        xTitle.setVisibility(View.GONE);
    }
    public void invDesc(){
        xDesc.setVisibility(View.GONE);
    }
    public void invProf(){
        xProf.setVisibility(View.GONE);
    }
    public void invEcts(){
        xEcts.setVisibility(View.GONE);
    }
    public void invId(){
        xId.setVisibility(View.GONE);
    }

    public void printEr1(){
        Toast.makeText(getApplicationContext(),"Please write all the subject's attributes ",Toast.LENGTH_SHORT).show();
    }


}