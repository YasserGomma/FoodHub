package com.example.foodhub.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodhub.R;
import com.example.foodhub.data.source.remote.Restaurant;

import java.util.ArrayList;

public class RestaurantProfileAdapter extends RecyclerView.Adapter<RestaurantProfileAdapter.RestauranttemViewHolder> {
    ArrayList<Restaurant> resturants = new ArrayList<>();
    Context context;


    public RestaurantProfileAdapter(Context context, ArrayList<Restaurant> resturants) {
        this.resturants = resturants;
        this.context = context;
    }

    @Override
    public RestauranttemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_resturant_profile, null, false);
        RestauranttemViewHolder resturantItemViewHolder = new RestauranttemViewHolder(v);
        return resturantItemViewHolder;
    }


    @Override
    public void onBindViewHolder(RestauranttemViewHolder holder, int position) {

        Restaurant item = resturants.get(position);
        holder.name.setText(item.name);
        holder.rate.setText(item.rating);
        holder.deliveryPrice.setText(item.delivery + " $");
        holder.numberOfPeople.setText("( " + item.number_of_ratings + " )");
        holder.deliverytime.setText(item.delivery_time);
        Glide.with(context)
                .load("https://direct-app.net/food/" + item.cover_photo.toString()) // image url
                .placeholder(R.drawable.ic_launcher_background) // any placeholder to load at start
                .error(R.drawable.logo)  // any image in case of error
                .centerCrop()
                .into(holder.background);  // imageview
        String tags = item.tags;
        String[] parts = { "Burger","Chicken","Fast Food"};
        String tag1 = parts[0];
        String tag2 = parts[1];
        String tag3 = parts[2];
        holder.tv_restaurant_pop1.setText(tag1);
        holder.tv_restaurant_pop2.setText(tag2);
        holder.tv_restaurant_pop3.setText(tag3);


    }

    @Override
    public int getItemCount() {
        return resturants.size();
    }

    class RestauranttemViewHolder extends RecyclerView.ViewHolder {

        ImageView background;
        TextView name, rate, numberOfPeople, deliveryPrice, deliverytime,tv_restaurant_pop1,tv_restaurant_pop2,tv_restaurant_pop3;


        public RestauranttemViewHolder(View itemView) {
            super(itemView);
            background = itemView.findViewById(R.id.iv_restaurant_background);
            name = itemView.findViewById(R.id.tv_restaurant_name);
            rate = itemView.findViewById(R.id.tv_restaurant_rate);
            numberOfPeople = itemView.findViewById(R.id.tv_restaurant_num_people);
            deliveryPrice = itemView.findViewById(R.id.tv_restaurant_delivery_price);
            deliverytime = itemView.findViewById(R.id.tv_restaurant_delivery_time);
            tv_restaurant_pop1=itemView.findViewById(R.id.tv_restaurant_pop1);
            tv_restaurant_pop2=itemView.findViewById(R.id.tv_restaurant_pop2);
            tv_restaurant_pop3=itemView.findViewById(R.id.tv_restaurant_pop3);


        }
    }
}
