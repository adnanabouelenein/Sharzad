package com.adnanabouelenein.sharzadcleaningcenter.data.serviceadapter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adnanabouelenein.sharzadcleaningcenter.ui.MyServicesActivity;
import com.adnanabouelenein.sharzadcleaningcenter.R;

import java.util.ArrayList;

public class  ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.MyViewHolder> {

    private ArrayList<ServiceModel> serviceModels;
    private Activity activity;
    private OnItemClick onItemClick;

    public void setOnItemClickListener(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public interface OnItemClick{
        void onItemClick(int position);
    }


    public ServiceAdapter(ArrayList<ServiceModel> serviceModels, Activity activity) {
        this.serviceModels = serviceModels;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View v = layoutInflater.inflate(R.layout.card_view_service, parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(v, onItemClick);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        /*holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myService = new Intent(activity, MyServicesActivity.class);
                myService.putExtra("ARRAYLIST",serviceModels.get(position));
                Log.d("data", "Data: " + serviceModels.get(position).getServiceName());
                activity.startActivity(myService);
            }
        });*/
        holder.serviceImage.setImageResource(serviceModels.get(position).getServiceImage());
        holder.serviceName.setText(serviceModels.get(position).getServiceName());
        holder.servicePrice.setText(Integer.toString(serviceModels.get(position).getPrice()) + " L.E");
    }

    @Override
    public int getItemCount() {
        return serviceModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView serviceImage;
        private TextView serviceName;
        private TextView servicePrice;
        private ImageButton plus;
        public MyViewHolder(@NonNull View itemView, OnItemClick listener) {
            super(itemView);

            plus = itemView.findViewById(R.id.plus_btn);
            serviceImage = itemView.findViewById(R.id.polish_img);
            serviceName = itemView.findViewById(R.id.polish_txt);
            servicePrice = itemView.findViewById(R.id.price_txt);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition());
                }
            });

        }
    }
}
