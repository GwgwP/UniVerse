package gr.aueb.softeng.team02.view;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import gr.aueb.softeng.team02.R;

public class Home extends AppCompatActivity {
    private Fragment homeFragment;
    private Fragment progressFragment;
    private Fragment submissionFragment;
    private Fragment searchFragment;

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_home);

        // Initialize the fragments
        homeFragment = new HomeFragment();
        progressFragment = new ProgressFragment();
        submissionFragment = new SubmissionFragment();
        searchFragment = new SearchFragment();

        // Set the initial fragment to be displayed
        replaceFragment(new HomeFragment());
        // bottomNavigationView.setBackground(null);

        // Set up the bottom navigation view
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        // bottomNavigationView.setOnNavigationItemSelectedListener(this);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.homeFragment:
                        replaceFragment(new HomeFragment());
                        Log.e("DEBUGGER", "Home");
                        break;
                    case R.id.submissionFragment:
                        replaceFragment(new SubmissionFragment());
                        Log.e("DEBUGGER", "Submission");
                        break;
                    case R.id.progressFragment:
                        replaceFragment(new ProgressFragment());
                        Log.e("DEBUGGER", "Progress");
                        break;
                    case R.id.searchFragment:
                        replaceFragment(new SearchFragment());
                        break;
                }
                return true;
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }

}