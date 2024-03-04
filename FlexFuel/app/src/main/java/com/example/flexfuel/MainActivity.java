package com.example.flexfuel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Context context;
    ImageView logoImageView;
    EditText emailTextBox;
    EditText passwordTextBox;
    Button logInbtn;
    Button signUpbtn;
    TextView forgotPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        context = this;

        logoImageView = findViewById(R.id.imageView);
        Picasso.get().load(R.drawable.logo).into(logoImageView);

        emailTextBox = findViewById(R.id.editTextTextEmailAddress);
        passwordTextBox = findViewById(R.id.editTextTextPassword);

        logInbtn = findViewById(R.id.logIn);
        logInbtn.setOnClickListener(v -> {
            //Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            //startActivity(intent);

// Write a message to the database
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("message");

            myRef.setValue("Hello, World!");

        });

        signUpbtn = findViewById(R.id.signUp);
        signUpbtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        });

        forgotPassword = findViewById(R.id.forgotPass);
        forgotPassword.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });
    }

}