package gr.aueb.softeng.team02.view.Student;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import gr.aueb.softeng.team02.R;

public class HomeStudentActivity extends AppCompatActivity implements HomeStudentView {
    public static final String STUDENT_ID = "student_id";
    private int studentId;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_home);

        Intent intent = getIntent();
        studentId = intent.getIntExtra(STUDENT_ID, 12);

        setTitle("Universe");
        setTitle(String.valueOf(studentId));

        HomeStudentPresenter presenter = new HomeStudentPresenter(this);

        // Set the initial fragment to be displayed
        presenter.changeFragment(R.id.homeFragment);

        // Set up the bottom navigation view
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationViewStudent);

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
