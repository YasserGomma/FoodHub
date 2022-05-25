package com.example.foodhub.views.pages.c_home;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.example.foodhub.R;
import com.example.foodhub.data.source.remote.FoodSearch;
import com.example.foodhub.data.source.remote.RestaurantSearch;
import com.example.foodhub.interfaces.EndPoints;
import com.example.foodhub.views.adapters.FoodSearchItemAdapter;
import com.example.foodhub.views.adapters.RestaurantSearchAdapter;
import com.example.foodhub.views.components.HeaderBar;
import com.example.foodhub.views.helpers.SizeUtilities;
import com.example.foodhub.views.networking.RetrofitCreation;
import com.example.foodhub.views.pages.b_account.Login;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchRestuantAndFoodFragment extends Fragment {

    View rootView;
    int flag = 0;

    public SearchRestuantAndFoodFragment() {
        // Required empty public constructor
    }


    public static SearchRestuantAndFoodFragment newInstance(String param1, String param2) {
        SearchRestuantAndFoodFragment fragment = new SearchRestuantAndFoodFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_search_restuant_and_food, container, false);


        HeaderBar header = rootView.findViewById(R.id.header_cart);
        ImageView header_iv = header.findViewById(R.id.header_img);
        Glide.with(getContext())
                .load("https://direct-app.net/food/" + Login.user.getPic()) // image url
                .placeholder(R.drawable.ic_launcher_background) // any placeholder to load at start
                .error(R.drawable.profile_pic)  // any image in case of error
                .centerCrop()
                .into(header_iv);

        TextView t1 = rootView.findViewById(R.id.toggle_t1);
        TextView t2 = rootView.findViewById(R.id.toggle_t2);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag++;
                formatToggleButtons(t1, t2);
            }
        });

        //TextView t2 = rootView.findViewById(R.id.toggle_t2);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag++;
                formatToggleButtons(t2, t1);
            }
        });


        EditText search = rootView.findViewById(R.id.search_food_restaurant);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    if (flag % 2 != 1) {
                        configureFood(charSequence.toString());
                    } else {
                        configureRestaurant(charSequence.toString());
                    }
                } else {
                    RecyclerView recyclerView = rootView.findViewById(R.id.rv_fragment_search_r1);
                    StaggeredGridLayoutManager layoutManager
                            = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(layoutManager);
                    ArrayList<FoodSearch> foodSearches = new ArrayList<>();
                    FoodSearchItemAdapter popularItemAdapter = new FoodSearchItemAdapter(getContext(), foodSearches);
                    recyclerView.setAdapter(popularItemAdapter);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    popularItemAdapter.notifyDataSetChanged();


                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        Button t1 = view.findViewById(R.id.btnfragment_home_filter);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

    public void formatToggleButtons(TextView selected, TextView notSelected) {
        selected.setBackgroundResource(R.drawable.btn_bg);
        selected.setTextColor(getContext().getColor(R.color.white));
        notSelected.setBackgroundResource(R.drawable.btn_bg_5);
        notSelected.setTextColor(getContext().getColor(R.color.primary_color));
        int paddingSize = SizeUtilities.Dp2Px(getContext(), 13);
        selected.setPadding(paddingSize, paddingSize, paddingSize, paddingSize);
        notSelected.setPadding(paddingSize, paddingSize, paddingSize, paddingSize);
    }

    public void configureFood(String key) {

        RecyclerView recyclerView = rootView.findViewById(R.id.rv_fragment_search_r1);
        StaggeredGridLayoutManager layoutManager
                = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<FoodSearch> foodSearches = new ArrayList<>();

        EndPoints Api = RetrofitCreation.getInstance();
        Call<ArrayList<FoodSearch>> call1 = Api.foodSearch("search_food", key);
        call1.enqueue(new Callback<ArrayList<FoodSearch>>() {
            @Override
            public void onResponse(Call<ArrayList<FoodSearch>> call, Response<ArrayList<FoodSearch>> response) {
                for (int i = 0; i < response.body().size(); i++) {
                    foodSearches.add(response.body().get(i));
                    if (i == 0)
                        foodSearches.add(response.body().get(i));
                }
                if (foodSearches.size() > 0) {
                    FoodSearchItemAdapter popularItemAdapter = new FoodSearchItemAdapter(getContext(), foodSearches);
                    recyclerView.setAdapter(popularItemAdapter);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    popularItemAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<ArrayList<FoodSearch>> call, Throwable t) {

            }
        });

    }

    public void configureRestaurant(String key) {
        RecyclerView recyclerView = rootView.findViewById(R.id.rv_fragment_search_r1);
        StaggeredGridLayoutManager layoutManager
                = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<RestaurantSearch> restaurantSearchItems = new ArrayList<>();


        EndPoints Api = RetrofitCreation.getInstance();
        Call<ArrayList<RestaurantSearch>> call1 = Api.restaurantSearch("search_restaurant", key);
        call1.enqueue(new Callback<ArrayList<RestaurantSearch>>() {
            @Override
            public void onResponse(Call<ArrayList<RestaurantSearch>> call, Response<ArrayList<RestaurantSearch>> response) {
                for (int i = 0; i < response.body().size(); i++) {
                    restaurantSearchItems.add(response.body().get(i));
                    if (i == 0)
                        restaurantSearchItems.add(response.body().get(i));
                }
                if (restaurantSearchItems.size() > 0) {
                    RestaurantSearchAdapter popularItemAdapter = new RestaurantSearchAdapter(getContext(), restaurantSearchItems);
                    recyclerView.setAdapter(popularItemAdapter);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    popularItemAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<ArrayList<RestaurantSearch>> call, Throwable t) {

            }
        });

    }

}