package gr.aueb.softeng.team02.view.Progress;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.w3c.dom.Text;

import java.util.ArrayList;
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

    ProgressFragmentViewModel viewModel;
    private int student_id;
    private Initializer init;
    private ProgressPresenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_progress, container, false);
        Bundle bundle = getArguments();

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

        this.student_id = bundle.getInt("STUDENT_ID", 0);
        this.init = new MemoryInitializer();


        viewModel = new ProgressFragmentViewModel(); //ViewModelProvider(this).get(ProgressFragmentViewModel.class);
        viewModel.getPresenter().setView(this);
        //ProgressPresenter presenter = viewModel.getPresenter();
        //presenter.setView(this);

        //presenter = new ProgressPresenter(this, init.getGradeDAO());
        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        viewModel.getPresenter().getAverage(student_id);
        viewModel.getPresenter().getAGperSem(student_id);
        viewModel.getPresenter().getNumOfSubs(student_id);
    }


    @Override
    public void getGrade() {

    }

    public void showAverage(double avg) {
        txtAverageGrade.setText(String.valueOf(avg));

    }

    public void showNumPassed(int num) {
        txtAverageGrade.setText(String.valueOf(num));

    }

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

