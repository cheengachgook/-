package com.example.dnevnik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChangeStudent extends AppCompatActivity {

    public static String StrMon = "";
    public static String StrTue = "";
    public static String StrWed = "";
    public static String StrThu = "";
    public static String StrFri = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_student);

        TextView EditMonCh = findViewById(R.id.editMonCh);
        TextView EditTueCh = findViewById(R.id.editTueCh);
        TextView EditWedCh = findViewById(R.id.editWedCh);
        TextView EditThuCh = findViewById(R.id.editThuCh);
        TextView EditFriCh = findViewById(R.id.editFriCh);

        Intent intent = new Intent(this, Admin.class);

        Button ButAplCh = findViewById(R.id.ButtonApplyChanges);

        if(StrMon.equals(""))
        {} else EditMonCh.setText(StrMon);

        if(StrTue.equals(""))
        {} else EditTueCh.setText(StrTue);

        if(StrWed.equals(""))
        {} else EditWedCh.setText(StrWed);

        if(StrThu.equals(""))
        {} else EditThuCh.setText(StrThu);

        if(StrFri.equals(""))
        {} else EditFriCh.setText(StrFri);

        View.OnClickListener les_go = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StrMon = EditMonCh.getText().toString();
                StrTue = EditTueCh.getText().toString();
                StrWed = EditWedCh.getText().toString();
                StrThu = EditThuCh.getText().toString();
                StrFri = EditFriCh.getText().toString();
                startActivity(intent);
            }

        };
        ButAplCh.setOnClickListener(les_go);
    }
}