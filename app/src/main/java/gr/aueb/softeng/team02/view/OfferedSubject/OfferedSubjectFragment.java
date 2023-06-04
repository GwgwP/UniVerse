package gr.aueb.softeng.team02.view.OfferedSubject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;

public class OfferedSubjectFragment extends Fragment implements OfferedSubjectView {
    Spinner spinnerYear;
    Spinner spinnerSemester;
    View view;
    OfferedSubjectPresenter presenter;
    Initializer init;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_offered_subject, container, false);
        spinnerYear = (Spinner) view.findViewById(R.id.spinner_year);
        spinnerSemester = (Spinner) view.findViewById(R.id.spinner_semester);
        init = new MemoryInitializer();
        presenter = new OfferedSubjectPresenter(this, init.getSubjectDAO(), init.getOfferedSubjectDAO(), init.getAcademicYearDAO());
        presenter.initLists();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        getYear();
    }
    @Override
    public void createYearList(ArrayList<String> years) {
        // Create an ArrayAdapter using the choices ArrayList
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, years);

        // Specify the layout for the dropdown items
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the ArrayAdapter on the Spinner
        spinnerYear.setAdapter(adapter);
    }

    public void createSemesterList(ArrayList<String> years) {
        // Create an ArrayAdapter using the choices ArrayList
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, years);

        // Specify the layout for the dropdown items
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the ArrayAdapter on the Spinner
        spinnerSemester.setAdapter(adapter);
    }

    @Override
    public String getYear() {
        spinnerYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("DEBUGGER", "hello");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return "";
    }

    @Override
    public int getSemester() {
        return 0;
    }
}