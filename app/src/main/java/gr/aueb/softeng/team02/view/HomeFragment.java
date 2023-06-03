package gr.aueb.softeng.team02.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gr.aueb.softeng.team02.R;

public class HomeFragment extends Fragment {

//    public HomeFragment() {
//        super(R.layout.fragment_home);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}