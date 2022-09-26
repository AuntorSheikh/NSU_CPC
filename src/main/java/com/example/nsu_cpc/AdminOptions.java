package com.example.nsu_cpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class AdminOptions extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout studentInfo;
    private LinearLayout postNewJob;
    private LinearLayout editJobs;
    private LinearLayout sendCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_options);


        studentInfo = findViewById(R.id.addStudentinfoID);
        postNewJob =findViewById(R.id.postNewJobID);
        editJobs = findViewById(R.id.editJobPostID);
        sendCV =findViewById(R.id.sendCVtoCompanyID);

        studentInfo.setOnClickListener(v -> {

           // Intent intent = new Intent(getApplicationContext(), addStudentInfo.class);
           /// startActivity(intent);

        });

        postNewJob.setOnClickListener(v -> {

            Intent intent = new Intent(getApplicationContext(), PostJobs.class);
            startActivity(intent);

        });



        sendCV.setOnClickListener(v -> {

            //Intent intent = new Intent(getApplicationContext(), CheckCV.class);
            //startActivity(intent);

        });



    }

    @Override
    public void onClick(View v) {

    }
}