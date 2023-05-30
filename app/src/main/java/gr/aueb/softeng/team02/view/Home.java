package gr.aueb.softeng.team02.view;


import android.app.Activity;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import gr.aueb.softeng.team02.R;

public class Home extends AppCompatActivity {


    BottomNavigationView bottomNav;


    HomeFragment homeFrag = new HomeFragment();
    ProgressFragment prograssFrag = new ProgressFragment();
    SearchFragment searchFrag = new SearchFragment();
    SubmissionFragment submissionFrag = new SubmissionFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNav= findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container , homeFrag).commit();
    }

}