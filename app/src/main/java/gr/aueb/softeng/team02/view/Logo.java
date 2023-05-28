package gr.aueb.softeng.team02.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import gr.aueb.softeng.team02.R;

public class Logo extends AppCompatActivity {

    ImageButton logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        logo = findViewById(R.id.LogoButton);
    }

    @Override
    protected void onStart() {
        super.onStart();

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Logo.this,"Home",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Logo.this, Home.class);
                startActivity(intent);
            }
        });
    }
}