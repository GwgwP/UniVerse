package gr.aueb.softeng.team02.view.AcademicYear.AcademicYearForm;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
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
     * @return the view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_academic_year, container, false);
        year_spinner = (Spinner) myView.findViewById(R.id.spinner2);
        semester_spinner = (Spinner) myView.findViewById(R.id.spinnerSemester);

        init = new MemoryInitializer();
        ects = (EditText) myView.findViewById(R.id.editTextText);
        model = new AcademicYearFragmentViewModel();
        model.getPresenter().setView(this);

        addYearButton = (Button) myView.findViewById(R.id.add_year_button);
        start_date = (EditText) myView.findViewById(R.id.date_txt_start);
        end_date = (EditText) myView.findViewById(R.id.date_txt_end);
        firstX = (ImageView) myView.findViewById(R.id.ectsx_ac_year);
        secondX =(ImageView) myView.findViewById(R.id.ac_year_date1X);
        thridX = (ImageView) myView.findViewById(R.id.ac_year_date2X);


        checkButton = (Button) myView.findViewById(R.id.checkBtnSecretary);

        submitButton = (Button) myView.findViewById(R.id.submitBtnSecretary);

        return myView;
    }

    /**
     * every time that the Academic Year page
     * is triggered it sets the visibility of
     * the "X"s as not visible
     * and sets the listener in the buttons.
     * when the add year button is clicked it redirects the user to
     * the corresponding page
     * when the check button is clicked it checks the validity of the data
     * given by the user
     * when the submit button is clicked it stores the new circumscription.
     */
    @Override
    public void onStart() {
        super.onStart();
        submitButton.setVisibility(View.GONE);
        firstX.setVisibility(View.GONE);
        secondX.setVisibility(View.GONE);
        thridX.setVisibility(View.GONE);
        model.getPresenter().initLists();

        addYearButton.setOnClickListener(v -> model.getPresenter().onSeeAcademicYear());
        checkButton.setOnClickListener(v -> model.getPresenter().checkValid());
        submitButton.setOnClickListener(v -> model.getPresenter().createAcademicYearCircumscription());
    }

    /**
     * makes the submit button visible
     * for the user.
     */
    public void setVisibleSubmit() {
        submitButton.setVisibility(View.VISIBLE);
    }


    /**
     * Shows an alert message to user.
     * @param title the title of the message
     * @param message the message being shown
     */
    @Override
    public void alertMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("Yes", (dialog, which) -> model.getPresenter().overrideCirc())
                .setNegativeButton("No", (dialog, which) -> {

                })
                .show();
    }

    /**
     * redirects the user to the
     * page for registering a new academic year.
     */
    public void showAcYearsRegistration() {
        Intent intent = new Intent(requireContext(), AcademicYearRegistration.class);
        startActivity(intent);
    }


    /**
     *
     * creates a list of years for the spinner.
     * @param years list of years that could be selected
     */
    public void createYearList(ArrayList<String> years) {
        // Create an ArrayAdapter using the choices ArrayList
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, years);

        // Specify the layout for the dropdown items
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the ArrayAdapter on the Spinner
        year_spinner.setAdapter(adapter);

    }

    /**
     * creates a list with semesters for the spinner
     * @param semesters list of semesters that could be selected
     */
    public void createSemesterList(ArrayList<String> semesters) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, semesters);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semester_spinner.setAdapter(adapter);
    }

    /**
     *
     * @return returns the selected semester from the spinner
     * from the user's input
     */
    @Override
    public String getSelectedSemester() {
        return semester_spinner.getSelectedItem().toString();
    }

    /**
     *
     * @return returns the selected academic year from the spinner
     * from the user's input
     */
    @Override
    public String getSelectedYear() { //ArrayList<String> years) {
        return year_spinner.getSelectedItem().toString();
    }

    /**
     *
     * @return  returns the number of ects from the user's input
     */
    public String getECTS() {
        return ects.getText().toString().trim();
    }

    /**
     *
     * @return returns the start date from the user's input
     */
    @Override
    public String getDateStart() {
        return start_date.getText().toString().trim();
    }

    /**
     *
     * @return returns the end sate from the user's input
     */
    @Override
    public String getDateEnd() {
        return end_date.getText().toString().trim();
    }


    /**
     * A Toast
     * triggered when the circumscription
     * is stored successfully
     */
    public void messageSave() {
        Toast.makeText(requireContext(), "The circumscription in the academic year was saved successfully", Toast.LENGTH_SHORT).show();
    }

    /**
     * A Toast
     * triggered when the override
     * of the circumscription was stored successfully
     */
    public void messageOverride() {
        Toast.makeText(requireContext(), "The override in the academic year was saved successfully", Toast.LENGTH_SHORT).show();
    }


    /**
     * makes visible the "x" image
     * for the ects input
     */
    @Override
    public void setVisibleFirstX() {
        firstX.setVisibility(View.VISIBLE);
    }

    /**
     * makes visible the "x" image
     * for the start date input
     */
    @Override
    public void setVisibleSecondX() {
        secondX.setVisibility(View.VISIBLE);
    }

    /**
     * makes visible the "x" image
     * for the end date input
     */
    @Override
    public void setVisibleThirdX() {
        thridX.setVisibility(View.VISIBLE);
    }

    /**
     * A Toast to inform user that the circumscription
     * they are trying to submit is not valid
     *
     */
    @Override
    public void messageNotValidCirc() {
        Toast.makeText(requireContext(), "The circumscrption is not valid", Toast.LENGTH_SHORT).show();
    }

}
