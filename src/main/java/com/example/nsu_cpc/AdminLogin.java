package com.example.nsu_cpc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdminLogin extends AppCompatActivity implements View.OnClickListener {

    private EditText singinEmail, singinPassword;
    private Button LoginButton;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);


        singinEmail = findViewById(R.id.singInEmailId);
        singinPassword = findViewById(R.id.signInPasswordID);
        LoginButton = findViewById(R.id.SingInButtonID);
        progressBar = findViewById(R.id.progressbarID);
        mAuth = FirebaseAuth.getInstance();

        LoginButton.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.SingInButtonID:
                userLogin();
                break;


            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }


    }

    private void userLogin() {
        String email = singinEmail.getText().toString().trim();

        String password = singinPassword.getText().toString().trim();

        //Saving data Using SharedPreference.

      /*  if (rememberMe.isChecked()) {
            String emailRememberme = singinEmail.getText().toString().trim();

            String passwordRememberme = singinPassword.getText().toString().trim();
            SharedPreferences sharedPreferences = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("emailKey", emailRememberme);
            editor.putString("passwordKey", password);
            editor.apply();
        } else {
        }*/


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

        if (password.length()  < 5) {
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

                    Intent intent = new Intent(getApplicationContext(),AdminOptions.class);
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