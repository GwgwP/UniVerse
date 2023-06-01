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
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYear;

public class SubmissionFragment extends Fragment implements SubmissionFragmentView {
    private ArrayList<String> yearList;
    SubmissionFragmentPresenter presenter;
    private Spinner spinner;
    private Initializer init;
    private boolean isUserInteracted = false;
    private int student_id;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View myView = inflater.inflate(R.layout.fragment_submission, container, false);
        spinner = (Spinner) myView.findViewById(R.id.spinner);

        Bundle bundle = getArguments();
        this.student_id = bundle.getInt("STUDENT_ID", 0);

        // Log.e("DEBUGGER", String.valueOf(student_id));
        init = new MemoryInitializer();

        presenter = new SubmissionFragmentPresenter(this, init.getAcademicYearDAO());

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
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String year = yearList.get(position);
//                TableLayout tableLayout = view.findViewById(R.id.tableLayout);
//
//                // Create the header row
//                TableRow headerRow = new TableRow(requireContext());
//                TableRow.LayoutParams headerLayoutParams = new TableRow.LayoutParams(
//                        TableRow.LayoutParams.MATCH_PARENT,
//                        TableRow.LayoutParams.WRAP_CONTENT
//                );
//                headerRow.setLayoutParams(headerLayoutParams);
//
//                // Create the "Select" header
//                TextView selectHeaderTextView = new TextView(requireContext());
//                selectHeaderTextView.setText("Select");
//                headerRow.addView(selectHeaderTextView);
//
//                // Create the "Semester" header
//                TextView semesterHeaderTextView = new TextView(requireContext());
//                semesterHeaderTextView.setText("Semester");
//                headerRow.addView(semesterHeaderTextView);
//
//                // Create the "Subject" header
//                TextView subjectHeaderTextView = new TextView(requireContext());
//                subjectHeaderTextView.setText("Subject");
//                headerRow.addView(subjectHeaderTextView);
//
//                // Add the header row to the table
//                tableLayout.addView(headerRow);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinner.setPrompt("Select Academic Year");
            }
        });


    }

    @Override
    public void getYear() {

    }
}