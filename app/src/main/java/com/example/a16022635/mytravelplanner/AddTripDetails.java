package com.example.a16022635.mytravelplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class AddTripDetails extends AppCompatActivity {

    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip_details);



        lv = (ListView) this.findViewById(R.id.lvDetails);
        al = new ArrayList<String>();
        al.add("Itinerary");
        al.add("Flight Details");

        aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = getIntent();
                String tripTitle = i.getStringExtra("tripTitle");
                String tripDuration = i.getStringExtra("tripDuration");
                String tripLocation = i.getStringExtra("tripLocation");

                String detail = al.get(position);

                if(detail.equalsIgnoreCase("itinerary")) {
                    Intent intent = new Intent(AddTripDetails.this, AddItinerary.class);
                    intent.putExtra("tripTitle", tripTitle);
                    intent.putExtra("tripDuration", tripDuration);
                    intent.putExtra("tripLocation", tripLocation);
                    startActivity(intent);
                } else {
//                    Intent intent = new Intent(AddTripDetails.this, AddItinerary.class);
//                    intent.putExtra("tripTitle", tripTitle);
//                    intent.putExtra("tripDuration", tripDuration);
//                    intent.putExtra("tripLocation", tripLocation);
//                    startActivity(intent);
                }


            }
        });

    }

}
