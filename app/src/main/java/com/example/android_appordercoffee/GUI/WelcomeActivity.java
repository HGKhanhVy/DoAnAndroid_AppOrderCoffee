package com.example.android_appordercoffee.GUI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_appordercoffee.R;
public class WelcomeActivity extends AppCompatActivity {
    Button ButtonClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButtonClick = (Button)findViewById(R.id.btn_start);
        ButtonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent i = new Intent(WelcomeActivity.this, LoginActivity.class);
               //startActivity(i);

                Intent intent = new Intent(WelcomeActivity.this,chitiethoadon.class);
                startActivity(intent);
            }
        });
    }
}