package com.example.foodhub.views.pages.c_home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;
import com.example.foodhub.data.source.remote.FoodDetails;
import com.example.foodhub.interfaces.EndPoints;
import com.example.foodhub.views.adapters.CategoryItemAdapter;
import com.example.foodhub.views.adapters.FoodByCategoryIdAdapter;
import com.example.foodhub.views.networking.RetrofitCreation;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodByCategoryFragment extends Fragment {


    public FoodByCategoryFragment() {
        // Required empty public constructor
    }


    public static FoodByCategoryFragment newInstance(String param1, String param2) {
        FoodByCategoryFragment fragment = new FoodByCategoryFragment();

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

        View rootView = inflater.inflate(R.layout.fragment_food_by_cat_id, container, false);
        Button btn = rootView.findViewById(R.id.btn_fragment_home_filter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new FoodByCategoryFragment(), R.id.fram_home_fragment);

            }
        });
        setData(rootView);


        return rootView;
    }

    void setData(View rootView) {

        RecyclerView recyclerView = rootView.findViewById(R.id.rv_food_filter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        EndPoints Api = RetrofitCreation.getInstance();
        Call<ArrayList<FoodDetails>> call = Api.foodByCategoryId("foods", CategoryItemAdapter.category_id_CI_adapter);
        final ArrayList<FoodDetails>[] arrayList = new ArrayList[]{new ArrayList<>()};

        call.enqueue(new Callback<ArrayList<FoodDetails>>() {
            @Override
            public void onResponse(Call<ArrayList<FoodDetails>> call, Response<ArrayList<FoodDetails>> response) {
                arrayList[0] = response.body();
                FoodByCategoryIdAdapter foodByCategoryIdAdapter = new FoodByCategoryIdAdapter(getContext(), getFragmentManager(), arrayList[0]);
                recyclerView.setAdapter(foodByCategoryIdAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                TextView cnt = rootView.findViewById(R.id.food_filter_t3);
                cnt.setText(response.body().size() + "  type of " + CategoryItemAdapter.category_name_CI_adapter);

            }

            @Override
            public void onFailure(Call<ArrayList<FoodDetails>> call, Throwable t) {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG).show();
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
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }
}