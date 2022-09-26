package com.example.nsu_cpc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.Dataset;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class   AvailableJobs extends AppCompatActivity {


    private  TextView nameTextView;
    private ListView listView;
    SearchView mySearchView;
    DatabaseReference databaseReference;

    private List<DataSet> dataSets;
    private  CustomerAdapter CustomerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_jobs);

        databaseReference = FirebaseDatabase.getInstance().getReference("JOBS");
        dataSets= new ArrayList<>();
        CustomerAdapter = new CustomerAdapter(AvailableJobs.this,dataSets);

        nameTextView = findViewById(R.id.studentNameID);

        mySearchView = (SearchView)findViewById(R.id.searchView);
        listView = findViewById(R.id.listviewID);
        listView.setAdapter(CustomerAdapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {

            String key = ((TextView) view.findViewById(R.id.showJobTitleID)).getText().toString();
            String key2 = ((TextView) view.findViewById(R.id.jobtypeID)).getText().toString();
            String key3 = ((TextView) view.findViewById(R.id.locationViewID)).getText().toString();
            String key4 = ((TextView) view.findViewById(R.id.salaryViewID)).getText().toString();
            String key5 = ((TextView) view.findViewById(R.id.deadlineViewID)).getText().toString();
            String key6 = ((TextView) view.findViewById(R.id.interviewpreviewID)).getText().toString();
            String key7 = ((TextView) view.findViewById(R.id.jobInformationpreviewID)).getText().toString();
            String key8 = ((TextView) view.findViewById(R.id.otherBenefitpreviewID)).getText().toString();




            Toast.makeText(getApplicationContext(),key, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AvailableJobs.this, FullJobPreview.class);
            intent.putExtra("jobtitle",key);
            intent.putExtra("jobtype",key2);
            intent.putExtra("jobsalary",key4);
            intent.putExtra("joblocation",key3);
            intent.putExtra("interview",key6);
            intent.putExtra("deadline",key5);
            intent.putExtra("information",key7);
            intent.putExtra("otherbenefits",key8);


            startActivity(intent);

        });




    }
    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataSets.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    DataSet dataSet = dataSnapshot1.getValue(DataSet.class);
//                    String myParentKey = dataSnapshot1.getKey().toString();
                    dataSets.add(dataSet);
                }
                listView.setAdapter(CustomerAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                AvailableJobs.this.CustomerAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                AvailableJobs.this.CustomerAdapter.getFilter().filter(newText);
                return false;

            }
        });
        super.onStart();
    }
}