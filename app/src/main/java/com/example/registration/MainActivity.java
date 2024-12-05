package com.example.registration;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailField;
    private EditText passField;
    private EditText repeatPassField;
    private Button confirm;
    private TextView info;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        emailField = findViewById(R.id.email);
        passField = findViewById(R.id.password);
        repeatPassField = findViewById(R.id.repeatPassword);
        confirm = findViewById(R.id.confirm);
        info = findViewById(R.id.info);
        res = getResources();

        String infoText = res.getString(R.string.info, "Autor: Jakub Maciaszczyk");
        info.setText(infoText);

        confirm.setOnClickListener(view -> validation());
    }

    public void validation(){
        if(!emailField.getText().toString().contains("@")){
            String infoText = res.getString(R.string.info, "Nieprawidłowy adres e-mail");
            info.setText(infoText);
        }else if(!passField.getText().toString().equals(repeatPassField.getText().toString())){
            String infoText = res.getString(R.string.info, "Hasła się różnią");
            info.setText(infoText);
        }else{
            String infoText = res.getString(R.string.info, "Witaj " + emailField.getText());
            info.setText(infoText);
        }
    }
}