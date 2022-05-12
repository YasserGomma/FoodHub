package com.example.foodhub.views.pages.c_home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;
import com.example.foodhub.data.models.PopularItem;
import com.example.foodhub.views.adapters.PopularItemAdapter;

import java.util.ArrayList;

public class FoodFilterFragment extends Fragment {


    public FoodFilterFragment() {
        // Required empty public constructor
    }


    public static FoodFilterFragment newInstance(String param1, String param2) {
        FoodFilterFragment fragment = new FoodFilterFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((Home) getActivity()).hide_footer();

        View rootView = inflater.inflate(R.layout.fragment_food_filter, container, false);
        Button btn=rootView.findViewById(R.id.btn_fragment_home_filter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new FoodFilterFragment(), R.id.fram_home_fragment);

            }
        });
        RecyclerView recyclerView3 = (RecyclerView) rootView.findViewById(R.id.rv_food_filter);
        LinearLayoutManager layoutManager3
                = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);

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