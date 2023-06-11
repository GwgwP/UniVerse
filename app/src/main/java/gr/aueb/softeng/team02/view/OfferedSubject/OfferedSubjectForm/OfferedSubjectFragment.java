package gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectForm;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectRegistration.OfferedSubjectRegistrationActivity;
import gr.aueb.softeng.team02.view.Secretary.HomeSecretaryActivity;

public class OfferedSubjectFragment extends Fragment implements OfferedSubjectView {
    Spinner spinnerYear;
    Spinner spinnerSemester;
    Button check;
    View view;
    AlertDialog.Builder builder;
    OfferedSubjectPresenter presenter;
    Initializer init;

    /**
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's
     *                           UI should be attached to.  The fragment should not add the view itself,
     *                           but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state as given here.
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_offered_subject, container, false);
        spinnerYear = (Spinner) view.findViewById(R.id.spinner_year);
        spinnerSemester = (Spinner) view.findViewById(R.id.spinner_semester);
        builder = new AlertDialog.Builder(requireContext());
        init = new MemoryInitializer();
        presenter = new OfferedSubjectPresenter(this, init.getOfferedSubjectDAO(), init.getAcademicYearDAO());
        presenter.initLists();
        check = (Button) view.findViewById(R.id.button_check);
        return view;
    }

    /**
     * When the check button is pressed, call the presenter
     */
    @Override
    public void onStart() {
        super.onStart();
        check.setOnClickListener(v -> presenter.checkSelected());
    }

    /**
     * Creates the form of the available subjects
     *
     * @param years an arraylist with titles of subjects
     */
    @Override
    public void createYearList(ArrayList<String> years) {
        // Create an ArrayAdapter using the choices ArrayList
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, years);

        // Specify the layout for the dropdown items
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the ArrayAdapter on the Spinner
        spinnerYear.setAdapter(adapter);
    }

    /**
     * Creates the form of all semesters
     *
     * @param semesters all the semester from 1 to 8
     */
    @Override
    public void createSemesterList(ArrayList<String> semesters) {
        // Create an ArrayAdapter using the choices ArrayList
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, semesters);

        // Specify the layout for the dropdown items
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the ArrayAdapter on the Spinner
        spinnerSemester.setAdapter(adapter);
    }

    /**
     * Shows the confirmation box in case the secretary wants
     * to keep the previous selected offered subjects for
     * the selected academic year and semester
     *
     * @param title a suitable title in the dialog message
     * @param txt   the content of the dialog message
     */
    @Override
    public void confirmBox(String title, String txt) {
        builder.setTitle(title).setMessage(txt)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.changeLayout();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.onRegistration();
                    }
                })
                .show();
    }

    /**
     * A floating mini message
     *
     * @param msg a mini message to the user as a small notification
     */
    @Override
    public void popNotification(String msg) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void goToRegistration(String year, String semester) {
        Intent intent = new Intent(getActivity(), OfferedSubjectRegistrationActivity.class);
        intent.putExtra("year", year);
        intent.putExtra("semester", semester);
        startActivity(intent);
    }

    /**
     * Get selected year from the spinner
     *
     * @return a string that represents the selected year
     */
    @Override
    public String getYear() {
        return spinnerYear.getSelectedItem().toString();
    }

    /**
     * Get the selected semester from the spinner
     *
     * @return a string that represents the selected semester
     */
    @Override
    public String getSemester() {
        return spinnerSemester.getSelectedItem().toString();
    }

    /**
     * Changes the layout from the offered subject fragment
     * to home secretary activity
     */
    public void changeToHomeScreen() {
        Intent intent = new Intent(getActivity(), HomeSecretaryActivity.class);
        startActivity(intent);
    }
}
