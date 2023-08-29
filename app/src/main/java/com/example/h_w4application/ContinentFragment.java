package com.example.h_w4application;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.h_w4application.databinding.FragmentContinentBinding;

import java.util.ArrayList;

public class ContinentFragment extends Fragment implements OnItemClickListener {

    private FragmentContinentBinding binding;
    private ContinentAdapter adapter;
    private ArrayList<Continent> continentList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentContinentBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        adapter = new ContinentAdapter(continentList,this);
        binding.rvContinent.setAdapter(adapter);
    }

    private void loadData() {
        continentList.add(new Continent("Северная Америка"));
        continentList.add(new Continent("Южная Америка"));
        continentList.add(new Continent("Евразия"));
        continentList.add(new Continent("Африка"));
        continentList.add(new Continent("Австралия"));
    }


    @Override
    public void onItemClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("nurislam", position);

        CountryFragment countryFragment = new CountryFragment();
        countryFragment.setArguments(bundle);

        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, countryFragment).addToBackStack(null).commit();


    }
}