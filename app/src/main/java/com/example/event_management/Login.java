package com.example.event_management;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
    EditText editText1;
    EditText editText2;
    Button button1;
    Button button2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);


        button1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText editText1 = findViewById(R.id.editText1);
                editText1.setText("");

                EditText editText2 = findViewById(R.id.editText2);
                editText2.setText("");
            }
        });

        button2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (editText1.getText().toString().equals("Sharayu53") &&
                        editText2.getText().toString().equals("nmims25")) {
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "Incorrect ID or password", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}


