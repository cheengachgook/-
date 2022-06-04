package com.example.dnevnik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Button butTeacher = findViewById(R.id.buttonChangeTeacher);
        Button butStudent = findViewById(R.id.buttonChangeStudent);

        Intent intent1 = new Intent(this, ChangeStudent.class);
        Intent intent2 = new Intent(this, ChangeTeacher.class);

        View.OnClickListener goStud = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        };
        butStudent.setOnClickListener(goStud);

        View.OnClickListener goTeach = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        };
        butTeacher.setOnClickListener(goTeach);

    }
}