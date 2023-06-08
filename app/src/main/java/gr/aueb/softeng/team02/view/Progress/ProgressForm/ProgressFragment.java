package gr.aueb.softeng.team02.view.Progress.ProgressForm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.view.Progress.DetailedGrades.DetailedGradesActivity;

import java.util.HashMap;


public class ProgressFragment extends Fragment implements ProgressView {

    private View view;

    private TextView txtAverageGrade;
    private TextView txt_num_passed;

    private TextView sem_1_1;
    private TextView sem_2_2;
    private TextView sem_3_3;
    private TextView sem_4_4;
    private TextView sem_5_5;
    private TextView sem_6_6;
    private TextView sem_7_7;
    private TextView sem_8_8;

    private TextView total_ects;
    ProgressFragmentViewModel viewModel;
    private int student_id;
    private Initializer init;
    private ProgressPresenter presenter;


    /**
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's
     *                           UI should be attached to.  The fragment should not add the view itself,
     *                           but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state as given here.
     * @return returns the view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_progress, container, false);
        Bundle bundle = getArguments();

        this.student_id = bundle.getInt("STUDENT_ID", 0);
        this.init = new MemoryInitializer();


        viewModel = new ProgressFragmentViewModel(); //ViewModelProvider(this).get(ProgressFragmentViewModel.class);
        viewModel.getPresenter().setView(this);


        txt_num_passed = view.findViewById(R.id.perasmena_mathimata);
        txtAverageGrade = view.findViewById(R.id.ag);
        sem_1_1 = view.findViewById(R.id.sem_1_1);
        sem_2_2 = view.findViewById(R.id.sem_2_2);
        sem_3_3 = view.findViewById(R.id.sem_3_3);
        sem_4_4 = view.findViewById(R.id.sem_4_4);
        sem_5_5 = view.findViewById(R.id.sem_5_5);
        sem_6_6 = view.findViewById(R.id.sem_6_6);
        sem_7_7 = view.findViewById(R.id.sem_7_7);
        sem_8_8 = view.findViewById(R.id.sem_8_8);

        total_ects = view.findViewById(R.id.Total_Ects);

        view.findViewById(R.id.btn_show_subj_grades).setOnClickListener(v -> viewModel.getPresenter().onSeeGrades());

        return view;
    }


    /**
     * every time the fragment starts it
     * requests various student-related data from the presenter(average,
     * average per semester, number of passed subjects, ects).
     */
    @Override
    public void onStart() {
        super.onStart();
        viewModel.getPresenter().getAverage(student_id);
        viewModel.getPresenter().getAGperSem(student_id);
        viewModel.getPresenter().getNumOfSubs(student_id);
        viewModel.getPresenter().getECTS(student_id);
    }


    /**
     * shows the average passed
     *
     * @param avg the average to be shown
     */
    public void showAverage(double avg) {
        txtAverageGrade.setText(String.valueOf(avg));

    }

    /**
     * shows the number of passed subjects
     *
     * @param num the number of passed subjects
     */
    public void showNumPassed(int num) {
        txt_num_passed.setText(String.valueOf(num));

    }

    /**
     * redirects the user to the detailed grades page.
     * Passes all the necessary arguments using bundle
     * to the detailed grades activity
     */
    @Override
    public void showDetailedGrades() {

        String sem1 = (sem_1_1.getText().toString());
        String sem2 = (sem_2_2.getText().toString());
        String sem3 = (sem_3_3.getText().toString());
        String sem4 = (sem_4_4.getText().toString());
        String sem5 = (sem_5_5.getText().toString());
        String sem6 = (sem_6_6.getText().toString());
        String sem7 = (sem_7_7.getText().toString());
        String sem8 = (sem_8_8.getText().toString());


        Intent intent = new Intent(getActivity(), DetailedGradesActivity.class);
        intent.putExtra("student_id", this.student_id);
        intent.putExtra("sem1", sem1);
        intent.putExtra("sem2", sem2);
        intent.putExtra("sem3", sem3);
        intent.putExtra("sem4", sem4);
        intent.putExtra("sem5", sem5);
        intent.putExtra("sem6", sem6);
        intent.putExtra("sem7", sem7);
        intent.putExtra("sem8", sem8);

        startActivity(intent);

    }

    /**
     * shows the ects
     *
     * @param num the number of ects to be shown
     */
    @Override
    public void showECTS(int num) {
        total_ects.setText(total_ects.getText() + " " + String.valueOf(num));
    }

    /**
     * it shows th averages per semester.
     *
     * @param av_grades a hashmap containing semesters and average grades
     */
    public void showAveragePerSemester(HashMap<Integer, Double> av_grades) {
        if (!av_grades.containsKey(1))
            sem_1_1.setText("-");
        else sem_1_1.setText(String.valueOf(av_grades.get(1)));
        if (!av_grades.containsKey(2))
            sem_2_2.setText("-");
        else sem_2_2.setText(String.valueOf(av_grades.get(2)));
        if (!av_grades.containsKey(3))
            sem_3_3.setText("-");
        else sem_3_3.setText(String.valueOf(av_grades.get(3)));
        if (!av_grades.containsKey(4))
            sem_4_4.setText("-");
        else sem_4_4.setText(String.valueOf(av_grades.get(4)));
        if (!av_grades.containsKey(5))
            sem_5_5.setText("-");
        else sem_5_5.setText(String.valueOf(av_grades.get(5)));
        if (!av_grades.containsKey(6))
            sem_6_6.setText("-");
        else sem_6_6.setText(String.valueOf(av_grades.get(6)));
        if (!av_grades.containsKey(7))
            sem_7_7.setText("-");
        else sem_7_7.setText(String.valueOf(av_grades.get(7)));
        if (!av_grades.containsKey(8))
            sem_8_8.setText("-");
        else sem_8_8.setText(String.valueOf(av_grades.get(8)));
    }

}


