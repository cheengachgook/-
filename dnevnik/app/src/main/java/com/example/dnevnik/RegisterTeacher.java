package com.example.dnevnik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterTeacher extends AppCompatActivity {
public static String TeCode = "IamTeacheR";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_teacher);

        Intent intent = new Intent(this, MainActivity.class);

        Button ButApply = findViewById(R.id.buttonApply);
        EditText login = findViewById(R.id.editNewLogin);
        EditText password = findViewById(R.id.editNewPassword);
        EditText surname = findViewById(R.id.editNewSur);
        EditText name = findViewById(R.id.editNewName);
        EditText code = findViewById(R.id.editTeacherCode);

        View.OnClickListener add = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String log = login.getText().toString();
                String pass = password.getText().toString();
                String nam = name.getText().toString();
                String sur = surname.getText().toString();
                String CodeCheck = code.getText().toString();
                if (CodeCheck.equals(TeCode))
                {
                    int q = MainActivity.oph.Add(MainActivity.db, log, pass, nam, sur, 2);
                    if(q != -1) {
                        Toast.makeText(getApplicationContext(), "Регистрация успешна!", Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }
                    else Toast.makeText(getApplicationContext(),"Пользователь с таким логином уже зарегестрирован!",Toast.LENGTH_LONG).show();
                }
                else Toast.makeText(getApplicationContext(),"Введён неверный код!",Toast.LENGTH_LONG).show();
            }
        };
        ButApply.setOnClickListener(add);
    }
}