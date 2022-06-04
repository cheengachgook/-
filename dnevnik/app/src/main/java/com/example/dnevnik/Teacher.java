package com.example.dnevnik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Teacher extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        TextView EditMonT = findViewById(R.id.editMonT);
        TextView EditTueT = findViewById(R.id.editTueT);
        TextView EditWedT = findViewById(R.id.editWedT);
        TextView EditThuT = findViewById(R.id.editThuT);
        TextView EditFriT = findViewById(R.id.editFriT);
        Button ButGr = findViewById(R.id.ButtonGrades);


        if(ChangeTeacher.StrMonT.equals(""))
        {} else EditMonT.setText(ChangeTeacher.StrMonT);

        if(ChangeTeacher.StrTueT.equals(""))
        {} else EditTueT.setText(ChangeTeacher.StrTueT);

        if(ChangeTeacher.StrWedT.equals(""))
        {} else EditWedT.setText(ChangeTeacher.StrWedT);

        if(ChangeTeacher.StrThuT.equals(""))
        {} else EditThuT.setText(ChangeTeacher.StrThuT);

        if(ChangeTeacher.StrFriT.equals(""))
        {} else EditFriT.setText(ChangeTeacher.StrFriT);
        Button butGr = findViewById(R.id.ButtonGradesT);

        Intent intent = new Intent(this, GradesTeacher.class);

        View.OnClickListener go = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        };
        butGr.setOnClickListener(go);
    }
}