package com.example.dnevnik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Uchenik extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uchenik);

        TextView EditMon = findViewById(R.id.editMon);
        TextView EditTue = findViewById(R.id.editTue);
        TextView EditWed = findViewById(R.id.editWed);
        TextView EditThu = findViewById(R.id.editThu);
        TextView EditFri = findViewById(R.id.editFri);
        Button ButGr = findViewById(R.id.ButtonGrades);

        Intent intent = new Intent(this, Grades.class);

        if(ChangeStudent.StrMon.equals(""))
        {} else EditMon.setText(ChangeStudent.StrMon);

        if(ChangeStudent.StrTue.equals(""))
        {} else EditTue.setText(ChangeStudent.StrTue);

        if(ChangeStudent.StrWed.equals(""))
        {} else EditWed.setText(ChangeStudent.StrWed);

        if(ChangeStudent.StrThu.equals(""))
        {} else EditThu.setText(ChangeStudent.StrThu);

        if(ChangeStudent.StrFri.equals(""))
        {} else EditFri.setText(ChangeStudent.StrFri);

        View.OnClickListener grades = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(intent);
            }
        };

        ButGr.setOnClickListener(grades);
    }
}