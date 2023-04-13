package com.example.android_appordercoffee.GUI;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_appordercoffee.R;
public class InfoActivity extends AppCompatActivity {
    Button ButtonClick;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButtonClick = (Button)findViewById(R.id.btn_Submit);
        ButtonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
    }
    public void openDialog()
    {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Save your infomation");
        builder.setMessage("Your information has changed. Do you want to save the new information?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent temp = new Intent(InfoActivity.this, HomeActivity.class);
                startActivity(temp);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }
}