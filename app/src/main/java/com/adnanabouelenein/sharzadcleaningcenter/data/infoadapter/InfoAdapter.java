package com.adnanabouelenein.sharzadcleaningcenter.data.infoadapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adnanabouelenein.sharzadcleaningcenter.R;

import java.util.ArrayList;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.MyViewHolder> {

    private Activity activity;
    private ArrayList<InfoModel> infoModelArrayList;

    public InfoAdapter(Activity activity, ArrayList<InfoModel> infoModelArrayList) {
        this.activity = activity;
        this.infoModelArrayList = infoModelArrayList;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View v = inflater.inflate(R.layout.info_card_view,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.infoImage.setImageResource(infoModelArrayList.get(position).getImage());
        holder.title.setText(infoModelArrayList.get(position).getTitle());
        holder.info.setText(infoModelArrayList.get(position).getInfo());

    }

    @Override
    public int getItemCount() {
        return infoModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView infoImage;
        private TextView title;
        private TextView info;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            infoImage = itemView.findViewById(R.id.mustang_image);
            title = itemView.findViewById(R.id.title);
            info = itemView.findViewById(R.id.info);
        }
    }
}
