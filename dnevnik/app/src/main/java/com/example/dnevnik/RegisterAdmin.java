package com.example.dnevnik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterAdmin extends AppCompatActivity {
    public static String AdCode = "AdminIAM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_admin);
        Intent intent = new Intent(this, MainActivity.class);

        Button ButApply = findViewById(R.id.buttonApplyA);
        EditText login = findViewById(R.id.editNewLoginA);
        EditText password = findViewById(R.id.editNewPasswordA);
        EditText surname = findViewById(R.id.editNewSurA);
        EditText name = findViewById(R.id.editNewNameA);
        EditText code = findViewById(R.id.editAdminCode);

        View.OnClickListener add = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String log = login.getText().toString();
                String pass = password.getText().toString();
                String nam = name.getText().toString();
                String sur = surname.getText().toString();
                String CodeCheck = code.getText().toString();
                if (CodeCheck.equals(AdCode))
                {
                    int q = MainActivity.oph.Add(MainActivity.db, log, pass, nam, sur, 3);
                    if(q != -1) {
                        Toast.makeText(getApplicationContext(), "Регистрация успешна!", Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    } else Toast.makeText(getApplicationContext(),"Пользователь с таким логином уже зарегистрирован!",Toast.LENGTH_LONG).show();
                }
                else Toast.makeText(getApplicationContext(),"Введён неверный код!",Toast.LENGTH_LONG).show();
            }
        };
        ButApply.setOnClickListener(add);


    }
}