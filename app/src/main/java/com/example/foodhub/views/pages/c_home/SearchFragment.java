package com.example.foodhub.views.pages.c_home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.foodhub.R;
import com.example.foodhub.data.models.PopularItem;
import com.example.foodhub.data.models.RestaurantSearchItem;
import com.example.foodhub.views.adapters.PopularItemAdapter2;
import com.example.foodhub.views.adapters.RestaurantSearchAdapter;
import com.example.foodhub.views.helpers.SizeUtilities;

import java.util.ArrayList;


public class SearchFragment extends Fragment {

    View rootView;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_search, container, false);
        TextView t1 = rootView.findViewById(R.id.toggle_t1);
        TextView t2 = rootView.findViewById(R.id.toggle_t2);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formatToggleButtons(t1, t2);
                configureFood();
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formatToggleButtons(t2, t1);
                configureResturant();
            }
        });
        return rootView;
    }

    public void formatToggleButtons(TextView selected, TextView notSelected) {
        selected.setBackgroundResource(R.drawable.btn_bg);
        selected.setTextColor(getContext().getColor(R.color.white));
        notSelected.setBackgroundResource(R.drawable.btn_bg_5);
        notSelected.setTextColor(getContext().getColor(R.color.primary_color));
        int paddingSize = SizeUtilities.Dp2Px(getContext(), 13);
        selected.setPadding(paddingSize, paddingSize, paddingSize, paddingSize);
        notSelected.setPadding(paddingSize, paddingSize, paddingSize, paddingSize);
    }

    public void configureFood() {

        //1. Inflate RecyclerView and  create layout
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_fragment_search_r1);
        StaggeredGridLayoutManager layoutManager
                = new StaggeredGridLayoutManager(2, LinearLayoutManager.HORIZONTAL);

        // 2. set layoutManger
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<PopularItem> popularItems = new ArrayList<>();
        popularItems.add(new PopularItem("Salmon Salad", "Baked salmon fish", R.drawable.pop_1, 5.5f, 4.5f, 20));
        popularItems.add(new PopularItem("Salmon Salad", "Baked salmon fish", R.drawable.pop_1, 5.5f, 4.5f, 20));
        popularItems.add(new PopularItem("Salmon Salad", "Baked salmon fish", R.drawable.pop_2, 8.5f, 4.5f, 20));
        popularItems.add(new PopularItem("Salmon Salad", "Baked salmon fish", R.drawable.pop_1, 5.5f, 4.5f, 20));
        popularItems.add(new PopularItem("Salmon Salad", "Baked salmon fish", R.drawable.pop_2, 8.5f, 4.5f, 20));
        popularItems.add(new PopularItem("Salmon Salad", "Baked salmon fish", R.drawable.pop_1, 5.5f, 4.5f, 20));
        popularItems.add(new PopularItem("Salmon Salad", "Baked salmon fish", R.drawable.pop_2, 8.5f, 4.5f, 20));
        popularItems.add(new PopularItem("Salmon Salad", "Baked salmon fish", R.drawable.pop_1, 5.5f, 4.5f, 20));
        popularItems.add(new PopularItem("Salmon Salad", "Baked salmon fish", R.drawable.pop_2, 8.5f, 4.5f, 20));
        popularItems.add(new PopularItem("Salmon Salad", "Baked salmon fish", R.drawable.pop_1, 5.5f, 4.5f, 20));
        popularItems.add(new PopularItem("Salmon Salad", "Baked salmon fish", R.drawable.pop_2, 8.5f, 4.5f, 20));
        popularItems.add(new PopularItem("Salmon Salad", "Baked salmon fish", R.drawable.pop_1, 5.5f, 4.5f, 20));

        // 3. create an adapter
        PopularItemAdapter2 popularItemAdapter = new PopularItemAdapter2(popularItems);
        // 4. set adapter
        recyclerView.setAdapter(popularItemAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public void configureResturant() {
        //1. Inflate RecyclerView and  create layout
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_fragment_search_r1);
        StaggeredGridLayoutManager layoutManager
                = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);

        // 2. set layoutManger
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<RestaurantSearchItem> restaurantSearchItems = new ArrayList<>();
        ArrayList<String> pop = new ArrayList<>();
        pop.add("Coffe");
        restaurantSearchItems.add(new RestaurantSearchItem(R.drawable.pizza, 4.5f, 0, pop, "Pizza Hut", "10-15 mins"));
        restaurantSearchItems.add(new RestaurantSearchItem(R.drawable.starbucks, 4.5f, 0, pop, "Starbuck", "10-15 mins"));
        restaurantSearchItems.add(new RestaurantSearchItem(R.drawable.kfc, 4.5f, 0, pop, "KFC", "10-15 mins"));
        restaurantSearchItems.add(new RestaurantSearchItem(R.drawable.burger, 4.5f, 0, pop, "Burger King", "10-15 mins"));
        restaurantSearchItems.add(new RestaurantSearchItem(R.drawable.jimmy, 4.5f, 0, pop, "Jimmy John's", "10-15 mins"));
        restaurantSearchItems.add(new RestaurantSearchItem(R.drawable.starbucks, 4.5f, 0, pop, "Starbuck", "10-15 mins"));
        restaurantSearchItems.add(new RestaurantSearchItem(R.drawable.kfc, 4.5f, 0, pop, "KFC", "10-15 mins"));
        restaurantSearchItems.add(new RestaurantSearchItem(R.drawable.burger, 4.5f, 0, pop, "Burger King", "10-15 mins"));
        restaurantSearchItems.add(new RestaurantSearchItem(R.drawable.jimmy, 4.5f, 0, pop, "Jimmy John's", "10-15 mins"));
        restaurantSearchItems.add(new RestaurantSearchItem(R.drawable.pizza, 4.5f, 0, pop, "Pizza Hut", "10-15 mins"));
        restaurantSearchItems.add(new RestaurantSearchItem(R.drawable.pizza, 4.5f, 0, pop, "Pizza Hut", "10-15 mins"));

        // 3. create an adapter
        RestaurantSearchAdapter popularItemAdapter = new RestaurantSearchAdapter(restaurantSearchItems);
        // 4. set adapter
        recyclerView.setAdapter(popularItemAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }


}