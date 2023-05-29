package gr.aueb.softeng.team02.view.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.view.Home;

public class UserLoginActivity extends AppCompatActivity implements UserLoginView {

    Button login;
    EditText name;
    EditText pass;

    private UserLoginPresenter presenter;
    private Initializer init = new Initializer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        setTitle("Login User");

        // Init buttons
        name = (EditText) findViewById(R.id.nameEditText);
        pass = (EditText) findViewById(R.id.passwordEditText);
        login = (Button) findViewById(R.id.logInButton);
//
        // Define initializer & prepareData & presenter
        init.prepareData();
        presenter = new UserLoginPresenter(this, init.getStudentDAO(), init.getSecretaryDAO());
    }

    @Override
    protected void onStart() {
        super.onStart();
        login.setOnClickListener(new View.OnClickListener() {
            //Todo: if the user has not written in all the text boxes error symbols
            public void onClick(View view) { ///the button login was pressed and we take the two(later three) inputs
                //Todo : take the input for the role (student or secretaty)
                String username = getUsername();
                String password = getPassword();
                Log.e("DEBUGGER","username : "+ username +" and password "+password);
                int user = presenter.findUser(username, password);
                Log.e("DEBUGGER", String.valueOf(user));
                switch (user) {
                    case 1:
                        presenter.studentLogin();
                        break;
                    case 2:
                        presenter.secretaryLogin();
                        break;
                }
            }
        });
    }

    @Override
    public String getUsername() {
        return name.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return pass.getText().toString().trim();
    }

    @Override
    public void showErrorMessage(String title, String message) {
        // new AlertDialog.Builder(UserLoginActivity.this).setCancelable(true).setTitle(title).setMessage(message)
    }

    @Override
    public void studentLogin() {
        Intent userActivityScreen = new Intent(getApplicationContext(), Home.class);
        startActivity(userActivityScreen);
    }

    @Override
    public void secretaryLogin() {

    }


}