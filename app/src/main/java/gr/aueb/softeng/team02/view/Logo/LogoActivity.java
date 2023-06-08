package gr.aueb.softeng.team02.view.Logo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.view.Authentication.UserLoginActivity;

public class LogoActivity extends Activity implements LogoActivityView {
    ImageView pic;
    LogoActivityPresenter presenter;

    /**
     * Initializes the classes attributes
     **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        pic = (ImageView) findViewById(R.id.imageLogo);
        presenter = new LogoActivityPresenter(this);
    }

    /**
     * Waits for the screen to be clicked
     **/
    @Override
    protected void onStart() {
        super.onStart();

        pic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                presenter.moveScreen();
            }
        });
    }

    /**
     * Navigates the app to the Authentication Page
     **/
    @Override
    public void gotToHomeScreen() {
        Intent myIntent = new Intent(LogoActivity.this, UserLoginActivity.class);
        startActivityForResult(myIntent, 0);
    }
}
