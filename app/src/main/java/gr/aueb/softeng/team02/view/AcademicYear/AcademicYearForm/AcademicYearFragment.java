package gr.aueb.softeng.team02.view.AcademicYear.AcademicYearForm;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import gr.aueb.softeng.team02.view.AcademicYear.Registration.AcademicYearRegistration;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class AcademicYearFragment extends Fragment implements AcademicYearFragmentView {

    private ArrayList<String> yearList;
    private ArrayAdapter<String> adapter;
    Initializer init;
    private AcademicYearFragmentViewModel model;

    private ImageView firstX;
    private ImageView secondX;
    private ImageView thridX;
    private Spinner year_spinner;
    private Spinner semester_spinner;
    private Button submitButton;
    private Button checkButton;
    private View myView;
    private EditText start_date;
    private EditText end_date;
    Button addYearButton;

    EditText ects;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_academic_year, container, false);
        year_spinner = (Spinner) myView.findViewById(R.id.spinner2);
        semester_spinner = (Spinner) myView.findViewById(R.id.spinnerSemester);
        Bundle bundle = getArguments();
        // int student_id = bundle.getInt("STUDENT_ID", 0);
        init = new MemoryInitializer();
        ects = (EditText) myView.findViewById(R.id.editTextText);
        model = new AcademicYearFragmentViewModel();
        model.getPresenter().setView(this);
        model.getPresenter().initLists();

        addYearButton = (Button) myView.findViewById(R.id.add_year_button);
        start_date = (EditText) myView.findViewById(R.id.date_txt_start);
        end_date = (EditText) myView.findViewById(R.id.date_txt_end);
        firstX = (ImageView) myView.findViewById(R.id.ectsx_ac_year);
        secondX =(ImageView) myView.findViewById(R.id.ac_year_date1X);
        thridX = (ImageView) myView.findViewById(R.id.ac_year_date2X);


        checkButton = (Button) myView.findViewById(R.id.checkBtnSecretary);

        submitButton = myView.findViewById(R.id.submitBtnSecretary);

        return myView;
    }

    @Override
    public void onStart() {
        super.onStart();
        submitButton.setVisibility(View.GONE);
        firstX.setVisibility(View.GONE);
        secondX.setVisibility(View.GONE);
        thridX.setVisibility(View.GONE);
        addYearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.getPresenter().onSeeAcademicYear();
            }
        });


        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.getPresenter().checkValidity();
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.getPresenter().createAcademicYearCircumscription();
            }
        });
    }


    public void setVisibleSubmit() {
        submitButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void alertMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        model.getPresenter().overrideCirc();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

    public void showAcYearsRegistration() {
        Intent intent = new Intent(requireContext(), AcademicYearRegistration.class);
        startActivity(intent);

        //after possible adding of new year, must init the lists again
        model.getPresenter().initLists();
    }


    public void createYearList(ArrayList<String> years) {
        // Create an ArrayAdapter using the choices ArrayList
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, years);

        // Specify the layout for the dropdown items
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the ArrayAdapter on the Spinner
        year_spinner.setAdapter(adapter);

    }

    public void createSemesterList(ArrayList<String> semesters) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, semesters);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semester_spinner.setAdapter(adapter);
    }

    @Override
    public String getSelectedSemester() {
        return semester_spinner.getSelectedItem().toString();
    }

    @Override
    public String getSelectedYear() { //ArrayList<String> years) {
        return year_spinner.getSelectedItem().toString();
    }

    public String getECTS() {
        return ects.getText().toString().trim();
    }

    @Override
    public String getDateStart() {
        return start_date.getText().toString().trim();
    }

    @Override
    public String getDateEnd() {
        return end_date.getText().toString().trim();
    }


    public void messageSave() {
        Toast.makeText(requireContext(), "The circumscription in the academic year was saved successfully", Toast.LENGTH_SHORT).show();
    }

    public void messageOverride() {
        Toast.makeText(requireContext(), "The override in the academic year was saved successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setVisibleFirstX() {
        firstX.setVisibility(View.VISIBLE);
    }

    @Override
    public void setVisibleSecondX() {
        secondX.setVisibility(View.VISIBLE);
    }

    @Override
    public void setVisibleThirdX() {
        thridX.setVisibility(View.VISIBLE);
    }

}
