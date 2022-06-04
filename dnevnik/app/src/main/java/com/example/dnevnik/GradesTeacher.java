package com.example.dnevnik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GradesTeacher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades_teacher);

        TextView sub1 = findViewById(R.id.textViewT1);
        TextView sub2 = findViewById(R.id.textViewT2);
        TextView sub3 = findViewById(R.id.textViewT3);
        TextView sub4 = findViewById(R.id.textViewT4);
        TextView sub5 = findViewById(R.id.textViewT5);
        TextView sub6 = findViewById(R.id.textViewT6);

        Intent intent = new Intent(this, Subject1.class);

        View.OnClickListener go1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        };

    }
}