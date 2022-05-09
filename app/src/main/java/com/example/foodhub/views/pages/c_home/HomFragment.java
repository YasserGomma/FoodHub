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
import com.example.foodhub.data.models.FoodItem;
import com.example.foodhub.data.models.PopularItem;
import com.example.foodhub.data.models.RestaurantItem;
import com.example.foodhub.views.adapters.FoodItemAdapter;
import com.example.foodhub.views.adapters.PopularItemAdapter;
import com.example.foodhub.views.adapters.RestaurantAdapter;

import java.util.ArrayList;

public class HomFragment extends Fragment {


    public HomFragment() {
        // Required empty public constructor
    }


    public static HomFragment newInstance(String param1, String param2) {
        HomFragment fragment = new HomFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hom, container, false);
        // 1. get a reference to recyclerView
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_fragment_home_r1);

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ArrayList<FoodItem> foodItems = new ArrayList<>();
        foodItems.add(new FoodItem("Pizza", R.drawable.item));
        foodItems.add(new FoodItem("Pizza", R.drawable.item));
        foodItems.add(new FoodItem("Pizza", R.drawable.item));
        foodItems.add(new FoodItem("Pizza", R.drawable.item));
        foodItems.add(new FoodItem("Pizza", R.drawable.item));
        foodItems.add(new FoodItem("Pizza", R.drawable.item));
        foodItems.add(new FoodItem("Pizza", R.drawable.item));
        foodItems.add(new FoodItem("Pizza", R.drawable.item));
        foodItems.add(new FoodItem("Pizza", R.drawable.item));
        //layoit
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        // 3. create an adapter
        FoodItemAdapter mAdapter = new FoodItemAdapter(foodItems);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        //---------------------------------------------------
        // 1. get a reference to recyclerView
        RecyclerView recyclerView2 = (RecyclerView) rootView.findViewById(R.id.rv_fragment_home_r2);
        LinearLayoutManager layoutManager2
                = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);

        // 2. set layoutManger
        recyclerView2.setLayoutManager(layoutManager2);
        ArrayList<RestaurantItem> resturantItems = new ArrayList<>();
        ArrayList<String> pop = new ArrayList<>();
        pop.add("Coffe");
        resturantItems.add(new RestaurantItem(R.drawable.resturent_background, 4.5f, 25, 0, pop, "McDonald’s", "10 - 15 mins"));
        resturantItems.add(new RestaurantItem(R.drawable.resturent_background_2, 4f, 20, 2, pop, "Starbuck ", "20 - 40 mins"));
        resturantItems.add(new RestaurantItem(R.drawable.resturent_background, 4.5f, 25, 0, pop, "McDonald’s", "10 - 15 mins"));
        resturantItems.add(new RestaurantItem(R.drawable.resturent_background_2, 4f, 20, 2, pop, "Starbuck ", "20 - 40 mins"));
        // 3. create an adapter
        RestaurantAdapter restaurantAdapter = new RestaurantAdapter(resturantItems);
        // 4. set adapter
        recyclerView2.setAdapter(restaurantAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView2.setItemAnimator(new DefaultItemAnimator());

        //---------------------------------------------------
        // 1. get a reference to recyclerView
        RecyclerView recyclerView3 = (RecyclerView) rootView.findViewById(R.id.rv_fragment_home_r3);
        LinearLayoutManager layoutManager3
                = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);

        // 2. set layoutManger
        recyclerView3.setLayoutManager(layoutManager3);
        ArrayList<PopularItem> popularItems = new ArrayList<>();

        popularItems.add(new PopularItem("Salmon Salad","Baked salmon fish",R.drawable.pop_1,5.5f,4.5f,20));
        popularItems.add(new PopularItem("Salmon Salad","Baked salmon fish",R.drawable.pop_2,8.5f,4.5f,20));
        popularItems.add(new PopularItem("Salmon Salad","Baked salmon fish",R.drawable.pop_1,5.5f,4.5f,20));
        popularItems.add(new PopularItem("Salmon Salad","Baked salmon fish",R.drawable.pop_2,8.5f,4.5f,20));

        // 3. create an adapter
        PopularItemAdapter popularItemAdapter = new PopularItemAdapter(popularItems);
        // 4. set adapter
        recyclerView3.setAdapter(popularItemAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView3.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }

}