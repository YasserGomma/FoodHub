package com.example.foodhub.views.pages.c_home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;
import com.example.foodhub.data.models.AddsItem;
import com.example.foodhub.views.adapters.AddsItemAdapter;

import java.util.ArrayList;


public class FoodDetailsFragment extends Fragment {



    public FoodDetailsFragment() {
        // Required empty public constructor
    }


    public static FoodDetailsFragment newInstance(String param1, String param2) {
        FoodDetailsFragment fragment = new FoodDetailsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((Home)getActivity()).hide_footer();
        View rootView = inflater.inflate(R.layout.fragment_food_details, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_food_details_rv);
        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);

        // 2. set layoutManger
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<AddsItem> addsItems = new ArrayList<>();
        addsItems.add(new AddsItem());
        addsItems.add(new AddsItem());
        addsItems.add(new AddsItem());
        addsItems.add(new AddsItem());
        addsItems.add(new AddsItem());
        addsItems.add(new AddsItem());
        addsItems.add(new AddsItem());
        addsItems.add(new AddsItem());

        // 3. create an adapter
        AddsItemAdapter addsItemAdapter = new AddsItemAdapter(addsItems);
        // 4. set adapter
        recyclerView.setAdapter(addsItemAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        return rootView;
    }

    @Override
    public void onViewCreated( View view,  Bundle savedInstanceState) {


    }
}