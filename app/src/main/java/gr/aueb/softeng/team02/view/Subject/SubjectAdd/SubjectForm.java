package gr.aueb.softeng.team02.view.Subject.SubjectAdd;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.memorydao.SubjectDAOMemory;
import gr.aueb.softeng.team02.view.Secretary.HomeSecretaryActivity;

public class SubjectForm extends Activity implements SubjectFormView{

    private EditText title;
    private EditText ects;
    private EditText prof;

    private EditText desc;
    private Button send;

    private ImageView xTitle;
    private ImageView xProf;

    private ImageView xEcts;
    private ImageView xDesc;

    AlertDialog.Builder builder;

    Initializer init;


    private SubjectFormPresenter presenter;
    private SubjectFormView myView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_form);

        title=(EditText) findViewById(R.id.subjectTitle);
        ects=(EditText) findViewById(R.id.subjectEcts);
        prof=(EditText) findViewById(R.id.subjectpProfessor);
        desc= (EditText) findViewById(R.id.subjectDesc);
        send= (Button) findViewById(R.id.saveSubjectBut);
        init = new MemoryInitializer();

        xTitle = (ImageView) findViewById(R.id.exTitle);
        xProf = (ImageView) findViewById(R.id.exProf);

        xEcts = (ImageView) findViewById(R.id.exEcts);
        xDesc = (ImageView) findViewById(R.id.exDesc);

        builder = new AlertDialog.Builder(this);
        presenter = new SubjectFormPresenter(init.getSubjectDAO());

        presenter.setView(this);



    }
    @Override
    public void onStart() {

        super.onStart();
        xTitle.setVisibility(View.GONE);
        xProf.setVisibility(View.GONE);
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

    public String getDesc(){
        return desc.getText().toString().trim();
    }

    public void setexTitle(){ xTitle.setVisibility(View.VISIBLE);}
    public void setexProf(){ xProf.setVisibility(View.VISIBLE);}

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


    public void printEr1(){
        Toast.makeText(getApplicationContext(),"Please write all the subject's attributes ",Toast.LENGTH_SHORT).show();
    }

    public void sameSubject(){
        builder.setTitle("Conflict").setMessage("The Subject you want to create already exists. " +
                "You want to keep the previous version? ")
                 .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                 public void onClick(DialogInterface dialog, int which) {
                     Toast.makeText(getApplicationContext(),"The previous version was saved ",Toast.LENGTH_SHORT).show();
                     presenter.goBack();

                }
        })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                      presenter.createSubject();
                        presenter.goBack();
                    }
                })
                .show();


    }

    public void messageSave(){
        Toast.makeText(getApplicationContext(),"The subject was saved successfully",Toast.LENGTH_SHORT).show();
    }

    public void getBack(){
        Intent intent = new Intent(SubjectForm.this , HomeSecretaryActivity.class);
        startActivity(intent);
    }

    public void invalidInput(){
        Toast.makeText(getApplicationContext(),"Inavlid input in the ects box .Please write only numbers",Toast.LENGTH_SHORT).show();
    }




}