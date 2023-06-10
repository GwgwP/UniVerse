package gr.aueb.softeng.team02.view.Secretary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.view.Student.HomeStudentPresenter;

public class HomeSecretaryActivity extends AppCompatActivity implements HomeSecretaryView {

    public static final String SECRETARY_ID = "secretary_id";
    private int secretaryId;
    private Initializer init;
    FloatingActionButton plus;

    /**
     * Changes the view according on  which button was pressed on the navigation button and if the plus button is pressed it upgrades the grades
     **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        secretaryId = intent.getIntExtra(SECRETARY_ID, 12);
        setContentView(R.layout.secretary_home);

        plus = (FloatingActionButton) findViewById(R.id.plusButton);
        init = new MemoryInitializer();
        HomeSecretaryPresenter presenter = new HomeSecretaryPresenter(this, init.getAcademicYearDAO());

        // Set the initial fragment to be displayed
        presenter.changeFragment(R.id.secretaryHome);

        // Set up the bottom navigation view
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationViewSecretary);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                presenter.changeFragment(item.getItemId());
                return true;
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateGrades();
            }
        });
    }

    /**
     * Responsible for the transition from one fragment to another
     *
     * @param fragment : the destination fragment
     **/
    @Override
    public void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putInt("STUDENT_ID", secretaryId);
        fragment.setArguments(bundle);
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }

    /**
     * Shows the desired message
     *
     * @param txt : the message we want to show
     **/
    @Override
    public void showMessage(String txt) {
        Toast.makeText(this, txt, Toast.LENGTH_LONG).show();
    }
}

