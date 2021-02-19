package com.adnanabouelenein.sharzadcleaningcenter.ui;

import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class BaseProgressBar extends AppCompatActivity {


    private ProgressBar progressBar;

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public void showProgressBar(){
        if (progressBar != null){
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    public void hideProgressBar(){
        if (progressBar != null){
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressBar();
    }

}
