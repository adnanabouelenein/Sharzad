package com.adnanabouelenein.sharzadcleaningcenter.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.adnanabouelenein.sharzadcleaningcenter.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private ActivityMainBinding mBinding;
    BaseProgressBar baseProgressBar = new BaseProgressBar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);
        //set progress to BaseProgressBar class ti use it any where
        baseProgressBar.setProgressBar(mBinding.loginProgress);

        //Initialize firebase database
        auth = FirebaseAuth.getInstance();
        //Initialize login button using binding view
        mBinding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(mBinding.emailEdt.getText().toString(), mBinding.passwordEdt.getText().toString());
            }
        });

    }

    private void signIn(String email, String password) {
        if (!validateForm()) {
            return;
        }
        baseProgressBar.showProgressBar();

        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = auth.getCurrentUser();
                            updateUI(user);
                        } else {
                            Toast.makeText(MainActivity.this, "Authentication is failed", Toast.LENGTH_LONG).show();
                        }
                        baseProgressBar.hideProgressBar();
                    }
                });

    }

    private void updateUI(FirebaseUser user) {
        baseProgressBar.hideProgressBar();

        if (user != null) {
            Intent serviceIntent = new Intent(MainActivity.this, ServicesMenu.class);
            startActivity(serviceIntent);
            finish();
        } else {
            Toast.makeText(baseProgressBar, "Check email or password", Toast.LENGTH_SHORT).show();
        }

    }


    //validateForm method checks email and password fields is empty or not
    private boolean validateForm() {
        boolean valid = true;

        String email = mBinding.emailEdt.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mBinding.emailEdt.setError("Required");
            valid = false;
        } else {
            mBinding.emailEdt.setError(null);
        }

        String password = mBinding.passwordEdt.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mBinding.passwordEdt.setError("Required");
            valid = false;
        } else {
            mBinding.passwordEdt.setError(null);
        }
        return valid;
    }


    public void moveToRegisterPage(View view) {
        Intent registerActivity = new Intent(MainActivity.this, Register.class);
        startActivity(registerActivity);
    }


    public void moveToServicePage(View view) {
        Intent intent = new Intent(MainActivity.this,ServicesMenu.class);
        startActivity(intent);
    }
}