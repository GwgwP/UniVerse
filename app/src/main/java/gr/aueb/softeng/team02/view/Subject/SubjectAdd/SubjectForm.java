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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

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
    private TableLayout prereq;
    Initializer init;


    private SubjectFormPresenter presenter;

    /**
     * Initializer
     **/
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

    /**
     * What changes if the bottom is pressed
     **/
    @Override
    public void onStart() {

        super.onStart();
        xTitle.setVisibility(View.GONE);
        xProf.setVisibility(View.GONE);
        xEcts.setVisibility(View.GONE);
        xDesc.setVisibility(View.GONE);
        prereq = (TableLayout) findViewById(R.id.SubjectTable);

        presenter.makeForm();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        Toast.makeText(getApplicationContext(), "Invalid input in the ects box .Please write only numbers", Toast.LENGTH_SHORT).show();
    }

    /**
     * Gets from the table the selected Subjects
     *
     * @return the list of the checked Subjects
     **/
    @Override
    public ArrayList<String> getPrereq() {
        ArrayList<String> subjects = new ArrayList<>();
        int rowCount = prereq.getChildCount();
        for (int i = 1; i < rowCount; i++) {
            View rowView = prereq.getChildAt(i);

            if (rowView instanceof TableRow) {
                TableRow row = (TableRow) rowView;

                // Get the checkbox and string from the row
                CheckBox checkBox = (CheckBox) row.getChildAt(0);
                TextView textView = (TextView) row.getChildAt(1);

                if (checkBox.isChecked()) {
                    String selectedString = textView.getText().toString();
                    subjects.add(selectedString);
                }
            }
        }
        return subjects;
    }

    /**
     * Creates the table that shows the available Subjects
     *
     * @param titles : the list that has the names of the subjects
     **/
    @Override
    public void setForm(ArrayList<String> titles) {
        prereq.setVisibility(View.VISIBLE);
        prereq.removeAllViews();

        TableRow headerRow = new TableRow(this);
        TableRow.LayoutParams headerLayoutParams = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT
        );
        headerRow.setLayoutParams(headerLayoutParams);

        // Create the "Select" header
        TextView selectHeaderTextView = new TextView(this);
        selectHeaderTextView.setText("Select");
        headerRow.addView(selectHeaderTextView);

        // Create the "Subject" header
        TextView subjectHeaderTextView = new TextView(this);
        subjectHeaderTextView.setText("Subject");
        headerRow.addView(subjectHeaderTextView);

        // Add the header row to the table
        prereq.addView(headerRow);

        for (String tit : titles) {
            TableRow tableRow = new TableRow(this);
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT
            );
            tableRow.setLayoutParams(layoutParams);

            // Create the checkbox for the first column
            CheckBox checkBox = new CheckBox(this);
            tableRow.addView(checkBox);

            // Create the TextView for the second column
            TextView thirdColumnTextView = new TextView(this);
            thirdColumnTextView.setText(tit);
            thirdColumnTextView.setTextSize(20);
            tableRow.addView(thirdColumnTextView);
            // Add the row to the table
            prereq.addView(tableRow);

        }


    }

}