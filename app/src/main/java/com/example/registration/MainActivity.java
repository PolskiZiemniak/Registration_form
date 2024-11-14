package com.example.registration;

import android.os.Bundle;
import android.util.Log;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        emailField = findViewById(R.id.email);
        passField = findViewById(R.id.password);
        repeatPassField = findViewById(R.id.repeatPassword);
        confirm = findViewById(R.id.confirm);
        info = findViewById(R.id.info);

        confirm.setOnClickListener(view -> {
            validation();
        });

    }

    public void validation(){
        if(!emailField.getText().toString().contains("@")){
            info.setText("Nieprawidłowy adres e-mail");
        }else if(!passField.getText().toString().equals(repeatPassField.getText().toString())){
            Log.d("myTag", passField.getText().toString());
            Log.d("myTag", repeatPassField.getText().toString());
            info.setText("Hasła się różnią");
        }else{
            info.setText("Witaj " + emailField.getText());
        }
    }
}