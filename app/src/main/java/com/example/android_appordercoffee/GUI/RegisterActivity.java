package com.example.android_appordercoffee.GUI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_appordercoffee.R;
public class RegisterActivity extends AppCompatActivity {
    Button ButtonClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButtonClick = (Button)findViewById(R.id.btn_regiter);
        ButtonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this, InfoActivity.class);
                startActivity(i);
            }
        });
    }
}