package com.example.event_management;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class CalendarDate extends AppCompatActivity {

    Button button;
    TextView tv;
    String st;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_date);

        CalendarView calendarView = findViewById(R.id.calendarView);

        tv = findViewById(R.id.textView5);


        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.JANUARY, 1);
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

// Get a reference to the Button widget in the layout
        button = findViewById(R.id.button);

// Set the click listener for the Button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ...
                String selectedDate = tv.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("SELECTED_DATE", selectedDate);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

}
