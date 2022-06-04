package com.example.dnevnik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WhoAreYou extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_who_are_you);

        Button Student = findViewById(R.id.buttonStudent);
        Button Teacher = findViewById(R.id.buttonTeacher);
        Button Admin = findViewById(R.id.buttonAdmin);

        Intent intent1 = new Intent(this, Register.class);
        Intent intent2 = new Intent(this, RegisterTeacher.class);
        Intent intent3 = new Intent(this, RegisterAdmin.class);

        View.OnClickListener st = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        };
        Student.setOnClickListener(st);


        View.OnClickListener te = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        };
        Teacher.setOnClickListener(te);


        View.OnClickListener adm = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent3);
            }
        };
        Admin.setOnClickListener(adm);
    }


}