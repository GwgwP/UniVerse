package gr.aueb.softeng.team02.view.AcademicYear;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.view.Authentication.UserLoginActivity;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.HashMap;

public class AcademicYearFragment extends Fragment implements AcademicYearFragmentView{

    private ArrayList<String> yearList;
    private AcademicYearFragmentViewModel model;
    private Spinner spinner;
    private Spinner semester_spinner;
    private Button submitButton;
    private View myView;

    ImageView ectsX;

    EditText ects;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_academic_year, container, false);
        spinner = (Spinner) myView.findViewById(R.id.spinner2);
        semester_spinner = (Spinner) myView.findViewById(R.id.spinnerSemester);
        ects = myView.findViewById(R.id.ectsTxt);
        ectsX = myView.findViewById(R.id.ectsx);

        Bundle bundle = getArguments();
        // int student_id = bundle.getInt("STUDENT_ID", 0);

        model = new AcademicYearFragmentViewModel();
        model.getPresenter().setView(this);
        model.getPresenter().initLists();

        submitButton = myView.findViewById(R.id.submitBtnSecretary);



        return myView;
    }

    @Override
    public void onStart() {
        super.onStart();
        model.getPresenter().startProcess();
    }



    public String getECTS(){return ects.getText().toString().trim();}

    @Override
    public void initECTSX(String txt) {
        ectsX.setVisibility(View.VISIBLE);
        Toast.makeText(getContext(), txt, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setForm(HashMap<String, Integer> subjects) {

    }

    @Override
    public void submit() {

    }

    @Override
    public void showPassedMsg(String txt) {

    }

    @Override
    public void startSubmission() {

    }

    public void createYearList(ArrayList<String> years) {
        // Create an ArrayAdapter using the choices ArrayList
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, years);

        // Specify the layout for the dropdown items
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the ArrayAdapter on the Spinner
        spinner.setAdapter(adapter);
    }

    public void createSemesterList(ArrayList<String> semesters)
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, semesters);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semester_spinner.setAdapter(adapter);
    }
    public String getSelectedSemester(ArrayList<String> semesters)
    {
        return semesters.get(((Spinner) myView.findViewById(R.id.spinnerSemester)).getSelectedItemPosition());
    }
    @Override
    public String getSelectedYear(ArrayList<String> years) {
        return years.get(((Spinner) myView.findViewById(R.id.spinner)).getSelectedItemPosition());
    }

    public void showAlertMessage(String title, String txt) {
        new AlertDialog.Builder(requireContext())
                .setCancelable(true)
                .setTitle(title)
                .setMessage(txt)
                .setPositiveButton(R.string.ok, null).create().show();
    }
}