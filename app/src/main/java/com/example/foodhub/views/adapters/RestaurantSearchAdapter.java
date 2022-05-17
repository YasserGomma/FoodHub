package com.example.foodhub.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodhub.R;
import com.example.foodhub.data.source.remote.RestaurantSearch;

import java.util.ArrayList;

public class RestaurantSearchAdapter extends RecyclerView.Adapter<RestaurantSearchAdapter.RestauranttemViewHolder> {
    ArrayList<RestaurantSearch> items = new ArrayList<>();
    Context context;

    public RestaurantSearchAdapter(Context context, ArrayList<RestaurantSearch> items) {
        this.items = items;
        this.context = context;
    }

    @Override
    public RestauranttemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_resturant_search, null, false);
        return new RestauranttemViewHolder(v);
    }


    @Override
    public void onBindViewHolder(RestauranttemViewHolder holder, int position) {

        if (position > 0) {
            RestaurantSearch item = items.get(position);
            Glide.with(context)
                    .load("https://direct-app.net/food/" + item.cover_photo) // image url
                    .placeholder(R.drawable.ic_launcher_background) // any placeholder to load at start
                    .error(R.drawable.logo)  // any image in case of error
                    .centerCrop()
                    .into(holder.background);
            holder.name.setText(item.name);
            holder.deliveryPrice.setText(item.delivery);
            holder.deliverytime.setText(item.delivery_time);
            holder.rate.setText(item.rating);
        } else {
            holder.cardView.setVisibility(View.GONE);
            holder.invisable.setText("Found " + (items.size() - 1) + " results");
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class RestauranttemViewHolder extends RecyclerView.ViewHolder {

        ImageView background;
        TextView name, rate, deliveryPrice, deliverytime, invisable;
        CardView cardView;

        public RestauranttemViewHolder(View itemView) {
            super(itemView);
            background = itemView.findViewById(R.id.iv_restaurant_search_background);
            name = itemView.findViewById(R.id.tv_restaurant_search_name);
            deliveryPrice = itemView.findViewById(R.id.tv_restaurant_search_delivery_price);
            deliverytime = itemView.findViewById(R.id.tv_restaurant_search_delivery_time);
            invisable = itemView.findViewById(R.id.tv_restaurant_search_invisable);
            cardView = itemView.findViewById(R.id.search_restaurant_card);
            rate = itemView.findViewById(R.id.tv_restaurent_search_rate);
        }
    }
}
