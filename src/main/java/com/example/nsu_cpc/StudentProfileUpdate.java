package com.example.nsu_cpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentProfileUpdate extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText FirstName;
    private EditText LastName;
    private EditText Adress;
    private EditText Mobile;
    private EditText OtherAvtivity;
    private EditText JobExp;

    private Spinner study;
    private DatePicker Birthdate;

    private Button update;

    DatabaseReference databaseReference;


    String[] Studies = { "Undergraduate", "Graduate", "Post-Graduate"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile_update);


        FirstName = findViewById(R.id.FirstNameID);
        LastName = findViewById(R.id.LastNameID);
        Adress = findViewById(R.id.adressID);
        Mobile = findViewById(R.id.MobileID);
        OtherAvtivity = findViewById(R.id.otherActivityID);
        JobExp = findViewById(R.id.jobExpID);
        Birthdate = findViewById(R.id.birthDatePickerId);
        study= findViewById(R.id.studyTypespinnerId);
        update= findViewById(R.id.updateProID);

        study.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter ab = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Studies);
        ab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        study.setAdapter(ab);


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Fname= FirstName.getText().toString();
                String Lname = LastName.getText().toString();
                String Mobiles = Mobile.getText().toString();
                String spinnervalue = study.getSelectedItem().toString();
                String Address = Adress.getText().toString();
                String JobExperience = JobExp.getText().toString();
                String Otheractivities = OtherAvtivity.getText().toString();



                StringBuilder stringBuilder = new StringBuilder();

                stringBuilder.append(Birthdate.getDayOfMonth()+"/");
                stringBuilder.append(Birthdate.getMonth()+"/");
                stringBuilder.append(Birthdate.getYear());

                String Birthdate= stringBuilder.toString();


                databaseReference = FirebaseDatabase.getInstance().getReference("Student");


                String Uniqekey = databaseReference.push().getKey();
                //  String jobTitle, String jobtype, String location, String salary, String deadline, String interviewdate, String jobinformation, String otherbenefits, String uniqekey

                DataSet2 dataSet = new DataSet2(Fname,Lname,Mobiles,spinnervalue, Address,Birthdate,JobExperience,Otheractivities,Uniqekey );
                databaseReference.child(Uniqekey).setValue(dataSet);

                Intent intent = new Intent(getApplicationContext(), StudentOptions.class);
                startActivity(intent);


            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),Studies[position] , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    String DeadlineDATE(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CurrentDate: ");
        stringBuilder.append(Birthdate.getDayOfMonth()+"/");
        stringBuilder.append(Birthdate.getMonth()+"/");
        stringBuilder.append(Birthdate.getYear());

        return stringBuilder.toString();
    }


}