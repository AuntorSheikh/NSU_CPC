package com.example.nsu_cpc;

import android.app.Activity;
import android.service.autofill.Dataset;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomerAdapter extends ArrayAdapter<DataSet> {
    private Activity context;
    private List<DataSet> dataSets;

    public  CustomerAdapter(Activity context, List<DataSet> dataSets) {
        super(context, R.layout.sample_layout,dataSets);
        this.context = context;
        this.dataSets = dataSets;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.sample_layout,null, true);

        DataSet dataSet = dataSets.get(position);


        TextView title = view.findViewById(R.id.showJobTitleID);
        TextView type = view.findViewById(R.id.jobtypeID);
        TextView location = view.findViewById(R.id.locationViewID);
        TextView salary = view.findViewById(R.id.salaryViewID);
        TextView deadline = view.findViewById(R.id.deadlineViewID);
        TextView interview = view.findViewById(R.id.interviewpreviewID);
        TextView info = view.findViewById(R.id.jobInformationpreviewID);
        TextView benefit = view.findViewById(R.id.otherBenefitpreviewID);




        title.setText(dataSet.getJobTitle());
        type.setText(dataSet.getJobtype());
        location.setText(dataSet.getLocation());
        salary.setText(dataSet.getSalary());
        deadline.setText(dataSet.getDeadline());
        interview.setText(dataSet.getInterviewdate());
        info.setText(dataSet.getJobinformation());
        benefit.setText(dataSet.getOtherbenefits());








        return view;
    }
}
