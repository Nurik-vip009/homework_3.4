package com.example.h_w4application;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContinentAdapter extends RecyclerView.Adapter<ContinentAdapter.ContinentViewHolder> {

    private ArrayList<Continent> continentList;
    private OnItemClickListener onItemClickListener;

    public ContinentAdapter(ArrayList<Continent> continentList, OnItemClickListener onItemClickListener) {
        this.continentList = continentList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ContinentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContinentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_continent,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentViewHolder holder, int position) {
        holder.bind(continentList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return continentList.size();
    }

    public class ContinentViewHolder extends RecyclerView.ViewHolder {

        private TextView tvContinent;
        public ContinentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContinent = itemView.findViewById(R.id.tv_continent_name);
        }
        public void bind(Continent continent){
            tvContinent.setText(continent.getName());
        }
    }
}
