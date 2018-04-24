package com.example.a16022635.mytravelplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.a16022635.mytravelplanner.R;

import java.util.ArrayList;

public class AddItinerary extends AppCompatActivity {

    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_itinerary);

        lv = (ListView) this.findViewById(R.id.lvDays);

        Intent i = getIntent();

        String tripTitle = i.getStringExtra("tripTitle");
        String tripDuration = i.getStringExtra("tripDuration");
        String tripLocation = i.getStringExtra("tripLocation");

        al = new ArrayList<String>();
        for (int x = 0; x < Integer.parseInt(tripDuration); x++) {
            al.add("Day " + (x + 1));
        }

        aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AddItinerary.this, )
            }
        });
    }
}
