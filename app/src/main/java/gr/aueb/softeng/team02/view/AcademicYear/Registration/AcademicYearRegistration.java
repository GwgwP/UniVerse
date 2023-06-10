package gr.aueb.softeng.team02.view.AcademicYear.Registration;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.AcademicYearDAOMemory;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;

/**
 * @author Georgia Petsa
 *
 * Υλοποιήθηκε στα πλαίσια του μαθήματος Τεχνολογία Λογισμικού το έτος 2022-2023.
 *
 */
public class AcademicYearRegistration extends Activity implements AcademicYearRegView {


    private EditText newYear;
    private ImageView firstX;
    private ImageView secondX;
    private ImageView thirdX;
    private Initializer init;
    private EditText start_date;
    private EditText end_date;
    private Button add;
    AcademicYearRegPresenter presenter;


    /**
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_year_registration);
        presenter = new AcademicYearRegPresenter(this, new AcademicYearDAOMemory());
        init = new MemoryInitializer();
        add = (Button) findViewById(R.id.button_register_ac_year);

        start_date = (EditText) findViewById(R.id.start_date_ac_year);
        end_date = (EditText) findViewById(R.id.end_date_ac_year);
        newYear = (EditText)findViewById(R.id.ac_year_reg_txt);

        firstX = (ImageView) findViewById(R.id.firts_x_ac_year_reg);
        secondX = (ImageView) findViewById(R.id.second_x_ac_year_reg);
        thirdX = (ImageView) findViewById(R.id.third_x_ac_year_reg);

    }

    /**
     * Every time time that the activity
     * is triggered it changes the visibility of
     * the "x" images and sets the event onClick
     * Listener to the add button
     */
    @Override
    public void onStart() {
        super.onStart();
        firstX.setVisibility(View.GONE);
        secondX.setVisibility(View.GONE);
        thirdX.setVisibility(View.GONE);
        add.setOnClickListener(v -> presenter.valid());
    }

    /**
     * makes the "X" image for the academic year input
     * visible
     */
    public void setVisibleFirstX()
    {
        firstX.setVisibility(View.VISIBLE);
    }
    /**
     * makes the "X" image for the start date input
     * visible
     */
    public void setVisibleSecondX()
    {
        secondX.setVisibility(View.VISIBLE);
    }

    /**
     * makes the "X" image for the end date input
     * visible
     */
    public void setVisibleThirdX()
    {
        thirdX.setVisibility(View.VISIBLE);
    }


    /**
     *
     * @return returns the academic year from user input
     */
    @Override
    public String getAcademicYear() {
        return newYear.getText().toString().trim();
    }

    /**
     *
     * @return returns the start date from user input
     */
    @Override
    public String getStartDate() {
        return start_date.getText().toString().trim();
    }

    /**
     *
     * @return returns the end date from user input
     */
    @Override
    public String getEndDate() {
        return end_date.getText().toString().trim();
    }

    /**
     * a Toast
     * informs the user that the academic year was stored successfully
     */
    @Override
    public void messageSave(){
        Toast.makeText(getApplicationContext(),"The academic year was saved successfully",Toast.LENGTH_SHORT).show();
    }

    /**
     * a Toast
     * informs the user that the override of academic year's fields
     * was stored successfully
     */
    public void messageDIDNTSave(){
        Toast.makeText(getApplicationContext(),"The academic year is already stored.",Toast.LENGTH_SHORT).show();
    }

    /**
     * Shows an alert message to user.
     * @param title the title of the message
     * @param message the message being shown
     */
    @Override
    public void alertUser(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .show();

    }



}