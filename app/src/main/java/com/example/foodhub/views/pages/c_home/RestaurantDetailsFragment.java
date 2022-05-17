package com.example.foodhub.views.pages.c_home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodhub.R;
import com.example.foodhub.data.source.remote.FoodSearch;
import com.example.foodhub.data.source.remote.RestaurantDetails;
import com.example.foodhub.interfaces.EndPoints;
import com.example.foodhub.views.adapters.FoodSearchAdapter;
import com.example.foodhub.views.components.ReviewFiled;
import com.example.foodhub.views.networking.RetrofitCreation;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RestaurantDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RestaurantDetailsFragment extends Fragment {


    public RestaurantDetailsFragment() {
        // Required empty public constructor
    }


    public static RestaurantDetailsFragment newInstance(String param1, String param2) {
        RestaurantDetailsFragment fragment = new RestaurantDetailsFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_restaurant_details, container, false);
        RecyclerView recyclerView1 = rootView.findViewById(R.id.rv_Restaurant_Details_r1);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(layoutManager1);
        ImageView iv_restaurant_details_background = rootView.findViewById(R.id.iv_restaurant_details_background);
        ImageView iv_restaurant_details_profile_pic = rootView.findViewById(R.id.iv_restaurant_details_profile_pic);
        TextView tv_restaurant_details_name = rootView.findViewById(R.id.tv_restaurant_details_name);
        TextView tv_restaurant_details_address = rootView.findViewById(R.id.tv_restaurant_details_address);
        TextView tv_restaurant_delivery_price = rootView.findViewById(R.id.tv_restaurant_delivery_price);
        TextView tv_restaurant_delivery_time = rootView.findViewById(R.id.tv_restaurant_delivery_time);
        ReviewFiled reviewFiled = rootView.findViewById(R.id.restaurant_details_review);
        TextView review_field_review = reviewFiled.findViewById(R.id.review_field_review);
        TextView review_field_people = reviewFiled.findViewById(R.id.review_field_people);
        EndPoints Api = RetrofitCreation.getInstance();

        ArrayList<FoodSearch> items = new ArrayList<>();

        Call<RestaurantDetails> call = Api.restaurantDetails("restaurant", "2");
        call.enqueue(new Callback<RestaurantDetails>() {
            @Override
            public void onResponse(Call<RestaurantDetails> call, Response<RestaurantDetails> response) {
                for (int i = 0; i < response.body().items.size(); i++)
                    items.add(response.body().items.get(i));
                Glide.with(getActivity().getBaseContext())
                        .load("https://direct-app.net/food/" + response.body().restaurant.cover_photo)// image url
                        .placeholder(R.drawable.ic_launcher_background) // any placeholder to load at start
                        .error(R.drawable.profile_pic)  // any image in case of error
                        .centerCrop()
                        .into(iv_restaurant_details_background);

                Glide.with(getActivity().getBaseContext())
                        .load("https://direct-app.net/food/" + response.body().restaurant.pic)// image url
                        .placeholder(R.drawable.ic_launcher_background) // any placeholder to load at start
                        .error(R.drawable.profile_pic)  // any image in case of error
                        .centerCrop()
                        .into(iv_restaurant_details_profile_pic);
                tv_restaurant_details_name.setText(response.body().restaurant.name);
                tv_restaurant_details_address.setText(response.body().restaurant.address);
                tv_restaurant_delivery_price.setText(response.body().restaurant.delivery);
                tv_restaurant_delivery_time.setText(response.body().restaurant.delivery_time);
                review_field_review.setText(response.body().restaurant.rating);
                review_field_people.setText("( " + response.body().restaurant.number_of_ratings + " )");
                FoodSearchAdapter foodSearchAdapter = new FoodSearchAdapter(getContext(), getFragmentManager(), items);
                recyclerView1.setAdapter(foodSearchAdapter);
                recyclerView1.setItemAnimator(new DefaultItemAnimator());

            }

            @Override
            public void onFailure(Call<RestaurantDetails> call, Throwable t) {

            }
        });

        return rootView;
    }

}