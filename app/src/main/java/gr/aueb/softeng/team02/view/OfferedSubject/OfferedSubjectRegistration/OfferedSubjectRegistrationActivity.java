package gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectRegistration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.view.Secretary.HomeSecretaryActivity;
import gr.aueb.softeng.team02.view.Student.HomeStudentActivity;

public class OfferedSubjectRegistrationActivity extends AppCompatActivity implements OfferedSubjectRegistrationView {
    String semester;
    AlertDialog.Builder builder;
    Button submit;
    String year;
    TableLayout table;
    CheckBox checker;
    OfferedSubjectRegistrationPresenter presenter;
    Initializer init;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offered_subject_registration);
        table = findViewById(R.id.subjectsTable);
        builder = new AlertDialog.Builder(this);
        submit = (Button) findViewById(R.id.submitButton);
        // Retrieve the extras from the Intent
        Bundle extras = getIntent().getExtras();
        semester = extras.getString("semester");
        year = extras.getString("year");
        init = new MemoryInitializer();
        presenter = new OfferedSubjectRegistrationPresenter(this, init.getOfferedSubjectDAO(), init.getSubjectDAO(), init.getAcademicYearDAO());
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.init(year, semester);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.register();
            }
        });
    }

    @Override
    public void createTable(ArrayList<String> subjects) {
        for (String title : subjects) {
            // Creating a new row
            TableRow newRow = new TableRow(this);

            // Creating a CheckBox for the first column
            CheckBox check = new CheckBox(this);

            check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    // Handle the checkbox state change here
                    if (isChecked) {
                        // Checkbox is checked
                        presenter.checkSubject(title);
                        checker = check;

                    } else {
                        // Checkbox is unchecked
                        // Perform actions when the checkbox is unchecked
                        check.setChecked(false);
                    }
                }
            });
            // Set any desired properties for the CheckBox
            newRow.addView(check); // Add the CheckBox to the row

            // Creating a TextView for the second column
            TextView subjectTextView = new TextView(this);
            subjectTextView.setTextSize(20);
            subjectTextView.setText(title);
            newRow.addView(subjectTextView); // Add the TextView to the row

            // Add the row to the TableLayout
            table.addView(newRow);
        }
    }

    @Override
    public void setCheckBox(boolean flag) {
        if (flag) {
            this.checker.setChecked(true);
        } else {
            this.checker.setChecked(false);
        }
    }

    @Override
    public void alertBox(String title, String msg) {
        builder.setTitle(title).setMessage(msg)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.moveSubject();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.remainSubject();
                    }
                })
                .show();
    }

    @Override
    public void errorBox(String title, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton(R.string.ok, null).create().show();
    }

    public void moveReminder(String txt) {
        Toast.makeText(this, txt, Toast.LENGTH_LONG).show();
    }

    @Override
    public ArrayList<String> submitClicked() {
        ArrayList<String> titles = new ArrayList<>();

        int rowCount = table.getChildCount();

        for (int i = 1; i < rowCount; i++) {
            View rowView = table.getChildAt(i);

            if (rowView instanceof TableRow) {
                TableRow row = (TableRow) rowView;

                // Get the checkbox and string from the row
                CheckBox checkBox = (CheckBox) row.getChildAt(0);
                TextView textView = (TextView) row.getChildAt(1);

                if (checkBox.isChecked()) {
                    String selectedString = textView.getText().toString();
                    titles.add(selectedString);
                }
            }
        }
        return titles;
    }

    @Override
    public void changeToHomeScreen() {
        Intent intent = new Intent(this, HomeSecretaryActivity.class);
        startActivity(intent);
    }
}