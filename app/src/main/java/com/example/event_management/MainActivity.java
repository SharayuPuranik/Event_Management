package com.example.event_management;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;




public class MainActivity extends Activity {
    Button button;
    TextView tv;
    String st;
    EditText edittext1;
    TextView editvenue;
    RadioGroup radioGroup;
    RadioButton radioButtonOF;
    RadioButton radioButton2ON;
    Spinner Platforms;
    Button button3;
    Button button2;
    Button button4;
    Button viewlocations;
    Button venue;
    ArrayAdapter adapter;


    static final int REQUEST_CODE_MAPS = 1;
    private static final int REQUEST_CODE_CALENDAR = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Platforms = findViewById(R.id.Platforms);
        adapter = ArrayAdapter.createFromResource(this, R.array.Platforms, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Platforms.setAdapter(adapter);


        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        radioButtonOF = findViewById(R.id.radioButtonOF);
        radioButton2ON = findViewById(R.id.radioButton2ON);
        Platforms = findViewById(R.id.Platforms);
        edittext1 = findViewById(R.id.edittext1);
        radioGroup = findViewById(R.id.radioGroup);
        venue = findViewById(R.id.venue);
        button4 = findViewById(R.id.button4);
        editvenue = findViewById(R.id.editvenue);
        viewlocations = findViewById(R.id.viewlocations);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButtonOF) {
                    Platforms.setEnabled(false);
                    venue.setEnabled(true);
                } else if (checkedId == R.id.radioButton2ON) {
                    Platforms.setEnabled(true);
                    venue.setEnabled(false);
                }
            }
        });
        CalendarView calendarView = findViewById(R.id.calendarView);

        tv = findViewById(R.id.textView5);


        Calendar calendar = Calendar.getInstance();
    calendar.set(2023, Calendar.APRIL, 8);
        long milliTime = calendar.getTimeInMillis();
        calendarView.setDate(milliTime, false, true);

// Set the OnDateChangeListener for the CalendarView widget
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
// Update the TextView widget with the selected date
                String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                tv.setText(selectedDate);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Profile.class);
                intent.putExtra("venue", editvenue.getText().toString());
                intent.putExtra("date", tv.getText().toString());
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, Profile.class);
                startActivity(intent);
            }
        });
        viewlocations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, Venue1.class);
                startActivity(intent);
            }
        });
        button = findViewById(R.id.button);
        venue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivityForResult(intent, REQUEST_CODE_MAPS);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Event Created", Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Profile.class);
                intent.putExtra("venue", editvenue.getText().toString());
                intent.putExtra("date", tv.getText().toString());
                intent.putExtra("name", edittext1.getText().toString());
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_MAPS && resultCode == Activity.RESULT_OK) {
            String markerTitle = data.getStringExtra("markerTitle");
            editvenue.setText(markerTitle);
        }
    }
}



