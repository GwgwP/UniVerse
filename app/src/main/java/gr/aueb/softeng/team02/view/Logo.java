package gr.aueb.softeng.team02.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import gr.aueb.softeng.team02.R;
import gr.aueb.softeng.team02.view.Authentication.UserLoginActivity;

public class Logo extends Activity {
    ImageView pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        pic = (ImageView) findViewById(R.id.imageLogo);
    }

    @Override
    protected void onStart() {
        super.onStart();

        pic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.e("DEBUGGPXAPP","before clicking");
                Intent myIntent = new Intent(Logo.this, UserLoginActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

    }


}