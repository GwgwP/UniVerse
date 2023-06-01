package gr.aueb.softeng.team02.view.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Map;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.model.Secretary;
import gr.aueb.softeng.team02.model.Student;
import gr.aueb.softeng.team02.model.User;
import gr.aueb.softeng.team02.view.Home;

public class UserLoginActivity extends AppCompatActivity implements UserLoginView {

    Button login;
    EditText name;
    EditText pass;
    Switch role ;
    ImageView firstX;
    ImageView secondX;

    private UserLoginPresenter presenter;
    private Initializer init;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        setTitle("Login User");

        // Init buttons
        name = (EditText) findViewById(R.id.nameEditText);
        pass = (EditText) findViewById(R.id.passwordEditText);
        login = (Button) findViewById(R.id.logInButton);
        role = (Switch) findViewById(R.id.roleSwitch);
        firstX = (ImageView) findViewById(R.id.exfirImage);
        secondX = findViewById(R.id.exsecImage);

        firstX.setVisibility(View.GONE);
        secondX.setVisibility(View.GONE);
//
        // Define initializer & prepareData & presenter
        init = new MemoryInitializer();
        try {
            init.prepareData();
        } catch (AcademicYearException e) {
            throw new RuntimeException(e);
        }
        presenter = new UserLoginPresenter(this, init.getStudentDAO(), init.getSecretaryDAO());
    }

    @Override
    protected void onStart() {
        super.onStart();
        login.setOnClickListener(new View.OnClickListener() {
            //Todo: if the user has not written in all the text boxes error symbols
            public void onClick(View view) { ///the button login was pressed and we take the two(later three) inputs
                //Todo : take the input for the role (student or secretaty)
                firstX.setVisibility(View.GONE);
                secondX.setVisibility(View.GONE);

                String username = getUsername();
                String password = getPassword();

                if(username.equals("")){
                    firstX.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Please write your username ", Toast.LENGTH_SHORT).show();
                }
                if(password.equals("")){
                    secondX.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Please write your password ", Toast.LENGTH_SHORT).show();
                }

               if(!(password.equals("")||username.equals(""))){
                   // Log.e("DEBUGGER","username : "+ username +" and password "+password);
                   Map.Entry<Integer, User> user = presenter.findUser(username, password);
                   // Log.e("DEBUGGER", String.valueOf(user.getKey()));

                   switch (user.getKey()) {
                    case 1:
                        presenter.studentLogin(user.getValue().getId());
                        break;
                    case 2:
                        presenter.secretaryLogin(user.getValue().getId());
                        break;
                    }
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
    public void studentLogin(int id) {
        Intent userActivityScreen = new Intent(getApplicationContext(), Home.class);
        userActivityScreen.putExtra(Home.STUDENT_ID, id);
        startActivity(userActivityScreen);
    }

    @Override
    public void secretaryLogin(int id) {

    }

    public int getRole(){
        return 0;
    }

}