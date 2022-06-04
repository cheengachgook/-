package com.example.dnevnik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Grades extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);

        Button Back = findViewById(R.id.buttonToSchedule);
        TextView Name = findViewById(R.id.textName);

        Name.setText(MainActivity.RightName);
        Intent intent = new Intent(this, Uchenik.class);
        View.OnClickListener goBack = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        };
        Back.setOnClickListener(goBack);
    }
}