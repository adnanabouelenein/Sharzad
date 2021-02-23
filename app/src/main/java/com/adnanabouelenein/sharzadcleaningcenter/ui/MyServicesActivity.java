package com.adnanabouelenein.sharzadcleaningcenter.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adnanabouelenein.sharzadcleaningcenter.R;
import com.adnanabouelenein.sharzadcleaningcenter.data.serviceadapter.ServiceModel;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MyServicesActivity extends AppCompatActivity {

    private FirestoreRecyclerAdapter<ServiceModel, ServiceViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_services);

        RecyclerView recyclerView = findViewById(R.id.rv_my_services);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

        Query query = firebaseFirestore.collection("Services Requested");

        FirestoreRecyclerOptions<ServiceModel> services = new FirestoreRecyclerOptions.Builder<ServiceModel>()
                .setQuery(query, ServiceModel.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<ServiceModel, ServiceViewHolder>(services) {
            @SuppressLint("SetTextI18n")
            @Override
            protected void onBindViewHolder(ServiceViewHolder serviceViewHolder, int i, ServiceModel serviceModel) {
                serviceViewHolder.name.setText(serviceModel.getServiceName());
                serviceViewHolder.price.setText(Integer.toString(serviceModel.getPrice()));
                serviceViewHolder.img.setImageResource(serviceModel.getServiceImage());
            }

            @NonNull
            @Override
            public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_design, parent, false);
                return new ServiceViewHolder(v);
            }
        };

        recyclerView.setAdapter(adapter);

    }

    private class ServiceViewHolder extends RecyclerView.ViewHolder {

        TextView price, name;
        ImageView img;

        public ServiceViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.polish_txt);
            price = itemView.findViewById(R.id.price_txt);
            img = itemView.findViewById(R.id.polish_img);
        }


    }


    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (adapter != null) {
            adapter.startListening();
        }
    }
}