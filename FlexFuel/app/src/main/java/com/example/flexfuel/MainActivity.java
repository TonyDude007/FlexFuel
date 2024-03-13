package com.example.flexfuel;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Context context;
    FirebaseDatabase mAuth;
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

        mAuth = FirebaseDatabase.getInstance();

        emailTextBox = findViewById(R.id.editTextTextEmailAddress);
        passwordTextBox = findViewById(R.id.editTextTextPassword);

        logInbtn = findViewById(R.id.logIn);
        logInbtn.setOnClickListener(v -> {

            if (emailTextBox.getText().toString().isEmpty() || passwordTextBox.getText().toString().isEmpty()) {
                Toast.makeText(context,"Please Fill The Boxes", Toast.LENGTH_SHORT).show();
                // Write a message to the database

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }
                            }
                        });

            } else {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }

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