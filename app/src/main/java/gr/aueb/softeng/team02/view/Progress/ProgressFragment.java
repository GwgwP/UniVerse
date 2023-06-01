package gr.aueb.softeng.team02.view.Progress;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;


public class ProgressFragment extends Fragment {

    private View view;
    private int student_id;
    private Initializer init;
    private ProgressPresenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_progress, container, false);
        Bundle bundle = getArguments();

        this.student_id = bundle.getInt("STUDENT_ID",0);
        this.init = new MemoryInitializer();

        presenter = new ProgressPresenter(this, init.getGradeDAO());

        return view;
    }





}