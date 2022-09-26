package com.example.nsu_cpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class StudentOptions extends AppCompatActivity {

    private LinearLayout studentInfo;
    private LinearLayout searchJob;
    private LinearLayout sendCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_options);


        studentInfo = findViewById(R.id.updateStudentinfoID);
        searchJob =findViewById(R.id.searchNewJobID);
        sendCV =findViewById(R.id.sendCVtoCompanyID);


        studentInfo.setOnClickListener(v -> {

             Intent intent = new Intent(getApplicationContext(), StudentProfileUpdate.class);
             startActivity(intent);

        });

        searchJob.setOnClickListener(v -> {

             Intent intent = new Intent(getApplicationContext(), AvailableJobs.class);
             startActivity(intent);

        });

        sendCV.setOnClickListener(v -> {

             //Intent intent = new Intent(getApplicationContext(), SendCV.class);
             //startActivity(intent);

        });
    }
}