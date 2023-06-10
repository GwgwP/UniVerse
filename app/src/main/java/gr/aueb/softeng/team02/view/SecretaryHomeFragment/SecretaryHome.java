package gr.aueb.softeng.team02.view.SecretaryHomeFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.view.Authentication.UserLoginActivity;


public class SecretaryHome extends Fragment implements SecretaryHomeView {

    private SecretaryHomePresenter presenter;
    private Button logout;

    /**
     * Initializes and waits for the button to be pushed
     **/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_secretary_home, container, false);
        presenter = new SecretaryHomePresenter();
        presenter.setView(this);

        logout = (Button) view.findViewById(R.id.secretaryLogout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.logout();
            }
        });

        return view;
    }

    /**
     * Navigates to the authentication screen
     **/
    @Override
    public void escape() {
        Intent intent = new Intent(getContext(), UserLoginActivity.class);
        startActivity(intent);

    }

}