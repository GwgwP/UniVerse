package gr.aueb.softeng.team02.view.Secretary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import gr.aueb.softeng.team02.R;

public class HomeSecretaryActivity extends AppCompatActivity implements HomeSecretaryView {

    public static final String SECRETARY_ID = "secretary_id";
    private int secretaryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        secretaryId = intent.getIntExtra(SECRETARY_ID, 12);
        setContentView(R.layout.secretary_home);
    }

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
}