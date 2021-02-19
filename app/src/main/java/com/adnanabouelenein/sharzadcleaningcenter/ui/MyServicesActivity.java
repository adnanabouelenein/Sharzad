package com.adnanabouelenein.sharzadcleaningcenter.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.adnanabouelenein.sharzadcleaningcenter.R;


import java.util.ArrayList;

public class MyServicesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_services);


    }
}




//        Intent intent = getIntent();
//       ServiceModel serviceModel =  intent.getParcelableExtra("ARRAYLIST");
//
//        try {
//            Log.d("data", serviceModel.getServiceName());
//            RecyclerView recyclerView = findViewById(R.id.rv_my_services);
//            LinearLayoutManager manager  = new LinearLayoutManager(this);
//            recyclerView.setLayoutManager(manager);
//
////            MyServiceAdapter myServiceAdapter = new MyServiceAdapter(this, serviceModel);
////            recyclerView.setAdapter(myServiceAdapter);
//        }catch (NullPointerException e){
//            Log.d("data", e.getMessage());
//        }
//
//
//        try {
//
//        } catch (NullPointerException e) {
//            Log.e("Null", e.getMessage());
//        }