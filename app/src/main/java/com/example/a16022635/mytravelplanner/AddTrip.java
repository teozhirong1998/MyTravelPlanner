package com.example.a16022635.mytravelplanner;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddTrip extends AppCompatActivity {

    private static final int RESULT_LOAD_IMAGE = 1;

    ImageView imageToUpload;
    Button btnUpload;
    Button btnSaveTrip;
    EditText etTripTitle, etTripDuration, etTripLocation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);

        Intent i = getIntent();

        imageToUpload = (ImageView) findViewById(R.id.imageToUpload);
        btnUpload = (Button) findViewById(R.id.buttonUpload);
        btnSaveTrip = (Button) findViewById(R.id.btnSaveTrip);
        etTripTitle = (EditText) findViewById(R.id.etTripTitle);
        etTripDuration = (EditText) findViewById(R.id.etTripDuration);
        etTripLocation = (EditText) findViewById(R.id.etTripLocation) ;

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
            }
        });


            btnSaveTrip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if((etTripTitle.getText().toString().equals("")) && (etTripDuration.getText().toString().equals("")) && (etTripLocation.getText().toString().equals(""))) {
                        Toast.makeText(getApplicationContext(),"Please fill up the blanks, image can be left empty.", Toast.LENGTH_LONG).show();
                    }else {
                        String tripTitle = etTripTitle.getText().toString();
                        String tripDuration = etTripDuration.getText().toString();
                        String tripLocation = etTripLocation.getText().toString();
                        Intent i = new Intent(AddTrip.this, AddTripDetails.class);

                        i.putExtra("tripTitle", tripTitle);
                        i.putExtra("tripDuration", tripDuration);
                        i.putExtra("tripLocation", tripLocation);
                        startActivity(i);
                    }


                }
            });
        }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null){
            Uri selectedImg = data.getData();
            imageToUpload.setImageURI(selectedImg);
        }
    }
}
