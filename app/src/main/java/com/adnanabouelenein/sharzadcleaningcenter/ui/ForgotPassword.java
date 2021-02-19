package com.adnanabouelenein.sharzadcleaningcenter.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.adnanabouelenein.sharzadcleaningcenter.databinding.ActivityForgotPasswordBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    private ActivityForgotPasswordBinding mBinding;
    private FirebaseAuth auth;
    BaseProgressBar baseProgressBar = new BaseProgressBar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);
        baseProgressBar.setProgressBar(mBinding.progress);

        auth = FirebaseAuth.getInstance();

        mBinding.sendVerifyCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mBinding.emailEdt.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplication(), "Enter your registered email id", Toast.LENGTH_SHORT).show();
                    return;
                }

                baseProgressBar.showProgressBar();
                auth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ForgotPassword.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(ForgotPassword.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                                }

                                baseProgressBar.hideProgressBar();
                            }
                        });
            }
        });
    }
}