package com.example.foodhub.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;
import com.example.foodhub.data.models.RestaurantProfileItem;

import java.util.ArrayList;

public class RestaurantProfileAdapter extends RecyclerView.Adapter<RestaurantProfileAdapter.RestauranttemViewHolder> {
    ArrayList<RestaurantProfileItem> resturants = new ArrayList<>();

    public RestaurantProfileAdapter(ArrayList<RestaurantProfileItem> foods) {
        this.resturants = foods;
    }

    @Override
    public RestauranttemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_resturant_profile, null, false);
        RestauranttemViewHolder resturantItemViewHolder = new RestauranttemViewHolder(v);
        return resturantItemViewHolder;
    }


    @Override
    public void onBindViewHolder(RestauranttemViewHolder holder, int position) {

        RestaurantProfileItem item = resturants.get(position);
        holder.background.setImageResource(item.getImage());
        holder.name.setText(item.getName());
        holder.rate.setText(item.getRate() + "");
        holder.deliveryPrice.setText(item.getDeliveryPrice() + " $");
        holder.numberOfPeople.setText("( " + item.getNumberOfPeople() + " )");
        holder.deliverytime.setText(item.getDeliverytime());

    }

    @Override
    public int getItemCount() {
        return resturants.size();
    }

    class RestauranttemViewHolder extends RecyclerView.ViewHolder {

        ImageView background;
        TextView name, rate, numberOfPeople, deliveryPrice, deliverytime;


        public RestauranttemViewHolder(View itemView) {
            super(itemView);
            background = itemView.findViewById(R.id.iv_restaurant_background);
            name = itemView.findViewById(R.id.tv_restaurant_name);
            rate = itemView.findViewById(R.id.tv_restaurant_rate);
            numberOfPeople = itemView.findViewById(R.id.tv_restaurant_num_people);
            deliveryPrice = itemView.findViewById(R.id.tv_restaurant_delivery_price);
            deliverytime = itemView.findViewById(R.id.tv_restaurant_delivery_time);

        }
    }
}
