package gr.aueb.softeng.team02.view.Progress.DetailedGrades;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.view.Progress.ProgressPresenter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.memorydao.GradeDAOMemory;

public class DetailedGradesActivity extends AppCompatActivity implements DetailedGradesView{
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress);
        presenter = new DetailedGradesPresenter(this, new GradeDAOMemory());


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


    }

    public void receiveAverages(){
        Bundle bundle = getIntent().getExtras();

        student_id = bundle.getInt("student_id");
        presenter.setStudentId(student_id);

        sem_1_1.setText(sem_1_1.getText().toString()+" "+ bundle.getString("sem1"));
        sem_2_2.setText(sem_2_2.getText().toString()+" "+ bundle.getString("sem2"));
        sem_3_3.setText(sem_3_3.getText().toString()+" "+ bundle.getString("sem3"));
        sem_4_4.setText(sem_4_4.getText().toString()+" "+ bundle.getString("sem4"));
        sem_5_5.setText(sem_5_5.getText().toString()+" "+ bundle.getString("sem5"));
        sem_6_6.setText(sem_6_6.getText().toString()+" "+ bundle.getString("sem6"));
        sem_7_7.setText(sem_7_7.getText().toString()+" "+ bundle.getString("sem7"));
        sem_8_8.setText(sem_8_8.getText().toString()+" "+ bundle.getString("sem8"));

    }

}