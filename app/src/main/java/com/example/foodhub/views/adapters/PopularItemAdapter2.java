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
import com.example.foodhub.data.source.remote.FoodSearch;

import java.util.ArrayList;

public class PopularItemAdapter2 extends RecyclerView.Adapter<PopularItemAdapter2.PopularItemViewHolder> {
    ArrayList<FoodSearch> items = new ArrayList<>();
    Context context;

    public PopularItemAdapter2(Context context, ArrayList<FoodSearch> items) {

        this.items = items;
        this.context = context;
    }

    @Override
    public PopularItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_popular_item, null, false);
        PopularItemViewHolder PopularItemViewHolder = new PopularItemViewHolder(v);
        return PopularItemViewHolder;
    }

    @Override
    public void onBindViewHolder(PopularItemViewHolder holder, int position) {

        FoodSearch item = items.get(position);
        if (position > 0) {
            Glide.with(context)
                    .load("https://direct-app.net/food/" + item.pic) // image url
                    .placeholder(R.drawable.ic_launcher_background) // any placeholder to load at start
                    .error(R.drawable.logo)  // any image in case of error
                    .centerCrop()
                    .into(holder.iv);
            holder.name.setText(item.name);
            holder.people.setText(item.number_of_ratings);
            holder.rate.setText(item.rating);
            holder.description.setText(item.description);
            holder.price.setText(item.price);

        } else {
            holder.cardView.setVisibility(View.GONE);
            holder.invisable.setText("Found " + (items.size() - 1) + " results");
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class PopularItemViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView name, description, price, rate, people, invisable;
        CardView cardView;

        public PopularItemViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_popular_background);
            name = itemView.findViewById(R.id.tv_popular_name);
            description = itemView.findViewById(R.id.tv_popular_description);
            price = itemView.findViewById(R.id.tv_popular_price);
            rate = itemView.findViewById(R.id.tv_popular_rate);
            people = itemView.findViewById(R.id.tv_restaurant_num_people);
            invisable = itemView.findViewById(R.id.tv_popular_invisable);
            cardView = itemView.findViewById(R.id.card);
        }
    }
}
