package com.example.dnevnik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    OpenHelper oph1;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Intent intent = new Intent(this, MainActivity.class);


        EditText login = findViewById(R.id.editNewLogin);
        EditText password = findViewById(R.id.editNewPassword);
        EditText surname = findViewById(R.id.editNewSur);
        EditText name = findViewById(R.id.editNewName);
        Button ButApply = findViewById(R.id.buttonApply);

        View.OnClickListener add = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String log = login.getText().toString();
                String pass = password.getText().toString();
                String nam = name.getText().toString();
                String sur = surname.getText().toString();
                int q = MainActivity.oph.Add(MainActivity.db, log, pass, nam, sur, 1);
                if (q != -1)
                {
                    Toast.makeText(getApplicationContext(),"Регистрация успешна!",Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
                else Toast.makeText(getApplicationContext(),"Пользователь с таким логином уже зарегестрирован!",Toast.LENGTH_LONG).show();
            }
        };
        ButApply.setOnClickListener(add);
    }
}