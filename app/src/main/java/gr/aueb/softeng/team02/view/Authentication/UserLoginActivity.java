package gr.aueb.softeng.team02.view.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;

import gr.aueb.softeng.team02.R;

public class UserLoginActivity extends AppCompatActivity implements UserLoginView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        setTitle("Login User");

        // Init buttons

        // Define initializer & prepareData

        // Presenter
    }


    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void showErrorMessage(String title, String message) {
        // new AlertDialog.Builder(UserLoginActivity.this).setCancelable(true).setTitle(title).setMessage(message)
    }
}