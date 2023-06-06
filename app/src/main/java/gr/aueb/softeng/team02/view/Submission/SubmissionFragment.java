package gr.aueb.softeng.team02.view.Submission;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

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

public class SubmissionFragment extends Fragment implements SubmissionFragmentView {
    private ArrayList<String> yearList;
    private SubmissionFragmentViewModel model;
    private Spinner spinner;
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
        int student_id = bundle.getInt("STUDENT_ID", 0);

        submitButton = myView.findViewById(R.id.submitBtn);

        model = new SubmissionFragmentViewModel();
        model.getPresenter().setView(this);
        model.getPresenter().setStudentId(student_id);
        model.getPresenter().setYears();
        return myView;
    }

    @Override
    public void onStart() {
        super.onStart();
        model.getPresenter().startProcess();
    }

    @Override
    public void startSubmission() {
        tableLayout = myView.findViewById(R.id.tableLayout);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                model.getPresenter().makeForm(); // creation of table
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Set a click listener for the submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.getPresenter().submitClicked();
            }
        });
    }

    public void createYearList(ArrayList<String> years) {
        // Create an ArrayAdapter using the choices ArrayList
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, years);

        // Specify the layout for the dropdown items
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the ArrayAdapter on the Spinner
        spinner.setAdapter(adapter);
    }

    public ArrayList<String> submit() {
        ArrayList<String> subjects = new ArrayList<>();
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
                    subjects.add(selectedString);
                }
            }
        }
        return subjects;
    }

    @Override
    public void setForm(HashMap<String, Integer> subjects) {
        tableLayout.setVisibility(View.VISIBLE); // shows the table

        tableLayout.removeAllViews(); // removes the old rows

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
    public void showPassedMsg(String txt) {
        Toast.makeText(requireContext(), txt, Toast.LENGTH_LONG).show();
    }

    @Override
    public String getSelectedYear() {
        return spinner.getSelectedItem().toString();
    }

    public void showErrorMessage(String title, String message) {
        new AlertDialog.Builder(requireContext())
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null).create().show();
    }

}
