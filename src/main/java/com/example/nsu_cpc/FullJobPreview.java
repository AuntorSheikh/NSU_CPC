package com.example.nsu_cpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FullJobPreview extends AppCompatActivity  {
    private TextView title;
    private TextView type;
    private TextView salary;
    private TextView deadline;
    private TextView interview;
    private TextView information;
    private TextView location;
    private TextView otherbenefit;
    private Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_job_preview);

        title= findViewById(R.id.jobTitlePreviewID);
        type = findViewById(R.id.jobtypepreviewID);
        salary = findViewById(R.id.salaryPreviewID);
        deadline = findViewById(R.id.deadlinepreviewID);
        interview = findViewById(R.id.interviewpreviewID);
        information = findViewById(R.id.jobInformationpreviewID);

        location = findViewById(R.id.jobLocationPreviewID);
        otherbenefit = findViewById(R.id.otherBenefitpreviewID);
        submit = findViewById(R.id.submitApplyID);




        String key= getIntent().getStringExtra("jobtitle");
        String key2= getIntent().getStringExtra("jobtype");
        String key3= getIntent().getStringExtra("jobsalary");
        String key4= getIntent().getStringExtra("joblocation");
        String key5= getIntent().getStringExtra("interview");
        String key6= getIntent().getStringExtra("deadline");
        String key7= getIntent().getStringExtra("information");
        String key8= getIntent().getStringExtra("otherbenefits");

        title.setText(key);
        type.setText(key2);
        salary.setText(key3);
        location.setText(key4);
        interview.setText(key5);
        deadline.setText(key6);
        information.setText(key7);
        otherbenefit.setText(key8);

        submit.setOnClickListener(v -> {

            //Intent intent = new Intent(getApplicationContext(), SendCV.class);
            //startActivity(intent);
        });

    }
}