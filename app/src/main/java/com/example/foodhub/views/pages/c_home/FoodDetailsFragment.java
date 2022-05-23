package com.example.foodhub.views.pages.c_home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodhub.R;
import com.example.foodhub.data.source.remote.FoodDetails;
import com.example.foodhub.data.test_data.AddsItem;
import com.example.foodhub.interfaces.EndPoints;
import com.example.foodhub.views.adapters.AddsItemAdapter;
import com.example.foodhub.views.adapters.PopularItemAdapter;
import com.example.foodhub.views.components.AddDeletItem;
import com.example.foodhub.views.components.ReviewFiled;
import com.example.foodhub.views.networking.RetrofitCreation;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
        ((Home) getActivity()).hide_footer();
        View rootView = inflater.inflate(R.layout.fragment_food_details, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.rv_food_details_rv);
        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
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
        AddsItemAdapter addsItemAdapter = new AddsItemAdapter(addsItems);
        recyclerView.setAdapter(addsItemAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        ImageView iv_food_details_background = rootView.findViewById(R.id.iv_food_details_background);
        TextView tv_food_details_title = rootView.findViewById(R.id.tv_food_details_title);
        TextView tv_food_details_price = rootView.findViewById(R.id.tv_food_details_price);
        TextView tv_food_details_description = rootView.findViewById(R.id.tv_food_details_description);
        ReviewFiled reviewFiled = rootView.findViewById(R.id.review_food_details);
        TextView review_field_review = reviewFiled.findViewById(R.id.review_field_review);
        TextView review_field_people = reviewFiled.findViewById(R.id.review_field_people);

        EndPoints Api = RetrofitCreation.getInstance();
        Call<FoodDetails> call = Api.foodDetails("food", PopularItemAdapter.popular_item_id_CI_adapter);
        call.enqueue(new Callback<FoodDetails>() {
            @Override
            public void onResponse(Call<FoodDetails> call, Response<FoodDetails> response) {
                Glide.with(getActivity().getBaseContext())
                        .load("https://direct-app.net/food/" + response.body().pic)// image url
                        .placeholder(R.drawable.ic_launcher_background) // any placeholder to load at start
                        .error(R.drawable.profile_pic)  // any image in case of error
                        .centerCrop()
                        .into(iv_food_details_background);
                tv_food_details_title.setText(response.body().name);
                tv_food_details_price.setText(response.body().price);
                tv_food_details_description.setText(response.body().description);
                review_field_review.setText(response.body().rating);
                review_field_people.setText(response.body().number_of_ratings);
            }


            @Override
            public void onFailure(Call<FoodDetails> call, Throwable t) {

            }
        });


        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        AddDeletItem addDeletItem = view.findViewById(R.id.food_details_add_delete);
        ImageView add = addDeletItem.findViewById(R.id.btn_add_item);
        ImageView delete = addDeletItem.findViewById(R.id.btn_delete_item);
        TextView numOfItems = addDeletItem.findViewById(R.id.tv_item_number);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int cnt = Integer.parseInt(numOfItems.getText().toString());
                numOfItems.setText((cnt + 1) + "");
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int cnt = Integer.parseInt(numOfItems.getText().toString());
                if (cnt > 0)
                    numOfItems.setText((cnt - 1) + "");
                else
                    Toast.makeText(getContext(), "Can't delete any more", Toast.LENGTH_SHORT).show();
            }
        });


    }
}