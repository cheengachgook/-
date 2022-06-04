package com.example.dnevnik;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
public static OpenHelper oph;
public static SQLiteDatabase db;
public static String RightName;
public static String RightPassword;
public static String testing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText login = findViewById(R.id.LoginIn);
        EditText password = findViewById(R.id.PassIn);
        Button ButGo = findViewById(R.id.ButtonGo);
        Button ButRegGo = findViewById(R.id.buttonRegGo);
        //OpenHelper oph= new OpenHelper(getApplicationContext());

        oph = new OpenHelper(this);
        db = oph.getWritableDatabase();

        Intent intent1 = new Intent(this, Uchenik.class);
        Intent intent2 = new Intent(this, Teacher.class);
        Intent intent3 = new Intent(this, Admin.class);
        Intent intent4 = new Intent(this, WhoAreYou.class);



        View.OnClickListener go = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String log = login.getText().toString();
            String pass = password.getText().toString();
            int check = oph.Search(db, log, pass);
            if(check == -1)
                Toast.makeText(getApplicationContext(),"Неверный логин или пароль!",Toast.LENGTH_LONG).show();
            else if(check == 1) {
                RightName = oph.GetName(db);
                RightPassword = password.getText().toString();
                startActivity(intent1);
            }
            else if(check == 2) {
                RightName = oph.GetName(db);
                RightPassword = password.getText().toString();
                startActivity(intent2);
            }
            else if(check == 3) {
                RightName = oph.GetName(db);
                RightPassword = password.getText().toString();
                startActivity(intent3);
            }
            }


        };
        ButGo.setOnClickListener(go);

        View.OnClickListener add = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent4);
                }

        };
        ButRegGo.setOnClickListener(add);


    }

}