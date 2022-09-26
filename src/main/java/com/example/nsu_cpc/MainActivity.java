package com.example.nsu_cpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout adminButton;
    private RelativeLayout studentButton;
    private RelativeLayout companyButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentButton = findViewById(R.id.studentButtonId);
        adminButton = findViewById(R.id.adminButtonId);
        companyButton = findViewById(R.id.companyID);
        studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, StudentLogin.class);
                startActivity(intent);

            }
        });

        adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AdminLogin.class);
                startActivity(intent);

            }
        });
        companyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, CompanyLogin.class);
                startActivity(intent);

            }
        });


    }
}