package com.example.nsu_cpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class CompanySignUp extends AppCompatActivity implements View.OnClickListener {
    private EditText SignUpEmailText, SignUpPasswordText;
    private TextView SignInTextView;
    private Button SignUpButton;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_sign_up);

        SignUpEmailText = findViewById(R.id.SignUpEmailText);
        SignUpPasswordText = findViewById(R.id.SignUpPasswordID);
        SignUpButton = findViewById(R.id.signUpButton);
        SignInTextView = findViewById(R.id.signInTextViewID);
        progressBar = findViewById(R.id.progressbarID);

        mAuth = FirebaseAuth.getInstance();

        SignInTextView.setOnClickListener(this);
        SignUpButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUpButton:
                userRegister();
                break;

            case R.id.signInTextViewID:
                Intent intent = new Intent(getApplicationContext(),StudentLogin.class);
                startActivity(intent);
                break;
        }
    }

    private void userRegister(){
        String email = SignUpEmailText.getText().toString().trim();

        String password = SignUpPasswordText.getText().toString().trim();

        if (email.isEmpty()) {
            SignUpEmailText.setError("Enter an email address");
            SignUpEmailText.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            SignUpEmailText.setError("Enter a valid email address");
            SignUpEmailText.requestFocus();
            return;
        }

        //checking the validity of the password
        if (password.isEmpty()) {
            SignUpPasswordText.setError("Enter a password");
            SignUpPasswordText.requestFocus();
            return;
        }

        if (password.length() < 6) {
            SignUpPasswordText.setError("Password too short !! Length Must be 6 ");
            SignUpPasswordText.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);



        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
            progressBar.setVisibility(View.GONE);
            if (task.isSuccessful()) {
                Toast.makeText(getApplicationContext(), "Sign Up Successful.", Toast.LENGTH_SHORT).show();

            }else{
                if (task.getException() instanceof FirebaseAuthUserCollisionException){
                    Toast.makeText(getApplicationContext(), "E-mail is already Register", Toast.LENGTH_SHORT).show();

                }
                else {

                    Toast.makeText(getApplicationContext(),"Error : " +task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }

            }

        });


    }
}