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
import com.example.foodhub.data.source.remote.Category;
import com.example.foodhub.data.source.remote.Food;
import com.example.foodhub.data.source.remote.Restaurant;
import com.example.foodhub.data.source.remote.Root;
import com.example.foodhub.interfaces.EndPoints;
import com.example.foodhub.views.adapters.CategoryItemAdapter;
import com.example.foodhub.views.adapters.FoodItemAdapter;
import com.example.foodhub.views.adapters.RestaurantProfileAdapter;
import com.example.foodhub.views.networking.RetrofitCreation;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((Home) getActivity()).show_footer();
        ((Home) getActivity()).show_header();
    }


    @Override
    public void onPause() {
        super.onPause();
        ((Home) getActivity()).hide_header();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        TextView tv_fragment_home_view = rootView.findViewById(R.id.tv_fragment_home_view);
        tv_fragment_home_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new SearchRestuantAndFoodFragment(), R.id.fram_home_fragment);
            }
        });

        Button btn = rootView.findViewById(R.id.btnfragment_home_filter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // replaceFragment(new FoodByCategoryFragment(), R.id.fram_home_fragment);
            }
        });
        setData(rootView);
        return rootView;
    }

    void setData(View rootView) {
        RecyclerView recyclerView = rootView.findViewById(R.id.rv_fragment_home_r1);
        RecyclerView recyclerView1 = rootView.findViewById(R.id.rv_fragment_home_r2);
        RecyclerView recyclerView2 = rootView.findViewById(R.id.rv_fragment_home_r3);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView2.setLayoutManager(layoutManager2);
        EndPoints Api = RetrofitCreation.getInstance();
        Call<Root> call1 = Api.home("home");
        final ArrayList<Restaurant>[] arrayList = new ArrayList[]{new ArrayList<>()};
        final ArrayList<Category>[] arrayList1 = new ArrayList[]{new ArrayList<>()};
        final ArrayList<Food>[] arrayList2 = new ArrayList[]{new ArrayList<>()};
        call1.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                arrayList[0] = response.body().restaurants;
                arrayList1[0] = response.body().categories;
                arrayList2[0] = response.body().foods;
                CategoryItemAdapter categoryItemAdapter = new CategoryItemAdapter(getContext(), getFragmentManager(), arrayList1[0]);
                recyclerView.setAdapter(categoryItemAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                RestaurantProfileAdapter restaurantProfileAdapter = new RestaurantProfileAdapter(getContext(), getFragmentManager(), arrayList[0]);
                recyclerView1.setAdapter(restaurantProfileAdapter);
                recyclerView1.setItemAnimator(new DefaultItemAnimator());
                FoodItemAdapter foodItemAdapter = new FoodItemAdapter(getContext(), getFragmentManager(), arrayList2[0]);
                recyclerView2.setAdapter(foodItemAdapter);
                recyclerView2.setItemAnimator(new DefaultItemAnimator());
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
            }
        });

    }

    public void replaceFragment(Fragment fragment, int frameId) {
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = getParentFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);
        if (!fragmentPopped && manager.findFragmentByTag(backStateName) == null) { //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(frameId, fragment, backStateName);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }


}