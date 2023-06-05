package gr.aueb.softeng.team02.view.OfferedSubject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;

public class OfferedSubjectFragment extends Fragment implements OfferedSubjectView {
    Spinner spinnerYear;
    Spinner spinnerSemester;
    Button check;
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
        check = view.findViewById(R.id.button_check);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        check.setOnClickListener(v-> presenter.checkSelected());
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

    public void createSemesterList(ArrayList<String> semesters) {
        // Create an ArrayAdapter using the choices ArrayList
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, semesters);

        // Specify the layout for the dropdown items
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the ArrayAdapter on the Spinner
        spinnerSemester.setAdapter(adapter);
    }

    @Override
    public boolean[] confirmBox(String title, String txt) {
        final boolean[] answer = new boolean[1];
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle(title).setMessage(txt)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        answer[0] = true;
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        answer[0] = false;
                    }
                })
                .show();
        return answer;
    }

    @Override
    public void popNotification(String msg) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public String getYear() {
        return spinnerYear.getSelectedItem().toString();
    }

    @Override
    public String getSemester() {
        return spinnerSemester.getSelectedItem().toString();
    }
}