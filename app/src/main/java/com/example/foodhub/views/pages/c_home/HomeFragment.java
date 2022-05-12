package com.example.foodhub.views.pages.c_home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;
import com.example.foodhub.data.models.FoodItem;
import com.example.foodhub.data.models.PopularItem;
import com.example.foodhub.data.models.RestaurantProfileItem;
import com.example.foodhub.views.adapters.FoodItemAdapter;
import com.example.foodhub.views.adapters.PopularItemAdapter;
import com.example.foodhub.views.adapters.RestaurantProfileAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        ((Home) getActivity()).show_footer();

    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        TextView tv_fragment_home_view = rootView.findViewById(R.id.tv_fragment_home_view);
        tv_fragment_home_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new SearchRestuantAndFoodFragment(), R.id.fram_home_fragment);
            }
        });

        Button btn=rootView.findViewById(R.id.btnfragment_home_filter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new FoodFilterFragment(), R.id.fram_home_fragment);

            }
        });
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
        foodItems.add(new FoodItem("Pizza", R.drawable.item));
        foodItems.add(new FoodItem("Pizza", R.drawable.item));
        foodItems.add(new FoodItem("Pizza", R.drawable.item));
        foodItems.add(new FoodItem("Pizza", R.drawable.item));
        foodItems.add(new FoodItem("Pizza", R.drawable.item));
        foodItems.add(new FoodItem("Pizza", R.drawable.item));
        //layout
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
        ArrayList<RestaurantProfileItem> restaurantItems = new ArrayList<>();
        ArrayList<String> pop = new ArrayList<>();
        pop.add("Coffee");
        restaurantItems.add(new RestaurantProfileItem(R.drawable.resturent_background, 4.5f, 25, 0, pop, "McDonald’s", "10 - 15 mins"));
        restaurantItems.add(new RestaurantProfileItem(R.drawable.resturent_background_2, 4f, 20, 2, pop, "Starbucks", "20 - 40 mins"));
        restaurantItems.add(new RestaurantProfileItem(R.drawable.resturent_background, 4.5f, 25, 0, pop, "McDonald’s", "10 - 15 mins"));
        restaurantItems.add(new RestaurantProfileItem(R.drawable.resturent_background_2, 4f, 20, 2, pop, "Starbucks", "20 - 40 mins"));
        // 3. create an adapter
        RestaurantProfileAdapter restaurantAdapter = new RestaurantProfileAdapter(restaurantItems);
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

        popularItems.add(new PopularItem("Salmon Salad", "Baked salmon fish", R.drawable.pop_1, 5.5f, 4.5f, 20));
        popularItems.add(new PopularItem("Salmon Salad", "Baked salmon fish", R.drawable.pop_2, 8.5f, 4.5f, 20));
        popularItems.add(new PopularItem("Salmon Salad", "Baked salmon fish", R.drawable.pop_1, 5.5f, 4.5f, 20));
        popularItems.add(new PopularItem("Salmon Salad", "Baked salmon fish", R.drawable.pop_2, 8.5f, 4.5f, 20));
        popularItems.add(new PopularItem("Salmon Salad", "Baked salmon fish", R.drawable.pop_1, 5.5f, 4.5f, 20));
        popularItems.add(new PopularItem("Salmon Salad", "Baked salmon fish", R.drawable.pop_2, 8.5f, 4.5f, 20));

        // 3. create an adapter
        PopularItemAdapter popularItemAdapter = new PopularItemAdapter(getContext(), getFragmentManager(), popularItems);
        // 4. set adapter
        recyclerView3.setAdapter(popularItemAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView3.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }

    public void replaceFragment(Fragment fragment, int frameId) {
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = getParentFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);
        if (!fragmentPopped && manager.findFragmentByTag(backStateName) == null) { //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(frameId, fragment, backStateName);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }


}