package com.example.nsu_cpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class CompanyOption extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout postNewJobc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_option);
        postNewJobc =findViewById(R.id.postNewJobIDc);


        postNewJobc.setOnClickListener(v -> {

            Intent intent = new Intent(getApplicationContext(), PostJobs.class);
            startActivity(intent);

        });
    }
    @Override
    public void onClick(View v) {

    }
}