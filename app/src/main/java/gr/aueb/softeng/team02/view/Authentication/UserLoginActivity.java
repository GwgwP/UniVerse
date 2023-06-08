package gr.aueb.softeng.team02.view.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.view.Secretary.HomeSecretaryActivity;
import gr.aueb.softeng.team02.view.Student.HomeStudentActivity;

public class UserLoginActivity extends AppCompatActivity implements UserLoginView {

    Button login;
    EditText name;
    EditText pass;
    Switch role;
    ImageView firstX;
    ImageView secondX;

    private UserLoginPresenter presenter;
    private Initializer init;

    /**
     * Initializers the data
     **/
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

        // Define initializer & prepareData & presenter
        init = new MemoryInitializer();
        try {
            init.prepareData();
        } catch (AcademicYearException e) {
            Log.e("DEBUGGER", "Fault");
            throw new RuntimeException(e);
        }
        presenter = new UserLoginPresenter(this, init.getStudentDAO(), init.getSecretaryDAO());
    }

    /**
     * Waits for the button to be pushed to take their inputs
     **/
    @Override
    protected void onStart() {
        super.onStart();
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) { ///the button login was pressed and we take the two(later three) inputs
                firstX.setVisibility(View.GONE);
                secondX.setVisibility(View.GONE);
                presenter.startProcess();
            }
        });
    }

    /**
     * Shows a pop up window with a customized message
     *
     * @param title: the title of the window
     * @param txt    : the text of the window
     **/
    @Override
    public void showAlertMessage(String title, String txt) {
        new AlertDialog.Builder(UserLoginActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(txt)
                .setPositiveButton(R.string.ok, null).create().show();
    }

    /**
     * Gets the username and
     *
     * @return it
     **/
    @Override
    public String getUsername() {
        return name.getText().toString().trim();
    }

    /**
     * Gets the password and
     *
     * @return it
     **/
    @Override
    public String getPassword() {
        return pass.getText().toString().trim();
    }

    /**
     * If the user who is trying to login is a student then we go to the Student Home
     *
     * @param id : the students id
     **/
    @Override
    public void studentLogin(int id) {
        Intent userActivityScreen = new Intent(getApplicationContext(), HomeStudentActivity.class);
        userActivityScreen.putExtra(HomeStudentActivity.STUDENT_ID, id);
        startActivity(userActivityScreen);
    }

    /**
     * If the user who is trying to login is a secretary then we go to the Secretary Home
     *
     * @param id : the secretary id
     **/
    @Override
    public void secretaryLogin(int id) {
        Intent userActivityScreen = new Intent(getApplicationContext(), HomeSecretaryActivity.class);
        userActivityScreen.putExtra(HomeSecretaryActivity.SECRETARY_ID, id);
        startActivity(userActivityScreen);
    }

    /**
     * Gets the role of the user (0 = student , 1 = secretary)
     *
     * @return 0 or 1
     **/
    @Override
    public int getRole() {
        if (!role.isChecked())
            return 0;
        else
            return 1;
    }

    /**
     * Makes the X image (for the username ) visible and prints a notification
     *
     * @param txt : the message we want to be displayed
     **/
    @Override
    public void initUsernameX(String txt) {
        firstX.setVisibility(View.VISIBLE);
        Toast.makeText(getApplicationContext(), txt, Toast.LENGTH_SHORT).show();
    }

    /**
     * Makes the X image (for the password ) visible and prints a notification
     *
     * @param txt : the message we want to be displayed
     **/
    @Override
    public void initPasswordX(String txt) {
        secondX.setVisibility(View.VISIBLE);
        Toast.makeText(getApplicationContext(), txt, Toast.LENGTH_SHORT).show();
    }

}