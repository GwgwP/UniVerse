package gr.aueb.softeng.team02.view.OfferedSubject.OfferedSubjectRegistration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;

public class OfferedSubjectRegistrationActivity extends AppCompatActivity implements OfferedSubjectRegistrationView{
    String semester;
    String year;
    OfferedSubjectRegistrationPresenter presenter;
    Initializer init;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offered_subject_registration);

        // Retrieve the extras from the Intent
        Bundle extras = getIntent().getExtras();
        semester = extras.getString("semester");
        year = extras.getString("year");
        init = new MemoryInitializer();
        presenter = new OfferedSubjectRegistrationPresenter(this, init.getOfferedSubjectDAO(), init.getSubjectDAO());
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.init(year, semester);
    }

    @Override
    public void createTable(ArrayList<String> subjects) {

    }
}