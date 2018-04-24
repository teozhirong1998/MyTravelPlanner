package com.example.a16022635.mytravelplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    Button btnAddTrip;
    Button btnViewTrips;
    Button btnMngTrips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        btnAddTrip = (Button) findViewById(R.id.btnAddTrip);
        btnViewTrips = (Button) findViewById(R.id.btnViewTrips);
        btnMngTrips = (Button) findViewById(R.id.btnManageTrips);

        btnAddTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this, AddTrip.class);
                startActivity(i);
            }
        });


    }
}
