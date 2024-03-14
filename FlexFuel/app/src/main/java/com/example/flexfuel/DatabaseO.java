package com.example.flexfuel;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DatabaseO {

    public FirebaseAuth mAuth;

    public DatabaseO() {
        mAuth = FirebaseAuth.getInstance();
    }

    public void registerUser(Context context, String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(context, "Ya Buddy" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            // User registration successful
                            FirebaseUser user = mAuth.getCurrentUser();
                            // You can access user information here
                        } else {
                            // User registration failed
                            Toast.makeText(context, "Registration failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}