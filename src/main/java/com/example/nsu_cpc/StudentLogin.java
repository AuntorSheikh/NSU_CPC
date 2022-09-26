package com.example.nsu_cpc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class StudentLogin extends AppCompatActivity implements View.OnClickListener {
    private EditText singinEmail, singinPassword;
    private Button LoginButton;
    private ProgressBar progressBar;
    private CheckBox rememberMe;
    private TextView signUpTextView;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);


        singinEmail = findViewById(R.id.singInEmailId);
        singinPassword = findViewById(R.id.signInPasswordID);
        LoginButton = findViewById(R.id.SingInButtonID);
        signUpTextView= findViewById(R.id.SingUpTextViewID);
        progressBar = findViewById(R.id.progressbarID);

        mAuth = FirebaseAuth.getInstance();

        LoginButton.setOnClickListener(this);
        signUpTextView.setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.SingInButtonID:
                userLogin();
                break;


            case R.id.SingUpTextViewID:
                Intent intent = new Intent(getApplicationContext(),StudentSignUp.class);
                startActivity(intent);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }


    }

    private void userLogin() {
        String email = singinEmail.getText().toString().trim();

        String password = singinPassword.getText().toString().trim();

        if (email.isEmpty()) {
            singinEmail.setError("Enter an email address");
            singinEmail.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            singinEmail.setError("Enter a valid email address");
            singinEmail.requestFocus();
            return;
        }

        //checking the validity of the password
        if (password.isEmpty()) {
            singinPassword.setError("Enter a password");
            singinPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            singinPassword.setError("Password too short !! ");
            singinPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);

                if (task.isSuccessful()){

                    Intent intent = new Intent(getApplicationContext(),StudentOptions.class);
                    intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }
                else {

                    Toast.makeText(getApplicationContext(), "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}

