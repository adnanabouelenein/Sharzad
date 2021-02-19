package com.adnanabouelenein.sharzadcleaningcenter.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.adnanabouelenein.sharzadcleaningcenter.R;
import com.adnanabouelenein.sharzadcleaningcenter.data.infoadapter.InfoAdapter;
import com.adnanabouelenein.sharzadcleaningcenter.data.infoadapter.InfoModel;
import com.adnanabouelenein.sharzadcleaningcenter.data.serviceadapter.ServiceAdapter;
import com.adnanabouelenein.sharzadcleaningcenter.data.serviceadapter.ServiceModel;
import com.adnanabouelenein.sharzadcleaningcenter.database.DatabaseHelper;

import java.util.ArrayList;

public class ServicesMenu extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private SQLiteDatabase sqLiteDatabase;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_menu);

        databaseHelper = new DatabaseHelper(this);
        databaseHelper.getWritableDatabase();
        databaseHelper.close();


        ArrayList<ServiceModel> serviceModelArrayList = new ArrayList<>();

        serviceModelArrayList.add(new ServiceModel("Exterior & Interior", 50, R.drawable.polish_car));
        serviceModelArrayList.add(new ServiceModel("Interior Chemical",200 ,R.drawable.polish_car ));
        serviceModelArrayList.add(new ServiceModel("Rims Chemical", 25, R.drawable.polish_car));
        serviceModelArrayList.add(new ServiceModel("Engine", 25, R.drawable.polish_car));


        RecyclerView recyclerView = findViewById(R.id.rv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        ServiceAdapter serviceAdapter = new ServiceAdapter(serviceModelArrayList, this);
        recyclerView.setAdapter(serviceAdapter);


        ArrayList<InfoModel> infoModelArrayList = new ArrayList<>();

        infoModelArrayList.add(new InfoModel("Enterior", "bla bla bla bla", R.drawable.mustang_view));
        infoModelArrayList.add(new InfoModel("Exterior", "bla bla bla bla", R.drawable.mustang_view));
        infoModelArrayList.add(new InfoModel("Rims", "bla bla bla bla", R.drawable.mustang_view));

        RecyclerView recyclerView1 = findViewById(R.id.rv2);
        LinearLayoutManager manager1 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
        recyclerView1.setLayoutManager(manager1);

        InfoAdapter infoAdapter = new InfoAdapter(this, infoModelArrayList);
        recyclerView1.setAdapter(infoAdapter);


    }

    public void moveToMyServicesActivity(View view) {
        Intent myService = new Intent(ServicesMenu.this, MyServicesActivity.class);
        startActivity(myService);
    }
}