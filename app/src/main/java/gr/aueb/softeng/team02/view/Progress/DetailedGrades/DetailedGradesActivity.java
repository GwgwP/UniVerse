package gr.aueb.softeng.team02.view.Progress.DetailedGrades;

import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import gr.aueb.softeng.team02.R;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;
import java.util.HashMap;
import gr.aueb.softeng.team02.memorydao.GradeDAOMemory;

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

    private List<String> subjectsAndGradesLists;
    private ListAdapter[] adapters;
    private ListView[] listViews;


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

        // Initialize the lists, adapters, and listViews
        subjectsAndGradesLists = new ArrayList<>();
        adapters = new ListAdapter[8];
        listViews = new ListView[8];

        // Get references to the ListViews in the layout
        listViews[0] = findViewById(R.id.sem1_subj);
        listViews[1] = findViewById(R.id.sem2_subj);
        listViews[2] = findViewById(R.id.sem3_subj);
        listViews[3] = findViewById(R.id.sem4_subj);
        listViews[4] = findViewById(R.id.sem5_subj);
        listViews[5] = findViewById(R.id.sem6_subj);
        listViews[6] = findViewById(R.id.sem7_subj);
        listViews[7] = findViewById(R.id.sem8_subj);

        for (int i = 0; i < 8; i++) {
            adapters[i] = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
            listViews[i].setAdapter(adapters[i]);
        }

    }

    public void onStart() {
        super.onStart();
        receiveAverages();
        presenter.initSubView();
    }


    @SuppressLint("SetTextI18n")
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

        for (int i = 0; i < 8; i++) {
            HashMap<String, Integer> subjectGradesMap = subjects.get(i + 1);
            List<String> subjectGradesList = new ArrayList<>();

            if (subjectGradesMap != null) {
                for (String subject : subjectGradesMap.keySet()) {
                    int grade = subjectGradesMap.get(subject);
                    String subjectGrade = subject + " - " + grade;
                    subjectGradesList.add(subjectGrade);
                }
            }

            // Update the data source of the adapter for the corresponding ListView
            ArrayAdapter<String> adapter = (ArrayAdapter<String>) adapters[i];
            adapter.clear();
            adapter.addAll(subjectGradesList);

            // Notify the adapter of the data changes
            adapter.notifyDataSetChanged();

        }

    }

}