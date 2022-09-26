package com.example.nsu_cpc;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<DataSet2> {
    private Activity context;
    private List<DataSet2> dataSets2;

    public  CustomAdapter(Activity context, List<DataSet2> dataSets) {
        super(context, R.layout.sample_layout_2,dataSets);
        this.context = context;
        this.dataSets2 = dataSets;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.sample_layout_2,null, true);

        DataSet2 dataSet = dataSets2.get(position);


        TextView firstname = view.findViewById(R.id.FirstNameID);
        TextView lastname = view.findViewById(R.id.LastNameID);
        TextView mobile = view.findViewById(R.id.MobileID);

        TextView birthdate = view.findViewById(R.id.birthDatePickerId);
        TextView study = view.findViewById(R.id.studyTypespinnerId);

        TextView jobexp = view.findViewById(R.id.jobExpID);
        TextView acivity = view.findViewById(R.id.otherActivityID);


        firstname.setText(dataSet.getFirstName());
        lastname.setText(dataSet.getLastName());
        mobile.setText(dataSet.getMobile());
        study.setText(dataSet.getStudy());
        birthdate.setText(dataSet.getBirthDate());
        jobexp.setText(dataSet.getJobexp());
        acivity.setText(dataSet.getActivity());








        return view;
    }
}
