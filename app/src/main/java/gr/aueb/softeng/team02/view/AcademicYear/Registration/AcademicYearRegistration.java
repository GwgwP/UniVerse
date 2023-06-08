package gr.aueb.softeng.team02.view.AcademicYear.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.AcademicYearDAOMemory;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;

public class AcademicYearRegistration extends AppCompatActivity implements AcademicYearRegView {


    private EditText newYear;
    private Initializer init;
    private EditText start_date;
    private EditText end_date;
    AcademicYearRegPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_year_registration);
        presenter = new AcademicYearRegPresenter(this, new AcademicYearDAOMemory());
        presenter.setView(this);
        init = new MemoryInitializer();

        start_date = (EditText) findViewById(R.id.start_date_ac_year);
        end_date = (EditText) findViewById(R.id.end_date_ac_year);
        newYear = (EditText)findViewById(R.id.ac_year_reg_txt);

    }

    @Override
    public void onStart() {
        super.onStart();
    }


    @Override
    public String getAcademicYear() {
        return newYear.getText().toString().trim();
    }

    @Override
    public String getStartDate() {
        return start_date.getText().toString().trim();
    }

    @Override
    public String getEndDate() {
        return end_date.getText().toString().trim();
    }

    @Override
    public void messageSave(){
        Toast.makeText(getApplicationContext(),"The academic year was saved successfully",Toast.LENGTH_SHORT).show();
    }
}