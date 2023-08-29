package com.example.h_w4application;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private ArrayList<Country> countryList;
    private OnItemClickListener onItemClickListener;

    public CountryAdapter(ArrayList<Country> countryList){
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CountryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.bind(countryList.get(position));
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCountryName;
        private TextView tvCountryCapital;
        private ImageView ivFlag;


        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCountryName = itemView.findViewById(R.id.tv_country_name);
            tvCountryCapital = itemView.findViewById(R.id.tv_country_capital);
            ivFlag = itemView.findViewById(R.id.iv_flag);
        }
        public void bind(Country country){
            tvCountryName.setText(country.getName());
            tvCountryCapital.setText(country.getCapital());
            Glide.with(ivFlag).load(country.getFlag()).into(ivFlag);
        }
    }
}
