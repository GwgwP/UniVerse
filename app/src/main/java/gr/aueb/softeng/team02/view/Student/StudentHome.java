package gr.aueb.softeng.team02.view.Student;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gr.aueb.softeng.team02.R;

public class StudentHome extends Fragment {

//    public StudentHome() {
//        super(R.layout.fragment_home);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home_student, container, false);
    }

}