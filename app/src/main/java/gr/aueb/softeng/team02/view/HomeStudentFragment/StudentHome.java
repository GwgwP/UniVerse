package gr.aueb.softeng.team02.view.HomeStudentFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.view.Authentication.UserLoginActivity;

public class StudentHome extends Fragment implements StudentHomeView {
    private Button logout;
    private StudentHomePresenter presenter;

    /**
     * Initializer . Waits for the button to be pressed
     **/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_student, container, false);
        presenter = new StudentHomePresenter();
        presenter.setView(this);

        logout = (Button) view.findViewById(R.id.logoutStudent);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.press();
            }
        });


        return view;

    }

    /**
     * Navigates to the authentication screen
     **/
    @Override
    public void logout() {
        Intent intent = new Intent(getContext(), UserLoginActivity.class);
        startActivity(intent);
    }


}