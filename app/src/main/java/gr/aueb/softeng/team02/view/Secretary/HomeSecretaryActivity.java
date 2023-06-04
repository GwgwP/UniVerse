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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.view.Student.HomeStudentPresenter;

public class HomeSecretaryActivity extends AppCompatActivity implements HomeSecretaryView {

    public static final String SECRETARY_ID = "student_id";
    private int studentId;

    FloatingActionButton plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        studentId = intent.getIntExtra(SECRETARY_ID, 12);
        setContentView(R.layout.activity_home);

        plus = (FloatingActionButton)findViewById(R.id.plusButton);

        HomeSecretaryPresenter presenter = new HomeSecretaryPresenter(this);

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
    }

    @Override
    public void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putInt("STUDENT_ID", studentId);
        fragment.setArguments(bundle);

        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }


}