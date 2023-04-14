 package com.example.event_management;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

 public class Profile extends AppCompatActivity {
    TextView venue;
    TextView date;
    TextView textView;
    TextView name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        venue = findViewById(R.id.venue);
        date = findViewById(R.id.date);
        textView = findViewById(R.id.textView);
        name = findViewById(R.id.name);

        Intent intent = getIntent();
        String venueStr = intent.getStringExtra("venue");
        String dateStr = intent.getStringExtra("date");
        String nameStr = intent.getStringExtra("name");

        venue.setText(venueStr);
        date.setText(dateStr);
        name.setText(nameStr);
    }

    }
