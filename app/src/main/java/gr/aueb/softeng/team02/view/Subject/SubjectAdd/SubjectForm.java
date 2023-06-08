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

public class SubjectForm extends Activity implements SubjectFormView {

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_form);

        title = (EditText) findViewById(R.id.subjectTitle);
        ects = (EditText) findViewById(R.id.subjectEcts);
        prof = (EditText) findViewById(R.id.subjectpProfessor);
        desc = (EditText) findViewById(R.id.subjectDesc);
        send = (Button) findViewById(R.id.saveSubjectBut);
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
                Log.e("DEBUGGER", ects.getText().toString().trim());
                presenter.valid();

            }
        });

    }

    /**
     * Gets from the user the title he/she has written and
     *
     * @return it
     **/
    @Override
    public String getSubTitle() {
        return title.getText().toString().trim();
    }

    /**
     * Gets from the user the professors name he/she has written and
     *
     * @return it
     **/
    @Override
    public String getProf() {
        return prof.getText().toString().trim();
    }

    /**
     * Gets from the user the ects he/she has written and
     *
     * @return it
     **/
    @Override
    public String getEcts() {
        return ects.getText().toString().trim();
    }

    /**
     * Gets from the user the description he/she has written and
     *
     * @return it
     **/
    @Override
    public String getDesc() {
        return desc.getText().toString().trim();
    }

    /**
     * Sets the X image for the Title  visible
     **/
    @Override
    public void setexTitle() {
        xTitle.setVisibility(View.VISIBLE);
    }

    /**
     * Sets the X image for the Professor visible
     **/
    @Override
    public void setexProf() {
        xProf.setVisibility(View.VISIBLE);
    }

    /**
     * Sets the X image for Ects visible
     **/
    @Override
    public void setexEcts() {
        xEcts.setVisibility(View.VISIBLE);
    }

    /**
     * Sets the X image for Description visible
     **/
    @Override
    public void setexDesc() {
        xDesc.setVisibility(View.VISIBLE);
    }

    /**
     * Sets the X image for Title invisible
     **/
    @Override
    public void invTitle() {
        xTitle.setVisibility(View.GONE);
    }

    /**
     * Sets the X image for description invisible
     **/
    @Override
    public void invDesc() {
        xDesc.setVisibility(View.GONE);
    }

    /**
     * Sets the X image for professor invisible
     **/
    @Override
    public void invProf() {
        xProf.setVisibility(View.GONE);
    }

    /**
     * Sets the X image for ects invisible
     **/
    @Override
    public void invEcts() {
        xEcts.setVisibility(View.GONE);
    }

    /**
     * Prints an error message when not all the attributes are written by the user
     **/
    @Override
    public void printEr1() {
        Toast.makeText(getApplicationContext(), "Please write all the subject's attributes ", Toast.LENGTH_SHORT).show();
    }

    /**
     * Shows a pop-up window when there is already is a subject with the same name , and asks the user which version he would like to keep.
     **/
    @Override
    public void sameSubject() {
        builder.setTitle("Conflict").setMessage("The Subject you want to create already exists. " +
                        "You want to keep the previous version? ")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "The previous version was saved ", Toast.LENGTH_SHORT).show();
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

    /**
     * Show a message that the subject was saved successfully
     **/
    @Override
    public void messageSave() {
        Toast.makeText(getApplicationContext(), "The subject was saved successfully", Toast.LENGTH_SHORT).show();
    }

    /**
     * Navigates to the home screen
     **/
    @Override
    public void getBack() {
        Intent intent = new Intent(SubjectForm.this, HomeSecretaryActivity.class);
        startActivity(intent);
    }

    /**
     * Show a message that the the user wrote at least one letter in the ects attribute
     **/
    @Override
    public void invalidInput() {
        Toast.makeText(getApplicationContext(), "Inavlid input in the ects box .Please write only numbers", Toast.LENGTH_SHORT).show();
    }


}