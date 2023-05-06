package com.example.android_appordercoffee.GUI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android_appordercoffee.R;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {
    Button btnCon;
    TextInputEditText user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnCon = (Button)findViewById(R.id.btn_continue);
        user = findViewById(R.id.textInputEditText_UserName);
        pass = findViewById(R.id.textInputEditText_Pass);
        btnCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, InfoActivity.class);
                intent.putExtra("user", user.getText().toString());
                intent.putExtra("pass", pass.getText().toString());
                startActivity(intent);
            }
        });
    }
}