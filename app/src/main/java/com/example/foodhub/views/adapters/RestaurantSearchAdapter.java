package com.example.foodhub.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;
import com.example.foodhub.data.models.RestaurantSearchItem;

import java.util.ArrayList;

public class RestaurantSearchAdapter extends RecyclerView.Adapter<RestaurantSearchAdapter.RestauranttemViewHolder> {
    ArrayList<RestaurantSearchItem> items = new ArrayList<>();

    public RestaurantSearchAdapter(ArrayList<RestaurantSearchItem> items) {
        this.items = items;
    }

    @Override
    public RestauranttemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_resturant_search, null, false);
        RestauranttemViewHolder resturantItemViewHolder = new RestauranttemViewHolder(v);
        return resturantItemViewHolder;
    }


    @Override
    public void onBindViewHolder(RestauranttemViewHolder holder, int position) {

        if(position>0) {
            RestaurantSearchItem item = items.get(position);
            holder.background.setImageResource(item.getImage());
            holder.name.setText(item.getName());
            holder.deliveryPrice.setText(item.getDeliveryPrice()>0?item.getDeliveryPrice() +" $":"Free");
            holder.deliverytime.setText(item.getDeliverytime());
        }
        else
        {
            holder.cardView.setVisibility(View.GONE);
            holder.invisable.setText("Found 10 results");
        }
    }

    @Override
    public int getItemCount() {
        return items.size()-1;
    }

    class RestauranttemViewHolder extends RecyclerView.ViewHolder {

        ImageView background;
        TextView name, rate, deliveryPrice, deliverytime,invisable;
        CardView cardView;

        public RestauranttemViewHolder(View itemView) {
            super(itemView);
            background = itemView.findViewById(R.id.iv_restaurant_search_background);
            name = itemView.findViewById(R.id.tv_restaurant_search_name);
            deliveryPrice = itemView.findViewById(R.id.tv_restaurant_search_delivery_price);
            deliverytime = itemView.findViewById(R.id.tv_restaurant_search_delivery_time);
            invisable=itemView.findViewById(R.id.tv_restaurant_search_invisable);
            cardView=itemView.findViewById(R.id.search_restaurant_card);
        }
    }
}
