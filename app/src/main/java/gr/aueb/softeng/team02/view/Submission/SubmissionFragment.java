package gr.aueb.softeng.team02.view.Submission;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYear;

public class SubmissionFragment extends Fragment implements SubmissionFragmentView {
    private ArrayList<String> yearList;
    private SubmissionFragmentPresenter presenter;
    private Spinner spinner;
    private Initializer init;
    private int student_id;
    private Button submitButton;
    private View myView;
    private TableLayout tableLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        myView = inflater.inflate(R.layout.fragment_submission, container, false);
        spinner = (Spinner) myView.findViewById(R.id.spinner);

        Bundle bundle = getArguments();
        this.student_id = bundle.getInt("STUDENT_ID", 0);

        // Log.e("DEBUGGER", String.valueOf(student_id));
        init = new MemoryInitializer();

        submitButton = myView.findViewById(R.id.submitBtn);

        presenter = new SubmissionFragmentPresenter(this, init.getAcademicYearDAO(), init.getOfferedSubjectDAO());

        // Create an ArrayList with the choices
        this.yearList = presenter.getAcademicYears();

        // Create an ArrayAdapter using the choices ArrayList
        ArrayAdapter adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, this.yearList);

        // Specify the layout for the dropdown items
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the ArrayAdapter on the Spinner
        spinner.setAdapter(adapter);

        getYear();

        return myView;
    }

    @Override
    public void onStart() {
        super.onStart();
        tableLayout = myView.findViewById(R.id.tableLayout);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String year = yearList.get(position);
                presenter.setYear(year);
                tableLayout.setVisibility(View.VISIBLE);

                tableLayout.removeAllViews();

                // Create the header row
                TableRow headerRow = new TableRow(requireContext());
                TableRow.LayoutParams headerLayoutParams = new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT
                );
                headerRow.setLayoutParams(headerLayoutParams);

                // Create the "Select" header
                TextView selectHeaderTextView = new TextView(requireContext());
                selectHeaderTextView.setText("Select");
                headerRow.addView(selectHeaderTextView);

                // Create the "Semester" header
                TextView semesterHeaderTextView = new TextView(requireContext());
                semesterHeaderTextView.setText("Semester");
                headerRow.addView(semesterHeaderTextView);

                // Create the "Subject" header
                TextView subjectHeaderTextView = new TextView(requireContext());
                subjectHeaderTextView.setText("Subject");
                headerRow.addView(subjectHeaderTextView);

                // Add the header row to the table
                tableLayout.addView(headerRow);

                // Create an array of messages for the second column
                HashMap<String, Integer> subjects = presenter.getOfferedSubjects();
                // Log.e("DEBUGGER", String.valueOf(subjects.size()));

                for (Map.Entry<String, Integer> sub : subjects.entrySet()) {
                    TableRow tableRow = new TableRow(requireContext());
                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(
                            TableRow.LayoutParams.MATCH_PARENT,
                            TableRow.LayoutParams.WRAP_CONTENT
                    );
                    tableRow.setLayoutParams(layoutParams);

                    // Create the checkbox for the first column
                    CheckBox checkBox = new CheckBox(requireContext());
                    tableRow.addView(checkBox);

//                    // Create the button with search icon for the second column
//                    Button searchButton = new Button(requireContext());
//                    //searchButton.setBackgroundResource(R.drawable.search_logo);
//                    searchButton.setBackgroundColor();
//                    tableRow.addView(searchButton);

                    // Create the TextView for the second column
                    TextView messageTextView = new TextView(requireContext());
                    messageTextView.setText(String.valueOf(sub.getValue()));
                    tableRow.addView(messageTextView);

                    // Create the TextView for the third column
                    TextView thirdColumnTextView = new TextView(requireContext());
                    thirdColumnTextView.setText(sub.getKey());
                    tableRow.addView(thirdColumnTextView);

                    // Add the row to the table
                    tableLayout.addView(tableRow);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinner.setPrompt("Select Academic Year");
            }
        });

        // Set a click listener for the submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitClicked();
            }
        });

    }

    public void submitClicked() {
        int rowCount = tableLayout.getChildCount();
        for (int i = 1; i < rowCount; i++) {
            View rowView = tableLayout.getChildAt(i);
            if (rowView instanceof TableRow) {
                TableRow row = (TableRow) rowView;
                int columnCount = row.getChildCount();

                // Get the checkbox and string from the row
                CheckBox checkBox = (CheckBox) row.getChildAt(0);
                TextView textView = (TextView) row.getChildAt(2);

                if (checkBox.isChecked()) {
                    String selectedString = textView.getText().toString();
                }
            }
        }
    }


    @Override
    public void getYear() {

    }
}