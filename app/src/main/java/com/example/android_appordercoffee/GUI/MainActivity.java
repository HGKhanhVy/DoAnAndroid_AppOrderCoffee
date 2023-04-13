package com.example.android_appordercoffee.GUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.android_appordercoffee.R;

public class MainActivity extends AppCompatActivity {
    private ImageView icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        icon = findViewById(R.id.img_coffee);
        icon.setBackgroundColor(getResources().getColor(android.R.color.transparent));
    }
}