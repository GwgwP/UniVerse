package gr.aueb.softeng.team02.view.AcademicYear.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Date;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.AcademicYearDAOMemory;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_year_registration);
        presenter = new AcademicYearRegPresenter(this, new AcademicYearDAOMemory());
        presenter.setView(this);
        init = new MemoryInitializer();
        add = (Button) findViewById(R.id.button_register_ac_year);

        start_date = (EditText) findViewById(R.id.start_date_ac_year);
        end_date = (EditText) findViewById(R.id.end_date_ac_year);
        newYear = (EditText)findViewById(R.id.ac_year_reg_txt);

        firstX = (ImageView) findViewById(R.id.firts_x_ac_year_reg);
        secondX = (ImageView) findViewById(R.id.second_x_ac_year_reg);
        thirdX = (ImageView) findViewById(R.id.third_x_ac_year_reg);

    }

    @Override
    public void onStart() {
        super.onStart();
        firstX.setVisibility(View.GONE);
        secondX.setVisibility(View.GONE);
        thirdX.setVisibility(View.GONE);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                presenter.valid();
            }
        });
    }

    public void setVisibleFirstX()
    {
        firstX.setVisibility(View.VISIBLE);
    }
    public void setVisibleSecondX()
    {
        secondX.setVisibility(View.VISIBLE);
    }
    public void setVisibleThirdX()
    {
        thirdX.setVisibility(View.VISIBLE);
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
    public void messageDIDNTSave(){
        Toast.makeText(getApplicationContext(),"The academic year is already stored.",Toast.LENGTH_SHORT).show();
    }
}