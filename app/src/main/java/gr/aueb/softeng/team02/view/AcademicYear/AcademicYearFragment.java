package gr.aueb.softeng.team02.view.AcademicYear;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.HashMap;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.AcademicYearDAO;
import gr.aueb.softeng.team02.dao.GradeDAO;
import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.dao.StudentDAO;
import gr.aueb.softeng.team02.dao.SubmissionDAO;

public class AcademicYearFragment extends Fragment implements AcademicYearFragmentView{

    private ArrayList<String> yearList;
    private AcademicYearFragmentViewModel model;
    private Spinner spinner;
    private Button submitButton;
    private View myView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_academic_year, container, false);
        spinner = (Spinner) myView.findViewById(R.id.spinner);

        Bundle bundle = getArguments();
        // int student_id = bundle.getInt("STUDENT_ID", 0);

        model = new AcademicYearFragmentViewModel();
        model.getPresenter().setView(this);
        model.getPresenter().set_years();

        submitButton = myView.findViewById(R.id.submitBtnSecretary);



        return myView;
    }

    @Override
    public void onStart() {
        super.onStart();
        model.getPresenter().startProcess();
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
    @Override
    public String getSelectedYear(ArrayList<String> years) {
        return years.get(((Spinner) myView.findViewById(R.id.spinner)).getSelectedItemPosition());
    }
}