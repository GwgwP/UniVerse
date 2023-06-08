package gr.aueb.softeng.team02.view.Submission;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.view.Student.HomeStudentActivity;

public class SubmissionFragment extends Fragment implements SubmissionFragmentView {
    private SubmissionFragmentViewModel model;
    private Button submitButton;
    private View myView;
    private TableLayout tableLayout;
    private CheckBox checker;

    /**
     *
     * @param inflater The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     *
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        myView = inflater.inflate(R.layout.fragment_submission, container, false);

        Bundle bundle = getArguments();
        int student_id = bundle.getInt("STUDENT_ID", 0);

        submitButton = myView.findViewById(R.id.submitBtn);

        model = new SubmissionFragmentViewModel();
        model.getPresenter().setView(this);
        model.getPresenter().setStudentId(student_id);
        return myView;
    }

    /**
     * Call presenter to make the form.
     * In case of submit button clicked, call presenter to check the submission
     */
    @Override
    public void onStart() {
        super.onStart();
        tableLayout = myView.findViewById(R.id.tableLayout);

        model.getPresenter().makeForm();

        // Set a click listener for the submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.getPresenter().submitClicked();
            }
        });
    }

    /**
     * Call presenter on submit button clicked
     * @return a array list of string objects with the selected titles
     */
    @Override
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
    /**
     * Create the list of subjects
     * @param subjects
     */
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
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        model.getPresenter().checkPrerequisities(sub.getKey());
                        checker = checkBox;
                    }
                }
            });
            tableRow.addView(checkBox);

            // Create the TextView for the second column
            TextView messageTextView = new TextView(requireContext());
            messageTextView.setText(String.valueOf(sub.getValue()));
            messageTextView.setTextSize(15);
            tableRow.addView(messageTextView);

            // Create the TextView for the third column
            TextView thirdColumnTextView = new TextView(requireContext());
            thirdColumnTextView.setText(sub.getKey());
            thirdColumnTextView.setTextSize(20);
            tableRow.addView(thirdColumnTextView);

            // Add the row to the table
            tableLayout.addView(tableRow);
        }
    }
    /**
     * Show message in case of successful store
     * @param txt
     */
    @Override
    public void showPassedMsg(String txt) {
        Toast.makeText(requireContext(), txt, Toast.LENGTH_LONG).show();
    }
    /**
     * Το μήνυμα που εμφανίζεται σε
     * περίπτωση error.
     *
     * @param title   O τίτλος του μηνύματος
     * @param message Το περιεχόμενο του μηνύματος
     */
    public void showErrorMessage(String title, String message) {
        new AlertDialog.Builder(requireContext())
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null).create().show();
    }
    /**
     * Changes the layout from the Submission Fragment -> HomeStudentActivity
     */
    @Override
    public void changeToHomeScreen() {
        Intent intent = new Intent(getActivity(), HomeStudentActivity.class);
        startActivity(intent);
    }
    /**
     * Set the check box 'Checked' or 'Unchecked'
     * @param flag true or false depending if the subject can be selected from the user
     */
    @Override
    public void setCheckBox(boolean flag) {
        this.checker.setChecked(flag);
    }
}
