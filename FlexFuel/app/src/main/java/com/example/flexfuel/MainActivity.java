package com.example.flexfuel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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


        emailTextBox = findViewById(R.id.editTextTextEmailAddress);
        passwordTextBox = findViewById(R.id.editTextTextPassword);

        logInbtn = findViewById(R.id.logIn);
        logInbtn.setOnClickListener(v -> {
            //Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            //startActivity(intent);



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