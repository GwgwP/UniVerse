package gr.aueb.softeng.team02.view.Secretary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import gr.aueb.softeng.team02.R;

public class Home extends AppCompatActivity {

    public static final String STUDENT_ID = "student_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}