package com.example.dnevnik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChangeTeacher extends AppCompatActivity {

    public static String StrMonT = "";
    public static String StrTueT = "";
    public static String StrWedT = "";
    public static String StrThuT = "";
    public static String StrFriT = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_teacher);

        TextView EditMonChT = findViewById(R.id.editMonChT);
        TextView EditTueChT = findViewById(R.id.editTueChT);
        TextView EditWedChT = findViewById(R.id.editWedChT);
        TextView EditThuChT = findViewById(R.id.editThuChT);
        TextView EditFriChT = findViewById(R.id.editFriChT);

        Intent intent = new Intent(this, Admin.class);

        Button ButAplCh = findViewById(R.id.ButtonApplyChanges);

        if(StrMonT.equals(""))
        {} else EditMonChT.setText(StrMonT);

        if(StrTueT.equals(""))
        {} else EditTueChT.setText(StrTueT);

        if(StrWedT.equals(""))
        {} else EditWedChT.setText(StrWedT);

        if(StrThuT.equals(""))
        {} else EditThuChT.setText(StrThuT);

        if(StrFriT.equals(""))
        {} else EditFriChT.setText(StrFriT);

        View.OnClickListener les_go = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StrMonT = EditMonChT.getText().toString();
                StrTueT = EditTueChT.getText().toString();
                StrWedT = EditWedChT.getText().toString();
                StrThuT = EditThuChT.getText().toString();
                StrFriT = EditFriChT.getText().toString();
                startActivity(intent);
            }

        };
        ButAplCh.setOnClickListener(les_go);
    }
}