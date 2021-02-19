package com.adnanabouelenein.sharzadcleaningcenter.ui;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.adnanabouelenein.sharzadcleaningcenter.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {


    private FirebaseFirestore firestore;
    private FirebaseAuth auth;
    private ActivityRegisterBinding activityRegisterBinding;
    BaseProgressBar baseProgressBar = new BaseProgressBar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRegisterBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = activityRegisterBinding.getRoot();
        setContentView(view);
        //set progress to BaseProgressBar class ti use it any where
        baseProgressBar.setProgressBar(activityRegisterBinding.progress);

        firestore = FirebaseFirestore.getInstance();

        auth = FirebaseAuth.getInstance();

        Map<String, Object> user = new HashMap<>();


        activityRegisterBinding.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user.put("Full Name", activityRegisterBinding.name.getText().toString());
                user.put("Phone Number", activityRegisterBinding.phoneNumber.getText().toString());
                user.put("Email", activityRegisterBinding.emailEdt.getText().toString());
                user.put("Password", activityRegisterBinding.passwordEdtCo.getText().toString());
                user.put("Confirm Password", activityRegisterBinding.passwordEdtCo.getText().toString());
                user.put("Car Model", activityRegisterBinding.carModel.getText().toString());

                firestore.collection("Users").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Register.this, "Check your connection", Toast.LENGTH_SHORT).show();
                    }
                });

                String email = activityRegisterBinding.emailEdt.getText().toString().trim();
                String password = activityRegisterBinding.passwordEdt.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                baseProgressBar.showProgressBar();
                //create user
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(Register.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                baseProgressBar.hideProgressBar();
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(Register.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(Register.this, ServicesMenu.class));
                                    finish();
                                }
                            }
                        });


            }
        });


    }


}
