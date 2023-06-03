package gr.aueb.softeng.team02.view.Progress.DetailedGrades;

import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.Grade;
import gr.aueb.softeng.team02.model.OfferedSubject;
import gr.aueb.softeng.team02.view.Progress.ProgressPresenter;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.softeng.team02.R;

import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.dao.OfferedSubjectDAO;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.memorydao.OfferedSubjectDAOMemory;
import gr.aueb.softeng.team02.model.OfferedSubject;
import gr.aueb.softeng.team02.view.SubjectInfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Set;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.memorydao.GradeDAOMemory;
import gr.aueb.softeng.team02.view.SubjectInfo;

public class DetailedGradesActivity extends AppCompatActivity implements DetailedGradesView {
    DetailedGradesPresenter presenter;
    private int student_id;
    private TextView sem_1_1;
    private TextView sem_2_2;
    private TextView sem_3_3;
    private TextView sem_4_4;
    private TextView sem_5_5;
    private TextView sem_6_6;
    private TextView sem_7_7;
    private TextView sem_8_8;

    private Initializer init;
    private LinearLayout subjectContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress);
        presenter = new DetailedGradesPresenter(this, new GradeDAOMemory());


        subjectContainer = findViewById(R.id.sub_cont);

        init = new MemoryInitializer();
        sem_1_1 = findViewById(R.id.average_1);
        sem_2_2 = findViewById(R.id.average_2);
        sem_3_3 = findViewById(R.id.average_3);
        sem_4_4 = findViewById(R.id.average_4);
        sem_5_5 = findViewById(R.id.average_5);
        sem_6_6 = findViewById(R.id.average_6);
        sem_7_7 = findViewById(R.id.average_7);
        sem_8_8 = findViewById(R.id.average_8);


    }

    public void onStart() {
        super.onStart();
        receiveAverages();
        presenter.initSubView();
    }


    public void receiveAverages() {
        Bundle bundle = getIntent().getExtras();

        student_id = bundle.getInt("student_id");
        presenter.setStudentId(student_id);

        sem_1_1.setText(sem_1_1.getText().toString() + " " + bundle.getString("sem1"));
        sem_2_2.setText(sem_2_2.getText().toString() + " " + bundle.getString("sem2"));
        sem_3_3.setText(sem_3_3.getText().toString() + " " + bundle.getString("sem3"));
        sem_4_4.setText(sem_4_4.getText().toString() + " " + bundle.getString("sem4"));
        sem_5_5.setText(sem_5_5.getText().toString() + " " + bundle.getString("sem5"));
        sem_6_6.setText(sem_6_6.getText().toString() + " " + bundle.getString("sem6"));
        sem_7_7.setText(sem_7_7.getText().toString() + " " + bundle.getString("sem7"));
        sem_8_8.setText(sem_8_8.getText().toString() + " " + bundle.getString("sem8"));

    }

    @Override
    public void viewSub(HashMap<Integer, HashMap<String, Integer>> subjects) {

    }


}